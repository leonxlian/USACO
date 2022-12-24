import java.io.*;
import java.util.*;
public class MooTube {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int Q=Integer.parseInt(st.nextToken());
		ArrayList<ArrayList<state>>al=new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(new ArrayList<state>());
		}
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int p=Integer.parseInt(st.nextToken())-1;
			int q=Integer.parseInt(st.nextToken())-1;
			int r=Integer.parseInt(st.nextToken());
			al.get(p).add(new state(q, r));
			al.get(q).add(new state(p, r));
		}
		for(int i=0;i<Q;i++) {
			boolean v[]=new boolean[n];
			st=new StringTokenizer(br.readLine());
			int k=Integer.parseInt(st.nextToken());
			int val=Integer.parseInt(st.nextToken())-1;
			ArrayDeque<Integer>q=new ArrayDeque<Integer>();
			int ans=0;
			q.add(val);
			v[val]=true;
			while(!q.isEmpty()) {
				int cur=q.poll();
				for(state next:al.get(cur)) {
					if(!v[next.d]&&next.w>=k) {
						v[next.d]=true;
						q.add(next.d);
						ans++;
					}
				}
			}
			out.println(ans);
			pw.println(ans);
		}
		pw.close();
		out.close();
	}
	static class state{
		int d, w;
		public state(int d, int w) {
			this.d=d; this.w=w;
		}
	}
}
