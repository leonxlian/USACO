import java.io.*;
import java.util.*;
public class WormholeSort {
	static int p[];
	static boolean v[];
	static ArrayList<ArrayList<pair>> adj = new ArrayList<ArrayList<pair>>();
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		p=new int[n];
		v=new boolean[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<pair>());
		}
		for(int i=0;i<n;i++) {
			p[i]=Integer.parseInt(st.nextToken())-1;
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			adj.get(a).add(new pair(b, w));
			adj.get(b).add(new pair(a, w));
		}
		int low=0;
		int high=1000000000;
		while(low<high) {
			int mid=(low+high+1)/2;
			if(check(mid)) {
				low=mid;
			}else {
				high=mid-1;
			}
			Arrays.fill(v, false);
		}
		if(low==1000000000) {
			System.out.println(-1);
			//pw.println(-1);
		}else {
			System.out.println(low);
			//pw.println(low);
		}
		//pw.close();
	}
	static boolean check(int n) {
		dfs(0, n); //dfs from  0, if unable to traverse all then return false, 
		for(int i=0;i<v.length;i++) {//if all is traversed then return true
			if ((!v[i] || !v[p[i]]) && i != p[i]) {
				return false;
			}
		}
		return true;
	}
	static void dfs(int n, int x) { //dfs
		if (v[n]) return;
		v[n] = true;
		for (pair p : adj.get(n)) {// check adjacency lists
			if (p.width >= x) {
				dfs(p.loc, x); //dfs location of neighbor, traverse graph
			}
		}
	}
	static class pair{
		public int loc, width;  
		public pair(int loc, int width) {
			this.loc=loc;
			this.width=width;
		}
	}
}    
