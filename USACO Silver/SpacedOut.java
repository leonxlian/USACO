import java.io.*;
import java.util.*;
public class SpacedOut {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int a[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int r=0;
		int c=0;
		for(int i=0;i<n;i++) {
			int x=0;
			int y=0;
			for(int j=0;j<n;j++) {
				if(j%2==0) {
					x+=a[i][j];
				}else {
					y+=a[i][j];
				}
			}
			r+=Math.max(x, y);
		}
		for(int i=0;i<n;i++) {
			int x=0;
			int y=0;
			for(int j=0;j<n;j++) {
				if(j%2==0) {
					x+=a[j][i];
				}else {
					y+=a[j][i];
				}
			}
			c+=Math.max(x, y);
		}
		out.println(Math.max(r, c));
		out.close();
	}
}
