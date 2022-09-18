import java.io.*;
import java.util.*;
public class TamingTheHerd {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    int n=Integer.parseInt(st.nextToken());
	    int a[]=new int[n];
	    st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	    	a[i]=Integer.parseInt(st.nextToken());
	    }
	    for(int l=1;l<=n;l++) {
	    	//each element, cur element is x, breakout number
	    	//hold minimum number being tampered
	    	int dp[][][]=new int[n+1][101][l+1];
	    	for(int i=0;i<=n;i++) {
	    		for(int j=0;j<=100;j++) {
	    			Arrays.fill(dp[i][j], Integer.MAX_VALUE);
	    		}
	    	}
	    	dp[0][0][0]=0;
	    	for(int i=0;i<n;i++) {
	    		if(i==0) {
	    			if(a[i]==0) {
	    				dp[i+1][0][1]=Math.min(dp[i+1][0][1], dp[i][0][0]);
	    			}else {
	    				dp[i+1][0][1]=Math.min(dp[i+1][0][1], dp[i][0][0]+1);
	    			}
	    			continue;
	    		}
	    		for(int j=0;j<100;j++) {
	    			for(int k=1;k<=l;k++) {
	    				if(dp[i][j][k]==Integer.MAX_VALUE) {
	    					continue;
	    				}
	    				if(k==l) {
	    					if(a[i]==j+1) {
		    					dp[i+1][j+1][k]=Math.min(dp[i+1][j+1][k], dp[i][j][k]);
		    				}else {
		    					dp[i+1][j+1][k]=Math.min(dp[i+1][j+1][k], dp[i][j][k]+1);
		    				}
	    					continue;
	    				}
	    				if(a[i]==j+1) {
	    					dp[i+1][j+1][k]=Math.min(dp[i+1][j+1][k], dp[i][j][k]);
	    				}else {
	    					dp[i+1][j+1][k]=Math.min(dp[i+1][j+1][k], dp[i][j][k]+1);
	    				}
	    				if(a[i]==0) {
	    					dp[i+1][0][k+1]=Math.min(dp[i+1][0][k+1], dp[i][j][k]);
	    				}else {
	    					dp[i+1][0][k+1]=Math.min(dp[i+1][0][k+1], dp[i][j][k]+1);
	    				}
	    			}
	    		}
	    	}
	    	int ans=Integer.MAX_VALUE;
	    	for(int i=0;i<=100;i++) {
	    		ans=Math.min(ans, dp[n][i][l]);
	    	}
	    	out.println(ans);
	    	pw.println(ans);
	    }
	    //out.close();
	    pw.close();
	}
}
