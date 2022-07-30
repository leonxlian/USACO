import java.io.*;
import java.util.*;
public class Moocast {
	public static PrintWriter out;
	static int n;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    n=Integer.parseInt(st.nextToken());
	    int x[]=new int[n];
	    int y[]=new int[n];
	    for(int i=0;i<n;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	x[i]=Integer.parseInt(st.nextToken());
	    	y[i]=Integer.parseInt(st.nextToken());
	    }
	    ArrayList<edge>edges=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	for(int j=i+1;j<n;j++) {
	    		int dist=(y[i]-y[j])*(y[i]-y[j])+(x[i]-x[j])*(x[i]-x[j]);
	    		edges.add(new edge(i, j, dist));
	    	}
	    }
	    Collections.sort(edges);
	    DSU dsu=new DSU(n);
	    int ans=0;
	    for(edge e:edges) {
	    	dsu.union(e.a, e.b);
	    	ans=e.weight;
	    	if(dsu.numDisjointSets()==1) {
	    		break;
	    	}
	    }
	    out.println(ans);
	    pw.println(ans);
	    pw.close();
	    //out.close();
	}
	static class edge implements Comparable<edge>{
		int a, b, weight;
		public edge(int a, int b, int weight) {
			this.a=a;this.b=b;this.weight=weight;
		}
		public int compareTo(edge o) {
			return Integer.compare(weight, o.weight);
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
