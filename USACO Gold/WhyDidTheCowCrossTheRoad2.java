import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad2 {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("nocross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("nocross.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    int n=Integer.parseInt(st.nextToken());
	    int a[]=new int[n];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	a[i]=Integer.parseInt(st.nextToken());
	    }
	    int b[]=new int[n];
	    HashMap<Integer, Integer>hm=new HashMap<>();
	    //HashMap<Integer, Integer>hm1=new HashMap<>();
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	b[i]=Integer.parseInt(st.nextToken());
	    	hm.put(b[i], i+1);
	    }
	    //dp[cur element][last one occupied];
	    int dp[][]=new int[n+1][n+1];
	    //loop through the next 8
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<=n;j++) {
	    		for(int k=-4;k<=4;k++) {
	    			if(hm.containsKey(a[i]+k)) {//if i have this element
	    				int next=hm.get(a[i]+k);
	    				if(next>j&&j<n) {//make sure it hasn't been taken yet
	    								//check if it is at least greater than last to prevent intersection
	    					dp[i+1][next]=Math.max(dp[i+1][next], dp[i][j]+1);
	    				}
	    			}
	    		}
	    		dp[i+1][j]=Math.max(dp[i+1][j], dp[i][j]);
	    	}
	    }
	    int ans=0;
	    for(int i=0;i<=n;i++) {
	    	for(int j=0;j<=n;j++) {
	    		//out.print(dp[i][j]+" ");
	    		ans=Math.max(ans, dp[i][j]);
	    	}
	    	//out.println();
	    }
	    out.println(ans);
	    pw.println(ans);
	    //out.close();
	    pw.close();
	}
}
