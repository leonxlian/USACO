import java.io.*;
import java.util.*;
public class IcyPerimeter {
	static char[][] ch;
	static int perim[], area[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		ch=new char[n+2][n+2];
		for(int i=0;i<n+2;i++) {
			ch[0][i]='.';
			ch[i][0]='.';
			ch[n+1][i]='.';
			ch[i][n+1]='.';
		}
		for(int i=1;i<n+1;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=1;j<n+1;j++) {
				ch[i][j]=str.charAt(j-1);
			}
		}
		area=new int[n*n];
		perim=new int[n*n];
		int []dx=new int[] {-1,0,1,0};
		int []dy=new int[] {0,1,0,-1};
		int index=0;
		char[][] b=new char[n+2][n+2];
		for(int i=0;i<n+2;i++) {
			for(int j=0;j<n+2;j++) {
				b[i][j]=ch[i][j];
			}
		}
		for(int i=0;i<n+2;i++) {
			for(int j=0;j<n+2;j++) {
				if(ch[i][j]=='.') {
					continue;
				}
				index++;
				ArrayDeque<Integer> x=new ArrayDeque<Integer>();
				ArrayDeque<Integer> y=new ArrayDeque<Integer>();
				x.add(i);
				y.add(j);
				while(!x.isEmpty()) {
					int x1=x.poll();
					int y1=y.poll();
					ch[x1][y1]='.';
					for(int c=0;c<4;c++) {
						int nextX=x1+dx[c];
						int nextY=y1+dy[c];
						if(nextX<n+2&&nextX>=0&&nextY<n+2&&nextY>=0) {
							if(b[nextX][nextY]=='.') {
								perim[index]++;
							}
							if(ch[nextX][nextY]!='.') {
								area[index]++;
								ch[nextX][nextY]='.';
								x.addLast(nextX);
								y.addLast(nextY);
							}
						}
					}
				}
			}
		}
		int a=0;
		int p=0;
		for(int i=1;i<=index;i++) {
			if(area[i]+1>a||(area[i]+1==a&&perim[i]<p)) {
				a=area[i]+1;
				p=perim[i];
			}
		}
		System.out.println(a+ " " +p);
		pw.println(a+ " " +p);
		pw.close();
	}
}
