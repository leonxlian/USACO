import java.io.*;
import java.util.*;
public class Teamwork {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
	      BufferedReader br = new BufferedReader(new FileReader("teamwork.in"));
	      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teamwork.out")));
	      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      out = new PrintWriter(System.out);
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      int n=Integer.parseInt(st.nextToken());
	      int k=Integer.parseInt(st.nextToken());
	      int a[]=new int[n];
	      for(int i=0;i<n;i++) {
	    	  st=new StringTokenizer(br.readLine());
	    	  a[i]=Integer.parseInt(st.nextToken());
	      }
	      long dp[]=new long[n+1];
	      for(int i=1;i<=n;i++) {
	    	  int max=a[i-1];
	    	  for(int j=1;j<=k;j++) {
	    		  if(i==1) {
	    			  dp[i]=a[i-1];
	    			  continue;
	    		  }
	    		  if(i-j>=0) {
	    			  //System.out.println(i+" "+j);
	    			  max=Math.max(max, a[i-j]);
	    			  dp[i]=Math.max(dp[i], j*max+dp[i-j]);
	    		  }
	    	  }
	      }
	      /*for(int i=0;i<=n;i++) {
	    	  out.print(dp[i]+" ");
	      }*/
	      //out.println();
	      //out.println(dp[n]);
	      pw.println(dp[n]);
	      pw.close();
	      //out.close();
	}
}
