import java.io.*;
import java.util.*;
public class LoadBalancing {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
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
			ArrayList<point> above=new ArrayList<point>();
			ArrayList<point> below=new ArrayList<point>();
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
				int minx=Integer.MAX_VALUE;//loop until index hits the line;
				if(aindex<above.size()) {
					minx=Math.min(minx, above.get(aindex).x); //set vertical line, brute force each line
				}
				if(bindex<below.size()) {
					minx=Math.min(minx, below.get(bindex).x); //set vertical line, brute force each line
				}
				while(aindex<above.size()&&(above.get(aindex).x==minx)) {
					aindex++; //add index as long as it's before the line
				}
				while(bindex<below.size()&&(below.get(bindex).x==minx)) {
					bindex++;
				}
				ans=Math.min(ans, Math.max(bindex, Math.max(aindex, Math.max(below.size()-bindex, above.size()-aindex))));
			}
		}
		System.out.println(ans);
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
