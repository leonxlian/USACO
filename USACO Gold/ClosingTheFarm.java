import java.io.*;
import java.util.*;
public class ClosingTheFarm {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PrintWriter out=new PrintWriter(System.out);
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<String> ans=new ArrayList<String>();
        ArrayList<ArrayList<Integer>>connections=new ArrayList<>();
        for(int i=0;i<n;i++) {
        	connections.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken())-1;
        	int y=Integer.parseInt(st.nextToken())-1;
        	connections.get(x).add(y);
        	connections.get(y).add(x);
        }
        int a[]=new int[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	a[i]=Integer.parseInt(st.nextToken())-1;
        }
        DSU dsu=new DSU(n);
        boolean v[]=new boolean[n];
        int j=1;
        for(int i=n-1;i>=0;i--) {
        	v[a[i]]=true;
        	for(int next:connections.get(a[i])) {
        		if(v[next]) {
        			dsu.union(next, a[i]);
        		}
        	}
        	if(dsu.sizeOfSet(a[i])==j) {
        		ans.add("YES");
        	}else {
        		ans.add("NO");
        	}
        	j++;
        }
        for(int i=ans.size()-1;i>=0;i--) {
        	//out.println(ans.get(i));
        	pw.println(ans.get(i));
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
