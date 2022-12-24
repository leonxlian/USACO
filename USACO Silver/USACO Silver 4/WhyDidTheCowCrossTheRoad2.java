import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad2{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		ArrayList<Integer>al=new ArrayList<Integer>();
		for(int i=0;i<b;i++) {
			st=new StringTokenizer(br.readLine());
			al.add(Integer.parseInt(st.nextToken()));
		}
		int count=0;
		for(int i=1;i<=k;i++) {
			if(al.contains(i)) {
				count++;
			}
		}
		int ans=count;
		for(int i=k+1;i<=n;i++) {
			if(al.contains(i)) {
				count++;
			}
			if(al.contains(i-k)) {
				count--;
			}
			ans=Math.min(count, ans);
		}
		out.println(ans);
		out.close();
		pw.println(ans);
		pw.close();
	}
}
