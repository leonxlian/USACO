import java.io.*;
import java.util.*;
public class MilkPails{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		boolean b[][]=new boolean[101][101];
		b[0][0]=true;
		boolean a[][]=new boolean[101][101];
		a[0][0]=true;
		for(int c=0;c<k;c++) {
			for(int i=0;i<=100;i++) {
				for(int j=0;j<=100;j++) {
					if(a[i][j]) {
						b[0][j]=true;
						b[i][0]=true;
						b[i][y]=true;
						b[x][j]=true;
						int need=x-i;
						int give=j>=need?need:j;
						b[i+give][j-give]=true;
						need=y-j;
						give=i>=need?need:i;
						b[i-give][j+give]=true;
					}
				}
			}
			a=b;
			b=new boolean[101][101];
			for(int i=0;i<=100;i++) {
				for(int j=0;j<=100;j++) {
					if(b[i][j]) {
						//out.println(i+" "+j);
					}
				}
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<101;i++) {
			for(int j=0;j<101;j++) {
				if(a[i][j]) {
					//out.println(i+" "+j);
					int sum=i+j;
					ans=Math.min(ans, Math.abs(m-sum));
				}
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
}