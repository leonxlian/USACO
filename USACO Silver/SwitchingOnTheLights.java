import java.io.*;
import java.util.*;
public class SwitchingOnTheLights {
	static ArrayList<Pair>[][]a;//input to store connections
	static int []dx=new int[] {-1,1,0,0};//BFS x
	static int []dy=new int[] {0,0,-1,1};
	static boolean v[][]; //visited array
	static boolean l[][]; //lighted array
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		v=new boolean[n][n];
		l=new boolean[n][n];
		a=new ArrayList[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				a[i][j]=new ArrayList<Pair>();
			}
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken())-1;
			int y1=Integer.parseInt(st.nextToken())-1;
			int x2=Integer.parseInt(st.nextToken())-1;
			int y2=Integer.parseInt(st.nextToken())-1;
			a[x1][y1].add(new Pair(x2, y2));
		}
		ArrayDeque<Pair>q=new ArrayDeque<>();
		q.add(new Pair(0, 0));
		l[0][0]=true;
		bfs(0, 0);
		int ans=0;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(l[i][j]) {
					System.out.println(i+" "+j);
					ans++;
				}
			}
		}
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
	public static void bfs(int x, int y) {
		if(x<0||y<0||x>=v.length||y>=v[x].length||v[x][y]) {
			return;
		}
		v[x][y]=true;
		for(Pair next: a[x][y]) {
			if(!l[next.x][next.y]) {
				l[next.x][next.y]=true;
				if(checkneighbor(next.x, next.y)) {
					bfs(next.x, next.y);
				}
			}
		}
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
			int nextY=y+dy[c];
			if(nextX>=0&&nextY>=0&&nextX<v.length&&nextY<v[nextX].length&&l[nextX][nextY]) {
				bfs(nextX, nextY);
			}
		}
	}
	public static boolean checkneighbor(int x, int y) {
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
			int nextY=y+dy[c];
			if(nextX>=0&&nextY>=0&&nextX<v.length&&nextY<v[x].length&&l[nextX][nextY]&&v[nextX][nextY]) {
				return true;
			}
		}
		return false;
	}
	static class Pair{
		public int x, y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
