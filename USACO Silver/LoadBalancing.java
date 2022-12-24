import java.io.*;
import java.util.*;
public class LoadBalancing {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		for(int i=0;i<n;i++) {// sweep all points
			ArrayList<point>aa=new ArrayList<point>(); //above
			ArrayList<point>bb=new ArrayList<point>(); //below
			for(int j=0;j<n;j++) {
				if(a[j].y<=a[i].y) { //split it to below or above
					bb.add(a[j]);
				}else {
					aa.add(a[j]);
				}
			}
		int bi=0;
		int ai=0;
		while(bi<bb.size()||ai<aa.size()) {
			int xx=Integer.MAX_VALUE; //vertical line
			if(bi<bb.size()) {
				xx=Math.min(xx, bb.get(bi).x);
			}		
			if(ai<aa.size()) {
				xx=Math.min(xx, aa.get(ai).x);
			}
			while((bi<bb.size())&&(bb.get(bi).x==xx)){//count the area 1
				bi++;
			}
			while((ai<aa.size())&&(aa.get(ai).x==xx)){//count the area 1
				ai++;
			}
			ans=Math.min(ans, Math.max(Math.max(bi, bb.size()-bi), Math.max(ai, aa.size()-ai)));
			//get the max of box 1, 2, 3, 4 then get the min
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
