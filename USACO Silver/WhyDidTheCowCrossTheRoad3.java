import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad3 {
	static HashSet<point>[][]b;
	static int n, k, r;
	static int []dx=new int[] {-1,0,1,0};//DFS x
	static int []dy=new int[] {0,1,0,-1};
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        r=Integer.parseInt(st.nextToken());
        b=new HashSet[n][n];
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		b[i][j]=new HashSet<point>();
        	}
        }
        for(int i=0;i<r;i++) {
        	st=new StringTokenizer(br.readLine());
        	int r1=Integer.parseInt(st.nextToken())-1;
        	int c1=Integer.parseInt(st.nextToken())-1;
        	int r2=Integer.parseInt(st.nextToken())-1;
        	int c2=Integer.parseInt(st.nextToken())-1;
        	b[r1][c1].add(new point(r2, c2));
        	b[r2][c2].add(new point(r1, c1));
        }
        int ans=0;
        point []points=new point[k];
        for(int i=0;i<k;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken())-1;
        	int y=Integer.parseInt(st.nextToken())-1;
        	points[i]=new point(x, y);
        	boolean v[][]=new boolean[n][n];
        	dfs(v, x, y);
        	for(int j=0;j<i;j++) {
        		int x2=points[j].x;
        		int y2=points[j].y;
        		if(v[x2][y2]==false) {
					ans++;
        		}
        	}
        }
        //System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
	public static void dfs(boolean v[][], int x, int y) {
		if(x<0||x>=v.length||y>=v[x].length||y<0||v[x][y]) {
			return;
		}
		v[x][y]=true;
		for(int i=0;i<4;i++) {
			int nextX=x+dx[i];
			int nextY=y+dy[i];
			if(!b[x][y].contains(new point(nextX,nextY))) {
				dfs(v, nextX, nextY);
			}
		}
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
