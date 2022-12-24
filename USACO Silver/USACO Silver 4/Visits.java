import java.io.*;
import java.util.*;
public class Visits{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		ArrayList<Triple>al=new ArrayList<>();
		long ans=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken());
			al.add(new Triple(x, v, i));
		}
		Collections.sort(al);
		DSU dsu=new DSU(n);
		for(Triple a:al) {
			//out.println(a.x+" "+a.v+" "+a.i);
			if(!dsu.isSameSet(a.x, a.i)) {
				dsu.union(a.x, a.i);
				ans+=a.v;
			}
		}
		out.println(ans);
		out.close();
	}
	static class Triple implements Comparable<Triple>{
		int x, v, i;
		public Triple(int x, int v, int i) {
			this.x=x;this.v=v;this.i=i;
		}
		public int compareTo(Triple o) {
			if(v==o.v) {
				if(i==o.i) {
					return x-o.x;
				}else {
					return i-o.i;
				}
			}else {
				return o.v-v;
			}
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
