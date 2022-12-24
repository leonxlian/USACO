import java.io.*;
import java.util.*;
public class BovineGenomics {
	static int n, m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//PrintWriter out = new PrintWriter(System.out);
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int s[][]=new int[n][m];
		int p[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<m;j++) {
				if(str.charAt(j)=='A') {s[i][j]=0;}
				if(str.charAt(j)=='C') {s[i][j]=1;}
				if(str.charAt(j)=='G') {s[i][j]=2;}
				if(str.charAt(j)=='T') {s[i][j]=3;}
			}
		}
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<m;j++) {
				if(str.charAt(j)=='A') {p[i][j]=0;}
				if(str.charAt(j)=='C') {p[i][j]=1;}
				if(str.charAt(j)=='G') {p[i][j]=2;}
				if(str.charAt(j)=='T') {p[i][j]=3;}
			}
		}
		int ans=0;
		for(int i=0;i<m-2;i++) {
			for(int j=i+1;j<m-1;j++) {
				for(int k=j+1;k<m;k++) {
					if(check(i, j, k, s, p)) {
						ans++;
					}
				}
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
	static boolean check(int a, int b, int c, int[][] s,int [][] p) {
		boolean ok[]=new boolean[64];
		for(int i=0;i<n;i++) {
			int count=s[i][a]*16+s[i][b]*4+s[i][c];
			ok[count]=true;
		}
		for(int i=0;i<n;i++) {
			int count=p[i][a]*16+p[i][b]*4+p[i][c];
			if(ok[count]) {
				return false;
			}
		}
		return true;
	}
}
