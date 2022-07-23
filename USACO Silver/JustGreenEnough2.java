import java.io.*;
import java.util.*;
public class JustGreenEnough2 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int sumLess[][]=new int[n][n+1];
		int atMost[][]=new int[n][n+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sumLess[i][j+1]=sumLess[i][j]+(a[i][j]<100?1:0);
				atMost[i][j+1]=atMost[i][j]+(a[i][j]<=100?1:0);
			}
		}
		long ans=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n+1;j++) {
				int l=-1;
				int r=-1;
				for(int k=0;k<n;k++) {
					while (l < n && (l < k || atMost[l][j] - atMost[l][i] == 0)) {
                        l++;
                    }
                    while (r < n && (r < k || sumLess[r][j] - sumLess[r][i] == 0)) {
                        r++;
                    }
                    ans += r - l;
				}
			}
		}
		System.out.println(ans);
	}
}
