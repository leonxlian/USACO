import java.io.*;
import java.util.*;
public class Replication {
	public static PrintWriter out;
	static int dx[]= {0, 1, 0, -1};
	static int dy[]= {-1, 0, 1, 0};
	static int n;
	static int grid[][];
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("dream.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dream.out")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    n=Integer.parseInt(st.nextToken());
	    int d=Integer.parseInt(st.nextToken());
	    char grid[][]=new char[n][n];
	    //initialize to -1 if unvisited
	    int distR[][]=new int[n][n];
	    ArrayDeque<Pair>q=new ArrayDeque<>();
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	String s=st.nextToken();
	    	for(int j=0;j<n;j++) {
	    		grid[i][j]=s.charAt(j);
	    		if(grid[i][j]=='#') {
	    			q.add(new Pair(i, j));
	    		}else{
	    			distR[i][j]=-1;
	    		}
	    	}
	    }
	    //bfs to get distance from rock to point
	    while(!q.isEmpty()) {
	    	Pair cur=q.poll();
	    	for(int c=0;c<4;c++) {
	    		int nextX=cur.x+dx[c];
	    		int nextY=cur.y+dy[c];
	    		if(inBounds(nextX, nextY)&&distR[nextX][nextY]==-1) {
	    			distR[nextX][nextY]=distR[cur.x][cur.y]+1;
	    			q.add(new Pair(nextX, nextY));
	    		}
	    	}
	    }
	    //visited distances
	    ArrayDeque<state>que=new ArrayDeque<>();
	    int vis[][]=new int[n][n];
	    for(int i=0;i<n;i++) {
	    	Arrays.fill(vis[i], -1);
	    }
	    //make 0 from all starts
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) {
	    		if(grid[i][j]=='S') {
	    			que.add(new state(i, j, 0));
	    			vis[i][j]=0;
	    		}
	    	}
	    }
	    //fill visited with size radius
	    while(!que.isEmpty()) {
	    	state cur=que.poll();
	    	if(cur.dist/d>=distR[cur.x][cur.y]) {//can't replicate
	    		continue;
	    	}else {//replicate, update size
	    		vis[cur.x][cur.y]=cur.dist/d;
	    	}
	    	for(int c=0;c<4;c++) {
	    		int nextX=cur.x+dx[c];
	    		int nextY=cur.y+dy[c];
	    		int size=(cur.dist)/d;
	    		//if unvisited and inbounds
	    		if(inBounds(nextX,nextY)&&vis[nextX][nextY]==-1) {
	    			if(distR[nextX][nextY]>size) {//distance to rock must be greater than size
	    				que.add(new state(nextX, nextY, cur.dist+1));
	    				vis[nextX][nextY]=size;
	    			}
	    		}
	    	}
	    }
	    //priority queue of states, sort by descending radius
	    PriorityQueue<state>pq=new PriorityQueue<>((state s1, state s2)->(-Integer.compare(s1.dist, s2.dist)));
	    boolean v[][]=new boolean[n][n];
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) {
	    		if(vis[i][j]!=-1) {
	    			pq.add(new state(i, j, vis[i][j]));
	    		}
	    	}
	    }
	    int ans=0;
	    while(!pq.isEmpty()) {
	    	state cur=pq.poll();
	    	//if visited already or radius too small
	    	if(cur.dist<0||v[cur.x][cur.y]) {
	    		continue;
	    	}
	    	v[cur.x][cur.y]=true;
	    	//ans++;
	    	for(int c=0;c<4;c++) {
	    		int nextX=cur.x+dx[c];
	    		int nextY=cur.y+dy[c];
	    		//if unvisited, add neighbors
	    		if(inBounds(nextX, nextY)&&!v[nextX][nextY]) {
	    			pq.add(new state(nextX, nextY, cur.dist-1));
	    		}
	    	}
	    }
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<n;j++) {
	    		if(v[i][j]) {
	    			ans++;
	    		}
	    	}
	    }
	    out.println(ans);
	    out.close();
	}
	static boolean inBounds(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<n;
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
	}
	static class state{
		int x, y, dist;
		public state(int x, int y, int dist) {
			this.x=x;this.y=y;this.dist=dist;
		}
	}
	
}
