import java.io.*;
import java.util.*;
public class RedistributingGifts {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[][]=new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=n;j>0;j--) {
				a[i][Integer.parseInt(st.nextToken())]=j;//what number comes in at which index counting backwards
			}
		}
		boolean[][] reachable = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (a[i][j] >= a[i][i]) {
                    reachable[j][i] = true;
                }
            }
        }
        //floyd warshall
        for (int cow2 = 1; cow2 <= n; cow2++) {
            for (int cow1 = 1; cow1 <= n; cow1++) {
                for (int cow3 = 1; cow3 <= n; cow3++) {
                    reachable[cow1][cow3] = reachable[cow1][cow3] || (reachable[cow1][cow2] && reachable[cow2][cow3]);
                }
            }
        }
        for (int cow = 1; cow <= n; cow++) {
            int ans = 0;
            for(int gift=1;gift<=n;gift++) {
            	if(a[cow][gift]>a[cow][ans]&&reachable[cow][gift]) {
            		ans=gift;
            	}
            }
            System.out.println(ans);
        }
	}
}
