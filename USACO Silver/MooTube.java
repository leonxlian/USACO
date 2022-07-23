import java.io.*;
import java.util.*;
public class MooTube {
	static ArrayList<ArrayList<state>>connections=new ArrayList<ArrayList<state>>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			connections.add(new ArrayList<state>());
		}
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			int r=Integer.parseInt(st.nextToken());
			connections.get(a).add(new state(b, r));
			connections.get(b).add(new state(a, r));
		}
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken())-1;
			int ans=0;
			ArrayDeque<Integer>x=new ArrayDeque<Integer>();
			x.add(v);
			boolean visited[]=new boolean[n];
			visited[v]=true;
			while(!x.isEmpty()) {
				int cur=x.poll();
				for(state next:connections.get(cur)) {
					if(!visited[next.d]&&next.w>=k) {
						visited[next.d]=true;
						x.addLast(next.d);
						ans++;
					}
				}
			}
			//System.out.println(ans);
			pw.println(ans);
		}
		pw.close();
	}
	static class state{
		int d, w;
		public state(int d, int w) {
			this.d=d; this.w=w;
		}
	}
}
