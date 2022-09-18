import java.io.*;
import java.util.*;
public class Drought {
	public static PrintWriter out;
	static int mod=(int) (1e9+7);
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    int n=Integer.parseInt(st.nextToken());
	    int a[]=new int[n];
	    st=new StringTokenizer(br.readLine());
	    int min=Integer.MAX_VALUE;
	    for(int i=0;i<n;i++) {
	    	a[i]=Integer.parseInt(st.nextToken());
	    	min=Math.min(min, a[i]);
	    }
	    long ans=0;
	    if(n%2==0) {
	    	long dp[][]=new long[101][1001];
 		    for(int j=0;j<=a[0];j++) {
 	    		dp[1][j]=1;
 	    	}
 		    //dp[cur][diff], push dp, new diff=new hunger-olddiff
 		    for(int i=1;i<n;i++) {
 		    	for(int j=0;j<=a[i-1];j++) {
 		    		for(int k=j;k<=a[i];k++) {
 		    			dp[i+1][k-j]+=dp[i][j];
 		    			dp[i+1][k-j]%=mod;
 		    		}
 		    	}
 		    }
 		    ans+=dp[n][0];
 		    out.println(ans);
	    }else {
	    	 while(min-->=0) {
	 		    long dp[]=new long[1001];
	 		    long pre[]=new long[1001];
	 		    for(int i=0;i<=a[0];i++) {
	 		    	pre[i]=i+1;
	 		    }
	 		    for(int i=a[0]+1;i<=1000;i++) {
	 		    	pre[i]=a[0]+1;
	 		    }
	 		    //dp[difference between cur and next]
	 		    //diff between cur and prev
	 		    //dp[cur diff]=sum of all[j=difference, to max hunger of current];
	 		    //pre[]
	 		    for(int i=2;i<=n;i++) {
	 		    	Arrays.fill(dp, 0);
	 		    	for(int j=0;j<=a[i-1];j++) {
	 		    		dp[j]=pre[a[i-1]-j];//if j is 0, then whole range, if diff is one then n-1 range etc
	 		    		if(dp[j]>=mod){
	 		    		    dp[j]-=mod;
	 		    		}
	 		    	}
	 		    	for(int j=0;j<1001;j++) {
	 		    		pre[j]=dp[j];
	 		    		if(j>0) {
	 		    			pre[j]+=pre[j-1];
	 		    		}
	 		    		if(pre[j]>=mod){
	 		    		    pre[j]-=mod;
	 		    		}
	 		    	}
	 		    }
	 		    ans+=pre[0];
	 		    for(int i=0;i<n;i++) {
	 		    	a[i]--;
	 		    }
	 		    ans%=mod;
	 	    }
	    	out.println(ans%mod);
	    }
	    out.close();
	}
}
