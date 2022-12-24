import java.io.*;
import java.util.*;

public class SocialDistancing {
	static int n, m;
	static point intervals[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		intervals=new point[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			Long a=Long.parseLong(st.nextToken());
			Long b=Long.parseLong(st.nextToken());
			intervals[i]=new point(a, b);
		}
		Arrays.sort(intervals);
		int low=0;
		int high=1000000000;
		while(low<high-1) {
			int mid=(low+high)/2;
			if(check(mid)) {
				low=mid;
			}else {
				high=mid;
			}
		}
		//System.out.println(low);
		pw.println(low);
		pw.close();
	}
	public static boolean check(int d) {
		long curx=intervals[0].a;
		int currinterval=0;
		for(int i=1;i<n;i++) {
			curx+=d;
			while(currinterval<m&&curx>intervals[currinterval].b) {
				currinterval++;
			}
			if(currinterval==m) {
				return false;
			}
			if(intervals[currinterval].a>curx) {
				curx=intervals[currinterval].a;
			}
		}
		return true;
	}
	static class point implements Comparable<point>{
		long a, b;
		public point(long a, long b) {
			this.a=a;this.b=b;
		}
		public int compareTo(point o) {
			return Long.compare(a, o.a); //sort by a
		}
	}
}
