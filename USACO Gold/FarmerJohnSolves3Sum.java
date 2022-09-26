import java.io.*;
import java.util.*;
public class FarmerJohnSolves3Sum {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("threesum.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("threesum.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int q=Integer.parseInt(st.nextToken());
	    st=new StringTokenizer(br.readLine());
	    int a[]=new int[n];
	    for(int i=0;i<n;i++) {
	    	a[i]=Integer.parseInt(st.nextToken());
	    }
	    long dp[][]=new long[n][n];
	    int cnt[]=new int[(int) (2e6+1)];
	    for(int i=n-1;i>=0;i--) {
	    	for(int j=i+1;j<n;j++) {
	    		int diff=1000000-a[i]-a[j];
	    		if(diff>=0&&diff<=2000000) {
	    			dp[i][j]=cnt[diff];
	    		}
	    		cnt[1000000+a[j]]++;
	    	}
	    	for(int j=i+1;j<n;j++) {
	    		cnt[1000000+a[j]]=0;
	    	}
	    }
	    for(int i=n-1;i>=0;i--) {
	    	for(int j=i+1;j<n;j++) {
	    		dp[i][j]+=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
	    	}
	    }
	    while(q-->0) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken())-1;
	    	int y=Integer.parseInt(st.nextToken())-1;
	    	out.println(dp[x][y]);
	    	pw.println(dp[x][y]);
	    }
	    pw.close();
	    //out.close();
	}
}
