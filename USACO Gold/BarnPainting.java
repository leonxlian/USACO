import java.io.*;
import java.util.*;
public class BarnPainting {
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	static long dp[][];
	static int mod=(int) (1e9+7);
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("barnpainting.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("barnpainting.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int color=Integer.parseInt(st.nextToken());
	    al=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	al.add(new ArrayList<Integer>());
	    }
	    for(int i=0;i<n-1;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken())-1;
	    	int b=Integer.parseInt(st.nextToken())-1;
	    	al.get(a).add(b);
	    	al.get(b).add(a);
	    }
	    dp=new long[n][3];
	    for(int i=0;i<n;i++) {
	    	Arrays.fill(dp[i], 1);
	    }
	    for(int i=0;i<color;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken())-1;
	    	int c=Integer.parseInt(st.nextToken())-1;
	    	if(c==0) {
	    		dp[a][1]=0;
	    		dp[a][2]=0;
	    	}else if(c==1) {
	    		dp[a][0]=0;
	    		dp[a][2]=0;
	    	}else if(c==2) {
	    		dp[a][0]=0;
	    		dp[a][1]=0;
	    	}
	    }
	    dfs(0, -1);
	    long ans=dp[0][0]+dp[0][1]+dp[0][2];
	    /*for(int i=0;i<3;i++) {
	    	for(int j=0;j<n;j++) {
	    		out.print(dp[j][i]+" ");
	    	}
	    	out.println();
	    }*/
	    out.println(ans%mod);
	    //out.close();
	    pw.println(ans%mod);
	    pw.close();
	}
	static void dfs(int cur, int par) {
		for(int next:al.get(cur)) {
			if(next!=par) {
				dfs(next, cur);
			}
		}
		for(int next:al.get(cur)) {
			if(next!=par) {
				dp[cur][0]*=(dp[next][1]+dp[next][2]);
				dp[cur][0]%=mod;
				dp[cur][1]*=(dp[next][0]+dp[next][2]);
				dp[cur][1]%=mod;
				dp[cur][2]*=(dp[next][0]+dp[next][1]);
				dp[cur][2]%=mod;
			}
		}
	}
}
