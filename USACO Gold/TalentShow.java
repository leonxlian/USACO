import java.io.*;
import java.util.*;
public class TalentShow {
	public static PrintWriter out;
	static final int maxt=250001;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("talent.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    int n=Integer.parseInt(st.nextToken());
	    int W=Integer.parseInt(st.nextToken());
	    Pair p[]=new Pair[n];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int w=Integer.parseInt(st.nextToken());
	    	int t=Integer.parseInt(st.nextToken());
	    	p[i]=new Pair(w, t);
	    }
	    //maximize talent, loop through all weights
	    long dp[]=new long[(int) (1e6+2000)];
	    Arrays.fill(dp, Integer.MIN_VALUE);
	    dp[0]=0;
	    for(int i=0;i<n;i++) {
	    	for(int j=(int) (1e6+W);j-p[i].w>=0;j--) {
	    		dp[j]=Math.max(dp[j], dp[(int) (j-p[i].w)]+p[i].t);
	    	}
	    }
	    Pair ans=new Pair(0, 0);
	    for(int i=0;i<n;i++) {
	    	ans.w+=p[i].w;
	    	ans.t+=p[i].t;
	    }
	    for(int i=W;i<=W+1e6;i++) {
	    	if((double)ans.t/ans.w<(double)dp[i]/i) {
	    		ans.w=i;
	    		ans.t=dp[i];
	    	}
	    }
	    out.println((int)(1000*((double)ans.t/ans.w)));
	    pw.println((int)(1000*((double)ans.t/ans.w)));
	    //out.close();
	    pw.close();
	}
	static class Pair{
		long w, t;
		public Pair(long w, long t) {
			this.w=w;this.t=t;
		}
	}
}
