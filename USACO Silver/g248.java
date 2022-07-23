import java.io.*;
import java.util.*;
public class g248 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("248.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("248.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		int ans=0;
		int dp[][]=new int[n][n];
		for(int l=1;l<=n;l++) {//length
			for(int start=0;start+l<=n;start++) {//start plus length must be less than array size
				int end=start+l-1;
				if(l==1) {
					dp[start][end]=a[start];
				}
				for(int cur=start;cur<end;cur++) {
					if(dp[start][cur]==dp[cur+1][end]&&dp[start][cur]!=0) {
						dp[start][end]=Math.max(dp[start][end], dp[start][cur]+1);//get either right now value, or the start to cur value +1 because of the neighboring equal
					}
				}
				ans=Math.max(dp[start][end], ans);
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
