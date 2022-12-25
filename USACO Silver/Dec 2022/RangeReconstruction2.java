import java.io.*;
import java.util.*;
public class RangeReconstruction2 {
	public static PrintWriter out;
	static int a[][];
	static int n;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		n=Integer.parseInt(st.nextToken());
		a=new int[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n-i;j++) {
				a[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int ans[]=new int[n];
		dfs(n-1, 0, 0, ans);
		out.close();
	}
	static boolean dfs(int cur, int min, int max, int[] ans) {
		boolean ok=true;
		for(int k=cur+1;k<n;k++) {//loop all end points
			long mmax=Long.MIN_VALUE;
			long mmin=Long.MAX_VALUE;
			for(int j=cur;j<=k;j++) {
				mmin=Math.min(mmin, ans[j]);
				mmax=Math.max(mmax, ans[j]);
			}
			if(mmax-mmin!=a[cur][k-cur]) {
				ok=false;
				break;
			}
		}
		if(ok&&cur==0) {
			for(int i=0;i<n;i++) {
				if(i==n-1) {
					out.print(ans[i]);
				}else{
					out.print(ans[i]+" ");
				}
			}
			out.close();
			return true;
		}
		if(ok&&cur!=0) {
			int next=ans[cur]+a[cur-1][1];
			int tempMin=Math.min(next, min);
			int tempMax=Math.max(next, max);
			ans[cur-1]=next;
			if(dfs(cur-1, tempMin, tempMax, ans)) {
				return true;
			}
			next=ans[cur]-a[cur-1][1];
			tempMin=Math.min(next, min);
			tempMax=Math.max(next, max);
			ans[cur-1]=next;
			if(dfs(cur-1, tempMin, tempMax, ans)) {
				return true;
			}
		}
		return false;
	}
}
