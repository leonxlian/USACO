import java.io.*;
import java.util.*;
public class MooyoMooyo {
	public static PrintWriter out;
	static int n;
	static int k;
	static int dx[]= {-1, 1, 0, 0};
	static int dy[]= {0, 0, 1, -1};
	static int grid[][];
	static ArrayList<Pair>al;
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    grid=new int[n][10];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	String s=st.nextToken();
	    	for(int j=0;j<10;j++) {
	    		grid[i][j]=s.charAt(j)-'0';
	    	}
	    }
	    go();
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<10;j++) {
	    		out.print(grid[i][j]);
	    		pw.print(grid[i][j]);
	    	}
	    	out.println();
	    	pw.println();
	    }
	    pw.close();
	    //out.close();
	}
	static void go() {
		al=new ArrayList<>();
		boolean vis[][]=new boolean[n][10];
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<10;j++) {
	    		if(!vis[i][j]&&grid[i][j]!=0) {
	    			ArrayDeque<Integer>qx=new ArrayDeque<>();
	    			ArrayDeque<Integer>qy=new ArrayDeque<>();
	    			qx.add(i);
	    			qy.add(j);
	    			vis[i][j]=true;
	    			int num=grid[i][j];
	    			int cnt=1;
	    			while(!qx.isEmpty()) {
	    				int curx=qx.poll();
	    				int cury=qy.poll();
	    				for(int c=0;c<4;c++) {
	    					int nextX=curx+dx[c];
	    					int nextY=cury+dy[c];
	    					if(inBounds(nextX, nextY)&&grid[nextX][nextY]==num&&!vis[nextX][nextY]) {
	    						vis[nextX][nextY]=true;
	    						cnt++;
	    						qx.add(nextX);
	    						qy.add(nextY);
	    					}
	    				}
	    			}
	    			if(cnt>=k) {
	    				al.add(new Pair(i, j));
	    			}
	    		}
	    	}
	    }
	    ArrayDeque<Pair>q=new ArrayDeque<>();
	    ArrayDeque<Integer>num=new ArrayDeque<>();
	    for(Pair p:al) {
	    	q.add(p);
	    	num.add(grid[p.x][p.y]);
	    }
	    vis=new boolean[n][10];
	    while(!q.isEmpty()) {
	    	Pair cur=q.poll();
	    	int digit=num.poll();
	    	grid[cur.x][cur.y]=0;
	    	for(int c=0;c<4;c++) {
	    		int nextX=cur.x+dx[c];
	    		int nextY=cur.y+dy[c];
	    		if(inBounds(nextX, nextY)&&grid[nextX][nextY]==digit&&!vis[nextX][nextY]) {
	    			vis[nextX][nextY]=true;
	    			q.add(new Pair(nextX, nextY));
	    			num.add(digit);
	    		}
	    	}
	    }
	    /*for(int i=0;i<n;i++) {
	    	for(int j=0;j<10;j++) {
	    		out.print(grid[i][j]);
	    		//pw.print(grid[i][j]);
	    	}
	    	out.println();
	    	//pw.println();
	    }*/
	    drop();
	    if(al.size()>0) {
	    	go();
	    }
	}
	static void drop() {
		for(int i=0;i<10;i++) {
			ArrayList<Integer>al=new ArrayList<Integer>();
			for(int j=n-1;j>=0;j--) {
				if(grid[j][i]!=0) {
					al.add(grid[j][i]);
				}
			}
			int cnt=0;
			int idx=-1;
			for(int j=n-1;cnt<al.size();j--) {
				grid[j][i]=al.get(cnt);
				cnt++;
				idx=j;
			}
			for(int j=0;j<idx;j++) {
				grid[j][i]=0;
			}
		}
	}
	static boolean inBounds(int x, int y) {
		return x>=0&&y>=0&&x<n&&y<10;
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
	}
}
/*
20 2
1000200000
2007401000
7016644000
6332123500
5367633723
3551643232
4241624215
6761211156
4447343155
4734232617
2131126744
5261165372
7213114444
1525235331
4173633747
4525634375
4316141342
3473352437
5437213345
3124732154*/
