import java.io.*;
import java.util.*;
public class HoofPaperScissors {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int s[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			if(str.equals("H")) {
				s[i]=0;
			}else if(str.equals("P")) {
				s[i]=1;
			}else {
				s[i]=2;
			}
		}
		//make k+1 decisions
		int dp[][][]=new int[n+1][k+2][3];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=k+1;j++) {
				//choose hoof
				int count=count(0, s[i-1]);
				dp[i][j][0]=Math.max(dp[i-1][j][0], Math.max(dp[i-1][j-1][1], dp[i-1][j-1][2]))+count;
				
				//choose paper
				count=count(1, s[i-1]);
				dp[i][j][1]=Math.max(dp[i-1][j][1], Math.max(dp[i-1][j-1][2], dp[i-1][j-1][0]))+count;
				
				//choose scissors
				count=count(2, s[i-1]);
				dp[i][j][2]=Math.max(dp[i-1][j][2], Math.max(dp[i-1][j-1][0], dp[i-1][j-1][1]))+count;
				//out.println(dp[i][j][0]+" "+dp[i][j][1]+" "+dp[i][j][2]);
			}
		}
		//out.println(Math.max(dp[n][k+1][1], Math.max(dp[n][k+1][2], dp[n][k+1][0])));
		pw.println(Math.max(dp[n][k+1][1], Math.max(dp[n][k+1][2], dp[n][k+1][0])));
		pw.close();
		//out.close();
	}
	public static int count(int a, int b) {
		if(a==0&&b==2) {
			return 1;
		}else if(a==1&&b==0) {
			return 1;
		}else if(a==2&&b==1) {
			return 1;
		}
		return 0;
	}
}
