import java.io.*;
import java.util.*;
public class Moocast{
	public static PrintWriter out;
	static boolean isReachable[][];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int x[]=new int[n];
		int y[]=new int[n];
		int p[]=new int[n];
		isReachable=new boolean[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int ydist=y[j]-y[i];
				int xdist=x[j]-x[i];
				if(p[i]*p[i]>=xdist*xdist+ydist*ydist) {
					isReachable[i][j]=true;
				}
			}
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			boolean v[]=new boolean[n];
			ArrayDeque<Integer>q=new ArrayDeque<>();
			q.add(i);
			v[i]=true;
			for(int j=0;j<n;j++) {
				if(isReachable[i][j]) {
					q.add(j);
					v[j]=true;
				}
			}
			while(!q.isEmpty()) {
				int cur=q.poll();
				for(int j=0;j<n;j++) {
					if(isReachable[cur][j]&&!v[j]) {
						v[j]=true;
						q.add(j);
					}
				}
			}
			int count=0;
			for(int j=0;j<n;j++) {
				if(v[j]) {
					count++;
				}
			}
			ans=Math.max(ans, count);
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
}
