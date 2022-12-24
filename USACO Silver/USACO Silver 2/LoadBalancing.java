import java.io.*;
import java.util.*;

public class LoadBalancing {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        point[] a=new point[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int xx=Integer.parseInt(st.nextToken());
			int yy=Integer.parseInt(st.nextToken());
			a[i]=new point(xx, yy);
		}
		Arrays.sort(a);
		int ans=a.length;
		for(int i=0;i<n;i++) {
			ArrayList<point>aa=new ArrayList<point>(); //above
			ArrayList<point>bb=new ArrayList<point>(); //below
			for(int j=0;j<n;j++) { //loop through the points
				if(a[j].y<=a[i].y) { //if the current point is below 
					bb.add(a[j]);
				}else {
					aa.add(a[j]);
				}
			}
			int bi=0;
			int ai=0;
			while(ai<aa.size()||bi<bb.size()) {
				int xx=Integer.MAX_VALUE;
				if(bi<bb.size()) {
					xx=Math.min(xx, bb.get(bi).x); //new x every time, next vertical line
				}
				if(ai<aa.size()) {
					xx=Math.min(xx, aa.get(ai).x);
				}
				while((bi<bb.size())&&(bb.get(bi).x==xx)) { //add until you get to x point equals x point of line
					bi++;
				}
				while((ai<aa.size())&&(aa.get(ai).x==xx)) { //add until you get to x point equals x point of line
					ai++;
				}
				ans=Math.min(ans, Math.max(Math.max(bi, bb.size()-bi), Math.max(ai, aa.size()-ai)));
			}
		}
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
	static class point implements Comparable<point>{
		int x,y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int compareTo(point o) {
			return x-o.x;
		}
	}
}
