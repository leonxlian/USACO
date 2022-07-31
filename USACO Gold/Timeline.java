import java.io.*;
import java.util.*;
public class Timeline {
	public static PrintWriter out;
	static ArrayList<ArrayList<Pair>>al;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("timeline.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("timeline.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int ans[]=new int[n];
		st=new StringTokenizer(br.readLine());
		al=new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(new ArrayList<Pair>());
			ans[i]=Integer.parseInt(st.nextToken());
		}
		int in_degree[]=new int[n];
		for(int i=0;i<c;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			int val=Integer.parseInt(st.nextToken());
			in_degree[y]++;
			al.get(x).add(new Pair(y, val));
		}
		//int ans[]=new int[n];
		ArrayDeque<Integer>q=new ArrayDeque<>();
		//kahn's algo
		for(int i=0;i<n;i++) {
			if(in_degree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int cur=q.poll();
			for(Pair next:al.get(cur)) {
				int neigh=next.x;
				int val=next.y;
				ans[neigh]=Math.max(ans[neigh], ans[cur]+val);
				in_degree[neigh]--;
				if(in_degree[neigh]==0) {
					q.add(neigh);
				}
			}
		}
		for(int i:ans) {
			//out.println(i);
			pw.println(i);
		}
		pw.close();
		//out.close();
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
	}
}
