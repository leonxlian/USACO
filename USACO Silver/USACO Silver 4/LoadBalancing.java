import java.io.*;
import java.util.*;
public class LoadBalancing{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		point a[]=new point[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			a[i]=new point(x, y);
		}
		Arrays.sort(a);
		int ans=a.length;
		for(int i=0;i<n;i++) {
			ArrayList<point>above=new ArrayList<>();
			ArrayList<point>below=new ArrayList<>();
			for(int j=0;j<n;j++) {
				if(a[i].y>=a[j].y) {
					below.add(a[j]);
				}else {
					above.add(a[j]);
				}
			}
			int aindex=0;
			int bindex=0;
			while(aindex<above.size()||bindex<below.size()) {
				int minx=Integer.MAX_VALUE;
				if(aindex<above.size()) {
					minx=Math.min(above.get(aindex).x, minx);
				}
				if(bindex<below.size()) {
					minx=Math.min(below.get(bindex).x, minx);
				}
				while(aindex<above.size()&&above.get(aindex).x==minx) {
					aindex++;
				}
				while(bindex<below.size()&&below.get(bindex).x==minx) {
					bindex++;
				}
				ans=Math.min(ans, Math.max(aindex, Math.max(bindex, Math.max(above.size()-aindex, below.size()-bindex))));
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
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
