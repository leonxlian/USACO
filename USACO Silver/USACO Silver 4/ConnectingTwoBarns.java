import java.io.*;
import java.util.*;
public class ConnectingTwoBarns{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int t=Integer.parseInt(st.nextToken());
		while(t-->0) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			DSU dsu=new DSU(n);
			for(int i=0;i<m;i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken())-1;
				int y=Integer.parseInt(st.nextToken())-1;
				dsu.union(x, y);
			}
			if(dsu.numDisjointSets()==1) {
				out.println(0);
				continue;
			}
			TreeSet<Long>first=new TreeSet<>();
			int firsthead=dsu.find(0);
			int lasthead=dsu.find(n-1);
			TreeSet<Long>last=new TreeSet<>();
			for(int i=0;i<n;i++) {
				if(dsu.find(i)==firsthead) {
					first.add((long)i);
				}
				if(dsu.find(i)==lasthead) {
					last.add((long)i);
				}
			}
			long ans=Long.MAX_VALUE;
			long toFirstDist[]=new long[n];
			long toLastDist[]=new long[n];
			Arrays.fill(toFirstDist, Long.MAX_VALUE);
			Arrays.fill(toLastDist, Long.MAX_VALUE);
			for(int i=0;i<n;i++) {
				Long ceilingF=first.ceiling((long)i);
				Long floorF=first.floor((long)i);
				Long ceilingL=last.ceiling((long)i);
				Long floorL=last.floor((long)i);
				int head=dsu.find(i);
				if(ceilingF!=null) {
					toFirstDist[head]=Math.min(toFirstDist[head], (long)(ceilingF-i)*(ceilingF-i));
				}
				if(floorF!=null) {
					toFirstDist[head]=Math.min(toFirstDist[head], (long)(floorF-i)*(floorF-i));
				}
				if(ceilingL!=null) {
					toLastDist[head]=Math.min(toLastDist[head], (long)(ceilingL-i)*(ceilingL-i));
				}
				if(floorL!=null) {
					toLastDist[head]=Math.min(toLastDist[head], (long)(floorL-i)*(floorL-i));
				}
				if(toFirstDist[head]!=Long.MAX_VALUE&&toLastDist[head]!=Long.MAX_VALUE) {
					ans=Math.min(ans, toFirstDist[head]+toLastDist[head]);
				}
			}
			out.println(ans);
		}
		out.close();
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
