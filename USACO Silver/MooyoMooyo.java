import java.io.*;
import java.util.*;
public class MooyoMooyo {
	static int a[][];
	static int b[][];
	static int n, k;
	static int size[];
	static int []dx=new int[] {-1,0,1,0};
	static int []dy=new int[] {0,1,0,-1};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		a=new int[n][10];
		b=new int[n][10];
		size=new int[1001];
		for(int i=0;i<n;i++) {
			char ch[]=br.readLine().toCharArray();
			for(int j=0;j<ch.length;j++) {
				b[i][j]=ch[j]-'0';
			}
		}
		while(play());
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				//System.out.print(b[i][j]);
				pw.print(b[i][j]);
			}
			//System.out.println();
			pw.println();
		}
		pw.close();
	}
	public static boolean play() {
		int group=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				a[i][j]=0; //will store what group each point is in
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				if(b[i][j]>0&&a[i][j]==0) { //check that the value is a number, and check if it's in a group already
					ff(i, j, group, b[i][j]);
					group++;
				}
			}
		}
		boolean ok=false;//check the grid to keep simulating or not
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				if(b[i][j]>0&&size[a[i][j]]>=k) {
					b[i][j]=0;
					ok=true;
				}
			}
		}
		gravity();
		while(group>0) {
			size[group]=0;
			group--;
		}
		return ok;
	}
	public static void ff(int x, int y, int group, int num) {
		if(x<0||y<0||x>=n||y>9||b[x][y]!=num||a[x][y]!=0) {
			return;
		}
		a[x][y]=group;
		size[group]++;
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
			int nextY=y+dy[c];
			ff(nextX, nextY, group, num);
		}
	}
	public static void gravity() {
		for(int i=0;i<10;i++) {
			int top=n-1;
			int bottom=n-1;
			while(bottom>=0) {
				while(bottom>=0&&b[bottom][i]==0) {
					bottom--;
				}
				if(bottom>=0) {
					b[top][i]=b[bottom][i];
					top--;
					bottom--;
				}
			}
			while(top>=0) {
				b[top][i]=0;
				top--;
			}
		}
	}
}
