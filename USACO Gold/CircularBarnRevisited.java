import java.io.*;
import java.util.*;
public class CircularBarnRevisited {
	public static PrintWriter out;
	static int MAXN=105;
	static int MAXK=8;
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader("cbarn2.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn2.out")));
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
	    long ans=Long.MAX_VALUE;
	    //exit k, position n
	    long dp[][]=new long[MAXK][MAXN];
	    /*
	     rotate array and fix starting point
	     */
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<MAXK;j++) {
	    		Arrays.fill(dp[j], Integer.MAX_VALUE);
	    	}
	    	dp[0][n]=0;
	    	for(int c=1;c<=k;c++) {
	    		for(int j=0;j<n;j++) {
	    			long sum=0;
	    			for(int l=j+1;l<=n;l++) {//loop through previous positions, go to the right and sum the values
	    				sum+=a[l-1]*(l-j-1);
	    				dp[c][j]=Math.min(dp[c][j], dp[c-1][l]+sum);
	    			}
	    		}
	    	}
	    	ans=Math.min(ans, dp[k][0]);
	    	rotateLeft(a, 1, n);
	    }
	    out.println(ans);
	    pw.println(ans);
	    pw.close();
	    //out.close();
	}
	static void rotateLeft(int arr[], int d, int n) {
		int temp[]=new int[d];
		for(int i=0;i<d;i++) {
			temp[i]=arr[i];
		}
		for(int i=d;i<n;i++) {
			arr[i-d]=arr[i];
		}
		for(int i=0;i<d;i++) {
			arr[i+n-d]=temp[i];
		}
	}
	static void rotateRight(int arr[], int d, int n) {
		int temp[]=new int[n-d];
		for(int i=0;i<n-d;i++) {
			temp[i]=arr[i];
		}
		for(int i=n-d;i<n;i++) {
			arr[i-n+d]=arr[i];
		}
		for(int i=0;i<n-d;i++) {
			arr[i+d]=temp[i];
		}
	}
	
}
