import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad3{
	public static PrintWriter out;
	static HashSet<point>[][]b;
	static int dx[]= {-1,0,1,0};
	static int dy[]= {0,1,0,-1};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		b=new HashSet[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				b[i][j]=new HashSet<point>();
			}
		}
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken())-1;
			int y1=Integer.parseInt(st.nextToken())-1;
			int x2=Integer.parseInt(st.nextToken())-1;
			int y2=Integer.parseInt(st.nextToken())-1;
			b[x1][y1].add(new point(x2, y2));
			b[x2][y2].add(new point(x1, y1));
		}
		int ans=0;
        point []points=new point[k];
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			boolean v[][]=new boolean[n][n];
			points[i]=new point(x, y);
			v[x][y]=true;
			dfs(v, x, y);
			for(int j=0;j<i;j++) {
				if(!v[points[j].x][points[j].y]) {
					ans++;
				}
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
	static void dfs(boolean v[][], int x, int y) {
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
			int nextY=y+dy[c];
			if(inBounds(v, nextX, nextY)) {
				if(!v[nextX][nextY]&&!b[x][y].contains(new point(nextX, nextY))) {
					v[nextX][nextY]=true;
					dfs(v, nextX, nextY);
				}
			}
		}
	}
	static boolean inBounds(boolean v[][], int x, int y) {
		return x>=0&&y>=0&&x<v.length&&y<v.length;
	}
	static class point{
		public int x, y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
		public int hashCode() {//hashing 
			return 31*(31+x)+y;
  		}
		public boolean equals(Object o) {//distinguish (x,y) with (x,y)
			if(this==o)return true;
			point other=(point)o;
			if(x!=other.x||y!=other.y) {
			return false;
			}
			return true;
		}
	}
}
