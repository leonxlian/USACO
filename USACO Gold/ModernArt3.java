import java.io.*;
import java.util.*;
public class ModernArt3 {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("atlarge.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("atlarge.out")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    st=new StringTokenizer(br.readLine());
	    int a[]=new int[n];
	    for(int i=0;i<n;i++) {
	    	a[i]=Integer.parseInt(st.nextToken());
	    }
	    int dp[][]=new int[n][n];
	    for(int i=0;i<n;i++) {
	    	Arrays.fill(dp[i], (int)1e9);
	    	dp[i][i]=1;
	    }
	    for(int k=0;k<n;k++) {
	    	for(int i=0;i<n-k;i++) {
	    		for(int j=i;j<i+k;j++) {
	    			int l=i+k;
	    			if(a[i]==a[l]) {
	    				dp[i][l]=Math.min(dp[i][l], dp[i][j]+dp[j+1][l]-1);
	    			}
	    			dp[i][l]=Math.min(dp[i][l], dp[i][j]+dp[j+1][l]);
	    		}
	    	}
	    }
	    out.println(dp[0][n-1]);
	    //pw.close();
	    out.close();
	}
}
