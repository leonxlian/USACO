import java.io.*;
import java.util.*;
public class WormholeSort {
	static int p[];
	static ArrayList<ArrayList<Pair>> connections=new ArrayList<>();
	static boolean visited[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("wormsort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		p=new int[n];
		visited=new boolean[n];
		for(int i=0;i<n;i++) {
			connections.add(new ArrayList<Pair>());
		}
		for(int i=0;i<n;i++) {
			p[i]=Integer.parseInt(st.nextToken())-1;
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken());
			connections.get(a).add(new Pair(b, c));
			connections.get(b).add(new Pair(a, c));
		}
		int low=0;
		int high=1000000000;
		while(low!=high) {
			int mid=(low+high+1)/2;
			if(check(mid)) {
				low=mid;
			}else {
				high=mid-1;
			}
			Arrays.fill(visited, false);
		}
		if(low==1000000000) {
			//System.out.println(-1);
			pw.println(-1);
		}else {
			//System.out.println(low);
			pw.println(low);
		}
		pw.close();
	}
	public static boolean check(int mid) {
		dfs(mid);
		for(int i=0;i<visited.length;i++) {
			if((!visited[i])&&i!=p[i]) {
				return false;
			}
		}
		return true;
	}
	public static void dfs(int mid) {
		visited[0]=true;
		ArrayDeque<Integer> q=new ArrayDeque<Integer>();
		q.add(0);
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(Pair next:connections.get(cur)) {
				if(next.width>=mid) {
					if(!visited[next.loc]) {
						visited[next.loc]=true;
						q.add(next.loc);
					}
				}
			}
		}
	}
	static class Pair{
		public int loc, width;  
		public Pair(int loc, int width) {
			this.loc=loc;
			this.width=width;
		}
	}
}
