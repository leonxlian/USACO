import java.io.*;
import java.util.*;
public class WormholeSort{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken())-1;
		}
		Triple t[]=new Triple[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken());
			t[i]=new Triple(x, y, v);
		}
		Arrays.sort(t);
		int count=-1;
		int last=-1;
		DSU dsu=new DSU(n);
		for(int i=n-1;i>=0;i--) {
			while(!dsu.isSameSet(i, a[i])) {
				count++;
				dsu.union(t[count].a, t[count].b);
			}
		}
		//out.println(count==-1?-1:t[count].v);
		//out.close();
		pw.println(count==-1?-1:t[count].v);
		pw.close();
	}
	static class Triple implements Comparable<Triple>{
		int a, b, v;
		public Triple(int a, int b, int v) {
			this.a=a;this.b=b;this.v=v;
		}
		public int compareTo(Triple o) {
			return o.v-v;
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
