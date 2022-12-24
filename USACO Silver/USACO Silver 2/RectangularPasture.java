import java.io.*;
import java.util.*;
public class RectangularPasture {
	static int sums[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int xs[]=new int[n];
		int ys[]=new int[n];
		Integer cows[]=new Integer[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			xs[i]=Integer.parseInt(st.nextToken());
			ys[i]=Integer.parseInt(st.nextToken());
			cows[i]=i;
		}
		Arrays.sort(cows, Comparator.comparingInt(j -> xs[j]));
		for(int x=1;x<=n;x++) {
			xs[cows[x-1]]=x;
		}
		Arrays.sort(cows, Comparator.comparingInt(j -> ys[j]));
		for(int y=1;y<=n;y++) {
			ys[cows[y-1]]=y;
		}
		sums=new int[n+1][n+1];
		for(int i=0;i<n;i++) {
			sums[xs[i]][ys[i]]++;
		}
		for(int x=0;x<=n;x++) {
			for(int y=0;y<=n;y++) {
				if(x>0) {
					sums[x][y]+=sums[x-1][y];
				}
				if(y>0) {
					sums[x][y]+=sums[x][y-1];
				}
				if(x>0&&y>0) {
					sums[x][y]-=sums[x-1][y-1];
				}
			}
		}
		long ans=n+1;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				ans+=getSum(Math.min(xs[i], xs[j]), Math.max(xs[i], xs[j]), 1, Math.min(ys[i], ys[j]))
					*getSum(Math.min(xs[i], xs[j]), Math.max(xs[i], xs[j]), Math.max(ys[i], ys[j]), n);
			}
		}
		System.out.println(ans);
	}
	static int getSum(int fromX, int toX, int fromY, int toY) {
		return sums[toX][toY]-sums[fromX-1][toY]-sums[toX][fromY-1]+sums[fromX-1][fromY-1];
	}
}
