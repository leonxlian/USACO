import java.io.*;
import java.util.*;
public class ComfortableCows2 {
	static int v[][];
	static int ans;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		ans=0;
		v=new int[4002][4002];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			x+=1000;
			y+=1000;
			dfs(x, y);
			System.out.println(ans);
		}
	}	
	static void dfs(int x, int y) {
		if(v[x][y]==2) {
			ans--;
		}
		ArrayDeque<Integer>qx=new ArrayDeque<Integer>();
		ArrayDeque<Integer>qy=new ArrayDeque<Integer>();
		v[x][y]=1;
		qx.add(x);
		qy.add(y);
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
			int nextY=y+dy[c];
			if(nextX<4002&&nextY<4002) {
				if(v[nextX][nextY]!=0) {
					qx.add(nextX);
					qy.add(nextY);
				}
			}
		}
		while(!qx.isEmpty()) {
			int curx=qx.poll();
			int cury=qy.poll();
			ArrayDeque<Integer>neiX=new ArrayDeque<>();
			ArrayDeque<Integer>neiY=new ArrayDeque<>();
			int lastX=0;
			int lastY=0;
			for(int c=0;c<4;c++) {
				int nextX=curx+dx[c];
				int nextY=cury+dy[c];
				if(nextX<4002&&nextY<4002&&nextX>=0&&nextY>=0) {
					if(v[nextX][nextY]!=0) {
						neiX.add(nextX);
						neiY.add(nextY);
					}else {
						lastX=nextX;
						lastY=nextY;
					}
				}
			}
			if(neiX.size()==3) {
				ans++;
				v[lastX][lastY]=2;
				qx.add(lastX);
				qy.add(lastY);
				for(int c=0;c<4;c++) {
					int nextX=lastX+dx[c];
					int nextY=lastY+dy[c];
					if(nextX<4002&&nextY<4002&&nextX>=0&&nextY>=0) {
						if(v[nextX][nextY]!=0) {
							qx.add(nextX);
							qy.add(nextY);
						}
					}
				}
			}
		}
	}
}
