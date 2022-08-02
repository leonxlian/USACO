import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad {
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	static int dx[]= {-1, 1, 0, 0};
	static int dy[]= {0, 0, -1, 1};
	static int n;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("visitfj.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("visitfj.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        out=new PrintWriter(System.out);
        n=Integer.parseInt(st.nextToken());
        int t=Integer.parseInt(st.nextToken());
        int a[][]=new int[n][n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		a[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        long dijk[][][]=new long[n][n][3];//x, y, and distance mod 3
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		dijk[i][j][0]=dijk[i][j][1]=dijk[i][j][2]=Long.MAX_VALUE;
        	}
        }
        //sort by distance
        PriorityQueue<state>pq=new PriorityQueue<state>((state s1, state s2)->
        	Long.compare(dijk[s1.row][s1.col][s1.steps%3], dijk[s2.row][s2.col][s2.steps%3]));
        pq.add(new state(0, 0, 0));//x, y, distance
        dijk[0][0][0]=0;
        while(!pq.isEmpty()) {
        	state cur=pq.poll();
        	for(int c=0;c<4;c++) {
        		int nextX=cur.row+dx[c];
        		int nextY=cur.col+dy[c];
        		if(inBounds(nextX, nextY)) {
        			long nextDist;
        			if((cur.steps+1)%3==0) {//checks for every third block
        				nextDist=dijk[cur.row][cur.col][cur.steps%3]+t+a[nextX][nextY];
        			}else {
        				nextDist=dijk[cur.row][cur.col][cur.steps%3]+t;
        			}
        			//if the dist is smaller, we add into q
        			if(dijk[nextX][nextY][(cur.steps+1)%3]>nextDist) {
        				dijk[nextX][nextY][(cur.steps+1)%3]=nextDist;
        				pq.add(new state(nextX, nextY, cur.steps+1));
        			}
        		}
        	}
        }
        //print out the minimum
        out.println(Math.min(dijk[n-1][n-1][0], Math.min(dijk[n-1][n-1][1], dijk[n-1][n-1][2])));
        pw.println(Math.min(dijk[n-1][n-1][0], Math.min(dijk[n-1][n-1][1], dijk[n-1][n-1][2])));
        pw.close();
        //out.close();
	}
	static boolean inBounds(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<n;
	}
	static class state{
		int row, col, steps;
		public state(int row, int col, int steps) {
			this.row=row;this.col=col;this.steps=steps;
		}
	}
}
