import java.io.*;
import java.util.*;

public class Triangles {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int mod=1000000007;
		point a[]=new point[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			a[i]=new point(x, y);
		}
		for(int i=0;i<n;i++) {
			System.out.println(a[i].x+" "+a[i].y);
		}
		for(int i=0;i<n;i++) {
			
		}
	}
	static class point implements Comparable<point>{
		public int x, y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int compareTo(point o) {
			if(x==o.x)
				return y-o.y;
			else 
				return x-o.x;
		}
	}
}
