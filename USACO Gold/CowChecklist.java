import java.io.*;
import java.util.*;
public class CowChecklist{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("checklist.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("checklist.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int hCount=Integer.parseInt(st.nextToken());
		int gCount=Integer.parseInt(st.nextToken());
		Pair h[]=new Pair[hCount];
		for(int i=0;i<hCount;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			h[i]=new Pair(x, y);
		}
		Pair g[]=new Pair[gCount];
		for(int i=0;i<gCount;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			g[i]=new Pair(x, y);
		}
		long dp[][][]=new long[hCount+1][gCount+1][2];
		for(int i=0;i<=hCount;i++) {
			for(int j=0;j<=gCount;j++) {
				dp[i][j][0]=(long) 2e9;
				dp[i][j][1]=(long) 2e9;
			}
		}
		dp[1][0][0]=0;
		for(int i=0;i<=hCount;i++) {
			for(int j=0;j<=gCount;j++) {
				if(i>=2) {//previous one was an h, and current one is an h
					dp[i][j][0]=Math.min(dp[i][j][0], dp[i-1][j][0]+calculate(h[i-1], h[i-2]));
				}
				if(j>=2) {//previous one was an g, and current one is an g
					dp[i][j][1]=Math.min(dp[i][j][1], dp[i][j-1][1]+calculate(g[j-1], g[j-2]));
				}
				if(i>0&&j>0) {
					//current one is h previous is g
					dp[i][j][0]=Math.min(dp[i][j][0], dp[i-1][j][1]+calculate(h[i-1], g[j-1]));
					//current one is g previous is h
					dp[i][j][1]=Math.min(dp[i][j][1], dp[i][j-1][0]+calculate(h[i-1], g[j-1]));
				}
			}
		}
		//out.println(dp[hCount][gCount][0]);
		//out.close();
		pw.println(dp[hCount][gCount][0]);
		pw.close();
	}
	static long calculate(Pair one, Pair two) {
		return (long)(one.x-two.x)*(one.x-two.x)+(long)(one.y-two.y)*(one.y-two.y);
	}
	static class Pair{
		public int x, y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
