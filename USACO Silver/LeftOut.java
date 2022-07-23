import java.io.*;
import java.util.*;
public class LeftOut {
	static int n;
	static int[][]grid;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		grid=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			for(int j=0;j<n;j++) {
				if(s.charAt(j)=='L') {
					grid[i][j]=1;//L
				}else {
					grid[i][j]=0; //R
				}
			}
		}
		if(grid[0][0]==1) {
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					grid[i][j]=1-grid[i][j]; //flip everything
				}
			}
		}
		for(int i=1;i<n;i++) {
			if(grid[0][i]==1) {
				for(int j=0;j<n;j++) {
					grid[j][i]=1-grid[j][i];
				}
			}
		}
		for(int i=1;i<n;i++) {
			if(grid[i][0]==1) {
				for(int j=0;j<n;j++) {
					grid[i][j]=1-grid[i][j];
				}
			}
		}
		if(count(1, 1, n-1, n-1,0)==0) {
			//System.out.println("1 1");
			pw.println("1 1");
			pw.close();
		}
		if(count(1, 1, n-1, n-1, 1)==n-1) {
			for(int j=1;j<n;j++) {
				if(count(1, j, n-1, j, 1)==n-1) {
					//System.out.println("1 "+ (j+1));
					pw.println("1 "+(j+1));
					pw.close();
				}
			}
			for(int i=1;i<n;i++) {
				if(count(i, 1, i, n-1, 1)==n-1) {
					//System.out.println(""+(i+1)+ " 1");
					pw.println(""+(i+1)+ " 1");
					pw.close();
				}
			}
			pw.println("-1");
			pw.close();
		}
		if(count(1, 1, n-1, n-1, 1)!=1) {
			//System.out.println("-1");
			pw.println("-1");
			pw.close();
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				if(grid[i][j]==1) {
					//System.out.println(""+(i+1)+ " "+(j+1));
					pw.println(""+(i+1)+ " "+(j+1));
					pw.close();
				}
			}
		}
		pw.close();
		
		
	}
	public static int count(int i1, int j1, int i2, int j2, int b) {
		int ans=0;
		for(int i=i1;i<=i2;i++) {
			for(int j=j1;j<=j2;j++) {
				if(grid[i][j]==b) {
					ans++;
				}
			}
		}
		return ans;
	}
}
