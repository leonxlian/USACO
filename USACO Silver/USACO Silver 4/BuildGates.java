import java.io.*;
import java.util.*;
public class BuildGates{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		boolean b[][]=new boolean[2001][2001];
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String s=st.nextToken();
		int startx=1000;
		int starty=1000;
		b[startx][starty]=true;
		for(int i=0;i<n;i++) {
			char c=s.charAt(i);
			int cx=0;
			int cy=0;
			if(c=='N') {
				cx=1;
			}else if(c=='S') {
				cx=-1;
			}else if(c=='W') {
				cy=-1;
			}else {
				cy=1;
			}
			for(int j=0;j<2;j++) {
				startx+=cx;
				starty+=cy;
				b[startx][starty]=true;
			}
		}
		int dx[]= {-1,0,1,0};
		int dy[]= {0,-1,0,1};
		boolean v[][]=new boolean[2000][2000];
		for(int i=0;i<2000;i++) {
			for(int j=0;j<2000;j++) {
				if(b[i][j]) {
					v[i][j]=true;
				}
			}
		}
		int ans=0;
		for(int i=0;i<2000;i++) {
			for(int j=0;j<2000;j++) {
				if(!v[i][j]) {
					ans++;
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
							if(inBounds(nextX, nextY)&&!v[nextX][nextY]&&!b[nextX][nextY]) {
								v[nextX][nextY]=true;
								qx.add(nextX);
								qy.add(nextY);
							}
						}
					}
				}
			}
		}
		//out.println(ans-1);
		//out.close();
		pw.println(ans-1);
		pw.close();
	}
	static boolean inBounds(int x, int y) {
		return x>=0&&y>=0&&x<2000&&y<2000;
	}
}
