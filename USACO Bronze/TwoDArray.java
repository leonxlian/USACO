import java.io.*;
import java.util.*;
public class TwoDArray {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int a[][]=new int[n][k];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<k;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
	}
}
