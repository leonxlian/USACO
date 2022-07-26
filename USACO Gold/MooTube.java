import java.io.*;
import java.util.*;
public class MooTube {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PrintWriter out=new PrintWriter(System.out);
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        State entry[]=new State[n-1];
        for(int i=0;i<n-1;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	int r=Integer.parseInt(st.nextToken());
        	entry[i]=new State(a, b, r);
        }
        Arrays.sort(entry);
        DSU dsu=new DSU(n);
        Triple a[]=new Triple[m];
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int k=Integer.parseInt(st.nextToken());
        	int video=Integer.parseInt(st.nextToken())-1;
        	a[i]=new Triple(k, video, i);
        }
        Arrays.sort(a);
        int index=0;
        int ret[]=new int[m];
        for(Triple t:a) {
        	while(index<entry.length&&entry[index].r>=t.k) {
        		dsu.union(entry[index].f, entry[index].s);
        		index++;
        	}
        	ret[t.i]=dsu.sizeOfSet(t.v)-1;
        }
        for(int i:ret) {
        	//out.println(i);
        	pw.println(i);
        }
        pw.close();
        //out.close();
	}
	static class State implements Comparable<State>{
		public int f, s, r;
		public State(int f, int s, int r) {
			this.f=f;this.s=s;this.r=r;
		}
		public int compareTo(State o) {
			return o.r-r;
		}
	}
	static class Triple implements Comparable<Triple>{
		public int k, v, i;
		public Triple(int k, int v, int i) {
			this.k=k;this.v=v;this.i=i;
		}
		public int compareTo(Triple o) {
			return o.k-k;
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
