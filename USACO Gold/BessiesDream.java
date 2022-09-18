import java.io.*;
import java.util.*;
public class BessiesDream {
	public static PrintWriter out;
	static int dx[]= {0, 1, 0, -1};
	static int dy[]= {-1, 0, 1, 0};
	static int n, m;
	static int grid[][];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("dream.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dream.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    grid=new int[n][m];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	for(int j=0;j<m;j++) {
	    		grid[i][j]=Integer.parseInt(st.nextToken());
	    	}
	    }
	    int dist[][][]=new int[n][m][2];
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
	    		for(int k=0;k<2;k++) {
	    			dist[i][j][k]=-1;
	    		}
	    	}
	    }
	    ArrayDeque<state>q=new ArrayDeque<>();
	    q.add(new state(0, 0, 0));
	    dist[0][0][0]=0;
	    while(!q.isEmpty()) {
	    	state cur=q.poll();
	    	if(cur.x==n-1&&cur.y==m-1) {
	    		//out.println(dist[cur.x][cur.y][cur.orange]);
	    		//out.close();
	    		pw.println(dist[cur.x][cur.y][cur.orange]);
	    		pw.close();
	    		return;
	    	}
	    	for(int c=0;c<4;c++) {
	    		int nextX=cur.x+dx[c];
	    		int nextY=cur.y+dy[c];
	    		int orange=cur.orange;
	    		int distance=dist[cur.x][cur.y][cur.orange]+1;
	    		if(!isOk(nextX, nextY, cur.orange)) {//we cannot make operations
	    			continue;
	    		}
	    		//if current is purple
	    		if(grid[nextX][nextY]==4) {
	    			//while I can go forward, and current is purple
	    			while(isOk(nextX+dx[c], nextY+dy[c], cur.orange)&&grid[nextX][nextY]==4){
	    				nextX+=dx[c];
	    				nextY+=dy[c];
	    				orange=0;
	    				distance++;
	    			}
	    		}
	    		//if we go through orange
	    		if(grid[nextX][nextY]==2) {
	    			orange=1;
	    		}
	    		//either it's not visited, or it can be better
	    		if(dist[nextX][nextY][orange]==-1||(dist[nextX][nextY][orange]!=-1&&dist[nextX][nextY][orange]>distance)) {
	    			dist[nextX][nextY][orange]=distance;
	    			q.add(new state(nextX, nextY, orange));
	    		}
	    	}
	    }
	    //out.println(-1);
	    //out.close();
	    pw.println(-1);
	    pw.close();
	}
	//if make sure new point is in bounds, and u can move
	static boolean isOk(int x, int y, int orange) {
		if(x<0||y<0||x>=n||y>=m||grid[x][y]==0) {
			return false;
		}
		//if cur is blue, orange must be true
		if(grid[x][y]==3) {
			return orange==1;
		}
		return true;
	}
	static class state {
		int x, y, orange;
		public state(int x, int y, int orange) {
			this.x=x;this.y=y;this.orange=orange;
		}
	}
}
