import java.io.*;
import java.util.*;
public class SwitchingOnTheLights2 {
	static ArrayList<Pair>[][]a;
	static boolean vis[][];
	static boolean l[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lightson.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lightson.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        vis=new boolean[n][n];
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
        l[0][0]=true;
        bfs(0, 0);
        int ans=0;
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(l[i][j]) {
        			ans++;
        		}
        	}
        }
        //System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
	static void bfs(int x, int y) {
		if(vis[x][y]) {
			return;
		}
		vis[x][y]=true;
		for(Pair next:a[x][y]) {
			if(!l[next.x][next.y]) {
				l[next.x][next.y]=true;
				boolean j=false;
				for(int c=0;c<4;c++) {
					int nextX=next.x+dx[c];
					int nextY=next.y+dy[c];
					if(inBounds(nextX, nextY)&&l[nextX][nextY]&&vis[nextX][nextY]) {
						j=true;
					}
				}
				if(j) {
					bfs(next.x, next.y);
				}
			}
		}
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
			int nextY=y+dy[c];
			if(inBounds(nextX, nextY)&&l[nextX][nextY]) {
				bfs(nextX, nextY);
			}
		}
	}
	static boolean inBounds(int x, int y) {
		return x>=0&&x<n&&y>=0&&y<n;
	}
	static class Pair{
		public int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
	}
}
