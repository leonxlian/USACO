import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		Cow cow[]=new Cow[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			cow[i]=new Cow(x, y);
		}
		Arrays.sort(cow);
		boolean taken[]=new boolean[n];
		int ans=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(taken[j]) {
					continue;
				}
				if(a[j]<cow[i].s) {
					continue;
				}
				if(a[j]>cow[i].e) {
					break;
				}
				if(a[j]>=cow[i].s&&a[j]<=cow[i].e) {
					ans++;
					taken[j]=true;
					break;
				}
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
	static class Cow implements Comparable<Cow>{
		int s, e;
		public Cow(int s, int e) {
			this.s=s;this.e=e;
		}
		public int compareTo(Cow o) {
			if(e==o.e)return s-o.s;
			else return e-o.e;
		}
	}
}
