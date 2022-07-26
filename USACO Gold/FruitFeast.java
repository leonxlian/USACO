import java.io.*;
import java.util.*;
public class FruitFeast{
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("feast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("feast.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int t=Integer.parseInt(st.nextToken());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		boolean dp[]=new boolean[t+1];
		dp[0]=true;
		for(int i=a;i<=t;i++) {
			if(dp[i-a]) {
				dp[i]=true;
			}
		}
		for(int i=b;i<=t;i++) {
			if(dp[i-b]) {
				dp[i]=true;
			}
		}
		TreeSet<Integer>ts=new TreeSet<>();
		for(int i=0;i<=t;i++) {
			if(dp[i]) {
				ts.add(i);
			}
		}
		int ans=ts.last();
		for(int x:ts) {
			ans=Math.max(ans, x/2+ts.floor(t-x/2));
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
}
