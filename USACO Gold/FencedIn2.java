import java.io.*;
import java.util.*;
public class FencedIn2 {
	static int v[];
	static int h[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("fencedin.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fencedin.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        Integer[] a=new Integer[n+2],b=new Integer[m+2];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	a[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	b[i]=Integer.parseInt(st.nextToken());
        }
        a[n]=0;
        a[n+1]=A;
        b[m]=0;
        b[m+1]=B;
        Arrays.sort(a);
        Arrays.sort(b);
        PriorityQueue<Pair> q1=new PriorityQueue<>();
        for(int i=1;i<=n+1;i++) {
        	q1.add(new Pair(a[i]-a[i-1],i-1));
        }

        PriorityQueue<Pair> q2=new PriorityQueue<>();
        for(int i=1;i<=m+1;i++) {
        	q2.add(new Pair(b[i]-b[i-1],i-1));
        }

        long ans=0;
        DSU dsu=new DSU((n+1)*(m+1));
        while(q1.size()>0||q2.size()>0) {
            if(q2.size()==0||(q1.size()>0&&q1.peek().a<q2.peek().a)) {
                Pair cur=q1.poll();
                for(int i=0;i<m;i++) {
                    int ID=i*(n+1)+cur.b;
                    int connectID=(i+1)*(n+1)+cur.b;
                    //System.out.println(ID+" "+connectID+" "+cur.a+" "+cur.b+" "+i+" A");
                    if(!dsu.isSameSet(ID,connectID)) {
                        dsu.union(ID,connectID);
                        ans+=cur.a;
                    }
                }
            } else {
                Pair cur=q2.poll();
                for(int i=0;i<n;i++) {
                    int ID=cur.b*(n+1)+i;
                    int connectID=cur.b*(n+1)+(i+1);
                    //System.out.println(ID+" "+connectID+" "+cur.a+" "+cur.b+" B");
                    if(!dsu.isSameSet(ID,connectID)) {
                    	dsu.union(ID,connectID);
                        ans+=cur.a;
                    }
                }
            }
        } 
        //System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
	static class Pair implements Comparable<Pair>{
		public int a, b;
		public Pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
		public int compareTo(Pair o) {
			return a-o.a;
		}
	}
	static class DSU {
        int[] parents;
        int[] rank;
        int[] setSize;
        int numSets;
        public DSU(int N) {
            parents=new int[numSets=N];
            rank=new int[N];
            setSize=new int[N];
            for(int i=0;i<N;i++) {
                parents[i]=i;
                setSize[i]=1;
            }
        }
        public int find(int i) { 
        	return parents[i] == i ? i : (parents[i] = find(parents[i])); 
        }
        public boolean isSameSet(int i, int j) { 
        	return find(i) == find(j); 
        }
        public void union(int i,int j) {
            if (isSameSet(i, j)) {
            	return;
            }
            numSets--;
            int x=find(i);
            int y=find(j);
            if(rank[x]>rank[y]) {
                parents[y] = x; setSize[x] += setSize[y];
            }else {
                parents[x] = y; setSize[y] += setSize[x];
                if(rank[x] == rank[y]) rank[y]++;
            }
        }
        public int numDisjointSets() { 
        	return numSets; 
        }
        public int sizeOfSet(int i) { 
        	return setSize[find(i)]; 
        }
    }
}

/*
for(int i=2;i<n+2;i++) {
        	st=new StringTokenizer(br.readLine());
        	v[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=2;i<m+2;i++) {
        	st=new StringTokenizer(br.readLine());
        	h[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(v);
        Arrays.sort(h);
        //Edge[] edges=new Edge[10000000];
        ArrayList<Edge>edges=new ArrayList<>();
        for(int i=0;i<=n;i++) {
        	for(int j=0;j<=m;j++) {
        		if(i+1<=n) {
        			int diff=h[j+1]-h[j];
        			edges.add(new Edge(i+(j*(n+1)), (i+1)+(j*(n+1)), diff));
        		}
        		if(j+1<=m) {
        			int diff=v[i+1]-v[i];
        			edges.add(new Edge(i+(j*(n+1)), i+(j+1)*(n+1), diff));
        		}
        	}
        }
        Collections.sort(edges);
        DSU dsu=new DSU(4004003);
        long ans=0;
        for(int i=0;i<edges.size();i++) {
        	Edge e=edges.get(i);
        	if(dsu.find(e.x)!=dsu.find(e.y)) {
        		dsu.union(e.x, e.y);
        		ans+=e.w;
        	}
        }*/
