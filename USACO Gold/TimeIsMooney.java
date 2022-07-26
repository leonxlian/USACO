import java.io.*;
import java.util.*;
public class TimeIsMooney{
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("time.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("time.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		int money[]=new int[n];
		al=new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(new ArrayList<Integer>());
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			money[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			al.get(a).add(b);
		}
		ArrayDeque<Integer>q=new ArrayDeque<>();
		q.add(0);
		long dp[][]=new long[n][1001]; //node, day
		for(int i=1;i<1001;i++) {
			HashSet<Integer>temp=new HashSet<>();
			while(!q.isEmpty()) {
				int cur=q.poll();
				for(int next:al.get(cur)) {
					dp[next][i]=Math.max(dp[next][i], dp[cur][i-1]+money[next]);
					temp.add(next);
				}
			}
			q=new ArrayDeque<>(temp);
		}
		long ans=0;
		//out.println(dp[1][1]);
		//out.println(dp[1][4]);
		//out.println(dp[2][5]);
		for(int i=1;i<1001;i++) {
			ans=Math.max(ans, dp[0][i]-(long)(i*i*c));
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
}
