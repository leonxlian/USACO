import java.io.*;
import java.util.*;
public class ClosingTheFarm2 {
	static ArrayList<ArrayList<Integer>> connections=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			connections.add(new ArrayList<Integer>());
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			connections.get(a).add(b);
			connections.get(b).add(a);
		}
		int[] closing=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			closing[i]=Integer.parseInt(st.nextToken())-1;
		}
		DSU dsu=new DSU(n);
		boolean[] result=new boolean[n];
		result[n-1]=true;
		ArrayList<Integer> added=new ArrayList<Integer>();
		added.add(closing[n-1]);
		for(int i=n-2;i>=0;i--) {
			added.add(closing[i]);
			for(int j:added) {
				if(connections.get(j).contains(closing[i])) {
					dsu.union(closing[i], j);
				}
			}
			int temp=dsu.find(closing[n-1]);
			result[i]=true;
			for(int j:added) {
				if(dsu.find(j)!=temp) {
					result[i]=false;
					break;
				}
			}
		}
		for(int i=0;i<n;i++) {
			if(result[i]) {
				//System.out.println("YES");
				pw.println("YES");
			}else {
				//System.out.println("NO");
				pw.println("NO");
			}
		}
		pw.close();
	}
	static class DSU {
		int[] parents;
		int[] rank;
		public DSU(int size) { //constructor
			rank = new int[size];
			parents = new int[size];
			for(int i=0;i<parents.length;i++) {
				parents[i]=i;
			}
		}
		public int find(int x) {
			if(parents[x]==x) {
				return x;
			}
			return parents[x]=find(parents[x]);
		}
		public void union(int x, int y) {
			int rootX=find(x);
			int rootY=find(y);
			if(rootX==rootY) {
				return;
			}
			if(rank[rootX]>rank[rootY]) {
				parents[rootY]=rootX;//rootx stays as parent
			}else {
				parents[rootX]=rootY;
				if(rank[rootX]==rank[rootY]) { //if rank is equal update rank
					rank[rootY]++;
				}
			}
		}
	}
}
