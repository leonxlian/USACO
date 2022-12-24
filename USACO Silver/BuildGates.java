import java.io.*;
import java.util.*;
public class BuildGates {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		char[] s=br.readLine().toCharArray();
		int cx=1000;
		int cy=1000;
		boolean [][]b=new boolean[2000][2000];
		b[cx][cy]=true;
		for(int i=0;i<n;i++) {
			int x=0;
			int y=0;
			if(s[i]=='N')y=1;
			if(s[i]=='S')y=-1;
			if(s[i]=='E')x=1;
			if(s[i]=='W')x=-1;
			for(int j=0;j<2;j++) {
				cx+=x;
				cy+=y;
				b[cx][cy]=true;
			}
		}
		int ans=-1;
		int dx[]=new int[] {-1,1,0,0};
		int dy[]=new int[] {0,0,-1,1};
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				if(b[i][j]==true) continue;
					ans++;
					LinkedList<point>q=new LinkedList<point>();
					q.add(new point(i,j));
					while(!q.isEmpty()) {
						point c=q.removeFirst();
						for(int k=0;k<4;k++) {
							int nx=c.x+dx[k];
							int ny=c.y+dy[k];
							if(nx>=0&&nx<b.length&&ny>=0&&ny<b[i].length) {
								if(b[nx][ny]==false) {
									b[nx][ny]=true;
									q.add(new point(nx,ny));
								}
							}
						}
					}
				}
			}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
		static class point{
			public int x, y;
			public point(int x, int y) {
				this.x=x;
				this.y=y;
			}
		}
	}
