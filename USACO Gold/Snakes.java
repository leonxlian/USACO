import java.io.*;
import java.util.*;
public class Snakes {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
	      BufferedReader br = new BufferedReader(new FileReader("snakes.in"));
	      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snakes.out")));
	      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      out = new PrintWriter(System.out);
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      int n=Integer.parseInt(st.nextToken());
	      int k=Integer.parseInt(st.nextToken());
	      st=new StringTokenizer(br.readLine());
	      int a[]=new int[n+1];
	      for(int i=0;i<n;i++) {
	    	  a[i+1]=Integer.parseInt(st.nextToken());
	      }
	      long dp[][]=new long[n+1][k+1];//min size needed for i snakes with k change
	      for(int i=1;i<=n;i++) {
	    	  for(int j=1;j<=k;j++) {
	    		  dp[i][j]=Long.MAX_VALUE;
	    	  }
	      }
	      int max=0;
	      long sum=0;
	      for(int i=1;i<=n;i++) {
	    	  max=Math.max(a[i], max);
	    	  dp[i][0]=max*i;
	    	  for(int j=1;j<=k;j++) {//j changes
	    		  int max2=a[i];
	    		  for(int l=i-1;l>=0;l--) {//loop to last place
	    			  dp[i][j]=Math.min(dp[i][j], dp[l][j-1]+max2*(i-l));
	    			  max2=Math.max(max2, a[l]);
	    		  }
	    	  }
	    	  sum+=a[i];
	      }
	      //out.println(dp[n][k]-sum);
	      pw.println(dp[n][k]-sum);
	      pw.close();
	      //out.close();
	}
}