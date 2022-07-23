import java.io.*;
import java.util.*;
public class JustGreenEnough {
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
		int[][] sumsBelow=new int[n][n+1];
		int[][] sumsAtMost=new int[n][n+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sumsBelow[i][j + 1] = sumsBelow[i][j] + (a[i][j] < 100 ? 1 : 0);
                sumsAtMost[i][j + 1] = sumsAtMost[i][j] + (a[i][j] <= 100 ? 1 : 0);
			}
		}
		long ans=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n+1;j++) {
				int l=-1;
				int r=-1;
				for(int k=0;k<n;k++) {
					while (l < n && (l < k || sumsAtMost[l][j] - sumsAtMost[l][i] == 0)) {
                        l++;
                    }
                    while (r < n && (r < k || sumsBelow[r][j] - sumsBelow[r][i] == 0)) {
                        r++;
                    }
                    ans += r - l;
				}
			}
		}
		System.out.println(ans);
		/*for(int i=0;i<n;i++) {
			for(int j=0;j<n+1;j++) {
				System.out.print(sumsBelow[i][j]+" ");
			}
			System.out.println();
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n+1;j++) {
				System.out.print(sumsAtMost[i][j]+" ");
			}
			System.out.println();
		}*/
	}
}
/*
0 1 1 2 
0 0 0 0 
0 1 1 1 
0 1 1 2 
0 0 1 1 
0 1 1 1 */
