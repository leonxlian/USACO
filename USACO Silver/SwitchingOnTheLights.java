import java.io.*;
import java.util.*;
public class SwitchingOnTheLights {
	static boolean[][]b; //lighted
	static boolean[][]v; //visited
	static int []dx=new int[] {-1,1,0,0};//BFS x
	static int []dy=new int[] {0,0,-1,1};
	static ArrayList<Pair>[][]a;//input to store connections
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		a=new ArrayList[n][n];//grid (x,y)
		b=new boolean[n][n];//tracks lights
		v=new boolean[n][n];//tracks visits
		for(int i=0;i<n;i++) {//initialize all pairs
			for(int j=0;j<n;j++) {
				a[i][j]=new ArrayList<Pair>();
			}
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x0=Integer.parseInt(st.nextToken())-1;
			int y0=Integer.parseInt(st.nextToken())-1;
			int x1=Integer.parseInt(st.nextToken())-1;
			int y1=Integer.parseInt(st.nextToken())-1;
			a[x0][y0].add(new Pair(x1,y1));
		}
		LinkedList<Pair>q=new LinkedList<Pair>();
		q.add(new Pair(0,0));
		b[0][0]=true;
		bfs(0,0);
		int ans=0;
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[0].length;j++) {
				if(b[i][j])ans++;
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	public static void bfs(int x, int y) {
		if(x>=0&&x<v.length&&y>=0&&y<v[x].length&&v[x][y]) {//already visited
			return;
		}
		v[x][y]=true;
		for(Pair next:a[x][y]) {
			if(!b[next.x][next.y]) {//loop switches this room controls
				b[next.x][next.y]=true;//turn on light
				if(checkneighbor(next.x, next.y)) {//check if neighbor is visited and lighted
					bfs(next.x,next.y);
				}
			}
		}
		for(int k=0;k<dx.length;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			if(nx>=0&&nx<b.length&&ny>=0&&ny<b[nx].length&&b[nx][ny]) {//check if neighbor turned on
				bfs(nx, ny);
			}
		}
	}
	public static boolean checkneighbor(int x, int y) {//check light on and visit
		for(int k=0;k<dx.length;k++) {
			int nx=x+dx[k];
			int ny=y+dy[k];
			if((nx>=0&&nx<b.length&&ny>=0&&ny<b[nx].length&&b[nx][ny])&&
			(nx>=0&&nx<v.length&&ny>=0&&ny<v[nx].length&&v[nx][ny])) {//check if neighbor turned on
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
