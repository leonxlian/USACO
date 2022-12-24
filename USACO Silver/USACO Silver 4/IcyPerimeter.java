import java.io.*;
import java.util.*;
public class IcyPerimeter {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		char grid[][]=new char[n+2][n+2];
		for(int i=0;i<n+2;i++) {
			grid[0][i]='.';
			grid[n+1][i]='.';
		}
		for(int i=0;i<n+2;i++) {
			grid[i][0]='.';
			grid[i][n+1]='.';
		}
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			for(int j=1;j<=n;j++) {
				grid[i][j]=s.charAt(j-1);
			}
		}
		boolean v[][]=new boolean[n+2][n+2];
		int area=0;
		int dx[]= {-1,0,1,0};
		int dy[]= {0,-1,0,1};
		int ans=0;
		for(int i=0;i<n+2;i++) {
			for(int j=0;j<n+2;j++) {
				if(grid[i][j]=='#') {
					if(!v[i][j]) {
						int perim=0;
						int count=1;
						ArrayDeque<Integer>qx=new ArrayDeque<>();
						ArrayDeque<Integer>qy=new ArrayDeque<>();
						qx.add(i);
						qy.add(j);
						v[i][j]=true;
						while(!qx.isEmpty()) {
							int curx=qx.poll();
							int cury=qy.poll();
							for(int c=0;c<4;c++) {
								int nextX=curx+dx[c];
								int nextY=cury+dy[c];
								if(grid[nextX][nextY]=='#'&&!v[nextX][nextY]) {
									v[nextX][nextY]=true;
									count++;
									qx.add(nextX);
									qy.add(nextY);
								}else if(grid[nextX][nextY]=='.') {
									perim++;
								}
							}
						}
						if(count>area) {
							area=count;
							ans=perim;
						}else if(count==area) {
							ans=Math.min(ans, perim);
						}
					}
				}
			}
		}
		//out.println(area+" "+ans);
		//out.close();
		pw.println(area+" "+ans);
		pw.close();
	}
	static boolean inBounds(int x, int y, char[][] grid) {
		return x>=0&&y>=0&&x<grid.length&&y<grid.length;
	}
}
