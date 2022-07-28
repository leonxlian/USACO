import java.io.*;
import java.util.*;
public class CowNavigation {
	public static PrintWriter out;
	static int dx[]= {0, 1, 0, -1};
	static int dy[]= {1, 0, -1, 0};
	//0=n 1=e 2=s, 3=w
	static int n;
	static int grid[][];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownav.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownav.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    n=Integer.parseInt(st.nextToken());
	    grid=new int[n][n];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	String s=st.nextToken();
	    	for(int j=0;j<n;j++) {
	    		grid[i][j]=s.charAt(j)=='E'?0:1;
	    	}
	    }
	    int dist[][][][][][]=new int[n][n][4][n][n][4];
	    //start with dist=1 so that we can make "0" mean unvisited
	    ArrayDeque<state>q=new ArrayDeque<>();
	    dist[0][0][0][0][0][1]=1;
	    q.add(new state(0, 0, 0, 0, 0, 1));
	    while(!q.isEmpty()) {
	    	state cur=q.poll();
	    	if(cur.x1==n-1&&cur.y1==n-1&&cur.x2==n-1&&cur.y2==n-1) {//reached the end
	    		//out.println(dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]-1);
	    		pw.println(dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]-1);
	    		break;
	    	}
	    	if(cur.x1==n-1&&cur.y1==n-1) {
	    		if(inBounds(cur.x2+dx[cur.dir2],cur.y2+dy[cur.dir2])) {
	    			int nextX1=cur.x1;
	    			int nextY1=cur.y1;
	    			int nextX2=cur.x2+dx[cur.dir2];
	    			int nextY2=cur.y2+dy[cur.dir2];
	    			if(dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]==0) {
		    			q.add(new state(cur.x1, cur.y1, 
			    				cur.dir1, cur.x2+dx[cur.dir2], cur.y2+dy[cur.dir2], cur.dir2));
		    			dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]=
		    					dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
	    			}
	    		}
	    		int nextDir2=cur.dir2+1;
	    		if(nextDir2>3) {
		    		nextDir2-=4;
		    	}
	    		if(dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][nextDir2]==0) {
		    		dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][nextDir2]=
		    				dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    		q.add(new state(cur.x1, cur.y1, cur.dir1, cur.x2, cur.y2, nextDir2));
		    	}
		    	nextDir2=cur.dir2-1;
		    	if(nextDir2<0) {
		    		nextDir2+=4;
		    	}
		    	if(dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][nextDir2]==0) {
		    		dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][nextDir2]=
		    				dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    		q.add(new state(cur.x1, cur.y1, cur.dir1, cur.x2, cur.y2, nextDir2));
		    	}
	    	}else if(cur.x2==n-1&&cur.y2==n-1) {//do stuff to other cow once one has reached the end
	    		if(inBounds(cur.x1+dx[cur.dir1],cur.y1+dy[cur.dir1])) {
	    			int nextX1=cur.x1+dx[cur.dir1];
	    			int nextY1=cur.y1+dy[cur.dir1];
	    			int nextX2=cur.x2;
	    			int nextY2=cur.y2;
	    			if(dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]==0) {
	    				q.add(new state(cur.x1+dx[cur.dir1], cur.y1+dy[cur.dir1], 
			    				cur.dir1, cur.x2, cur.y2, cur.dir2));
		    			dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]=
		    					dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
	    			}
	    		}
	    		//turns for the other cow
	    		int nextDir1=cur.dir1+1;
	    		if(nextDir1>3) {
		    		nextDir1-=4;
		    	}
	    		if(dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][cur.dir2]==0) {
		    		dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][cur.dir2]=
		    				dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    		q.add(new state(cur.x1, cur.y1, nextDir1, cur.x2, cur.y2, cur.dir2));
		    	}
	    		nextDir1=cur.dir1-1;
	    		if(nextDir1<0) {
		    		nextDir1+=4;
		    	}
	    		if(dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][cur.dir2]==0) {
		    		dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][cur.dir2]=
		    				dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    		q.add(new state(cur.x1, cur.y1, nextDir1, cur.x2, cur.y2, cur.dir2));
		    	}
	    	}else {//if neither has finished
	    		//both go forward
		    	if(inBounds(cur.x1+dx[cur.dir1],cur.y1+dy[cur.dir1],cur.x2+dx[cur.dir2],cur.y2+dy[cur.dir2])
		    			&&!isHaybale(cur.x1+dx[cur.dir1],cur.y1+dy[cur.dir1])
		    			&&!isHaybale(cur.x2+dx[cur.dir2],cur.y2+dy[cur.dir2])) {
		    		int nextX1=cur.x1+dx[cur.dir1];
	    			int nextY1=cur.y1+dy[cur.dir1];
		    		int nextX2=cur.x2+dx[cur.dir2];
	    			int nextY2=cur.y2+dy[cur.dir2];
	    			if(dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]==0) {
			    		q.add(new state(cur.x1+dx[cur.dir1], cur.y1+dy[cur.dir1], 
			    				cur.dir1, cur.x2+dx[cur.dir2], cur.y2+dy[cur.dir2], cur.dir2));
			    		dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]=
		    					dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
	    			}
		    	}else {
		    		//first cow go forward
		    		if(inBounds(cur.x1+dx[cur.dir1],cur.y1+dy[cur.dir1])&&
		    				!inBounds(cur.x2+dx[cur.dir2],cur.y2+dy[cur.dir2])) {
		    			int nextX1=cur.x1+dx[cur.dir1];
		    			int nextY1=cur.y1+dy[cur.dir1];
		    			int nextX2=cur.x2;
		    			int nextY2=cur.y2;
		    			if(dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]==0) {
		    				q.add(new state(cur.x1+dx[cur.dir1], cur.y1+dy[cur.dir1], 
				    				cur.dir1, cur.x2, cur.y2, cur.dir2));
			    			dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]=
			    					dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    			}
		    		//second cow go forward
		    		}else if(!inBounds(cur.x1+dx[cur.dir1],cur.y1+dy[cur.dir1])&&
		    				inBounds(cur.x2+dx[cur.dir2],cur.y2+dy[cur.dir2])) {
		    			int nextX1=cur.x1;
		    			int nextY1=cur.y1;
		    			int nextX2=cur.x2+dx[cur.dir2];
		    			int nextY2=cur.y2+dy[cur.dir2];
		    			if(dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]==0) {
			    			q.add(new state(cur.x1, cur.y1, 
				    				cur.dir1, cur.x2+dx[cur.dir2], cur.y2+dy[cur.dir2], cur.dir2));
			    			dist[nextX1][nextY1][cur.dir1][nextX2][nextY2][cur.dir2]=
			    					dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    			}
		    		}
		    	}
		    	
		    	//rotate right
		    	int nextDir1=cur.dir1+1;
		    	int nextDir2=cur.dir2+1;
		    	if(nextDir1>3) {
		    		nextDir1-=4;
		    	}
		    	if(nextDir2>3) {
		    		nextDir2-=4;
		    	}
		    	if(dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][nextDir2]==0) {
		    		dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][nextDir2]=
		    				dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    		q.add(new state(cur.x1, cur.y1, nextDir1, cur.x2, cur.y2, nextDir2));
		    	}
		    	//rotate left
		    	nextDir1=cur.dir1-1;
		    	nextDir2=cur.dir2-1;
		    	if(nextDir1<0) {
		    		nextDir1+=4;
		    	}
		    	if(nextDir2<0) {
		    		nextDir2+=4;
		    	}
		    	if(dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][nextDir2]==0) {
		    		dist[cur.x1][cur.y1][nextDir1][cur.x2][cur.y2][nextDir2]=
		    				dist[cur.x1][cur.y1][cur.dir1][cur.x2][cur.y2][cur.dir2]+1;
		    		q.add(new state(cur.x1, cur.y1, nextDir1, cur.x2, cur.y2, nextDir2));
		    	}
	    	}
	    }
	    //out.close();
	    pw.close();
	}
	static boolean inBounds(int x1, int y1, int x2, int y2) {
		return x1>=0&&y1>=0&&x2>=0&&y2>=0&&x1<n&&y1<n&&x2<n&&y2<n;
	}
	static boolean isHaybale(int x, int y) {//x needs to be flipped to n-1
		return grid[n-x-1][y]==1;
	}
	static boolean inBounds(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<n&&!isHaybale(x, y);
	}
	static class state {
		int x1, y1, dir1, x2, y2, dir2;
		public state(int x1, int y1, int dir1, int x2, int y2, int dir2) {
			this.x1=x1;this.y1=y1;this.dir1=dir1;this.x2=x2;this.y2=y2;this.dir2=dir2;
		}
	}
}
