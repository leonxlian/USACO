import java.io.*;
import java.util.*;
public class MooyoMooyo {
	static int a[][];
	static int b[][];
	static int n, k;
	static int sz[]=new int[1001];
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("mooyomooyo.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mooyomooyo.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		a=new int[n][10];
		b=new int[n][10];
		for(int i=0;i<n;i++) {
			char ch[]=br.readLine().toCharArray();
			for(int j=0;j<ch.length;j++) {
				b[i][j]=ch[j]-'0';
			}
		}
		//while(loop());
		loop();
			for(int i=0;i<n;i++) {
				for(int j=0;j<10;j++) {
					System.out.print(a[i][j]);
					//pw.print(b[i][j]);
				}
				System.out.println();
				//pw.println();
			}
		//pw.close();
	}
	static boolean loop() {
		int r=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				a[i][j]=0;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				if(b[i][j]>0&&a[i][j]==0) {
					floodfill(i, j, r++, b[i][j]);
				}
			}
		}
		boolean flag=false;
		for(int i=0;i<n;i++) {
			for(int j=0;j<10;j++) {
				if(b[i][j]>0&&sz[a[i][j]]>=k) {
					b[i][j]=0;
					flag=true;
				}
			}
		}
		gravity();
		while(r>0){
			sz[r--]=0;
		}
		return flag;
	}
	static void floodfill(int i, int j, int r, int c) {
		if(i<0||j<0||i>=n||j>9||b[i][j]!=c||a[i][j]!=0) {
			return;
		}
		a[i][j]=r;
		sz[r]++;
		floodfill(i-1, j, r, c);
		floodfill(i+1, j, r, c);
		floodfill(i, j+1, r, c);
		floodfill(i, j-1, r, c);
	}
	static void gravity() {
		for(int j=0;j<10;j++) {
			int top=n-1, bottom=n-1;
			while(top>=0) {
				while(top>=0&&b[top][j]==0) {
					top--;
				}
				if(top>=0) {
					b[bottom--][j]=b[top--][j];
				}
			}
			while(bottom>=0) {
				b[bottom--][j]=0;
			}
		}
	}
}
