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
        	int x1=Integer.parseInt(st.nextToken())-1;
        	int y1=Integer.parseInt(st.nextToken())-1;
        	int x2=Integer.parseInt(st.nextToken())-1;
        	int y2=Integer.parseInt(st.nextToken())-1;
        	b[x1][y1].add(new point(x2, y2));
        	b[x2][y2].add(new point(x1, y1));
        }
        point []points=new point[k];
        int ans=0;
        for(int i=0;i<k;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x1=Integer.parseInt(st.nextToken())-1;
        	int y1=Integer.parseInt(st.nextToken())-1;
        	points[i]=new point(x1, y1);
        	boolean[][]v=new boolean[n][n];//visited map
			dfs(v, x1, y1);
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
	static void dfs(boolean v[][], int x, int y) {
		if(!isValid(v, x, y)) {
			return;
		}
		v[x][y]=true;
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
            int nextY=y+dy[c];
            if(!b[x][y].contains(new point(nextX, nextY))) { //if doesn't contain next point
            	dfs(v, nextX, nextY);
            }
		}
	}
	static boolean isValid(boolean v[][], int x, int y) {
		if(x<0||x>=v.length||y<0||y>=v[x].length||v[x][y]) {
			return false;
		}
		return true;
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

