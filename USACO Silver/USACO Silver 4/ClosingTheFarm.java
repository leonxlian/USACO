import java.io.*;
import java.util.*;
public class ClosingTheFarm{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int a[]=new int[m];
		int b[]=new int[m];
		DSU dsu=new DSU(n);
		ArrayList<ArrayList<Integer>>al=new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(new ArrayList<>());
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken())-1;
			b[i]=Integer.parseInt(st.nextToken())-1;
			al.get(a[i]).add(b[i]);
			al.get(b[i]).add(a[i]);
		}
		int arr[]=new int[n];
		for(int i=n-1;i>=0;i--) {
			st=new StringTokenizer(br.readLine());
			arr[i]=Integer.parseInt(st.nextToken())-1;
		}
		ArrayList<Integer>added=new ArrayList<Integer>();
		added.add(arr[0]);
		boolean ans[]=new boolean[n];
		ans[0]=true;
		for(int i=1;i<n;i++) {
			added.add(arr[i]);
			for(int barn:added) {
				if(al.get(barn).contains(arr[i])) {
					dsu.union(barn, arr[i]);
				}
			}
			ans[i]=true;
			for(int barn:added) {
				if(!dsu.isSameSet(arr[i], barn)) {
					ans[i]=false;
				}
			}
		}
		for(int i=n-1;i>=0;i--) {
			//out.println(ans[i]?"YES":"NO");
			pw.println(ans[i]?"YES":"NO");
		}
		//out.close();
		pw.close();
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
