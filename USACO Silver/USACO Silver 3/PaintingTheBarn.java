import java.io.*;
import java.util.*;
public class PaintingTheBarn {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("paintbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paintbarn.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int presum[][]=new int[1001][1001];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			presum[x1][y1]++;
			presum[x2][y2]++;
			presum[x1][y2]--;
			presum[x2][y1]--;
		}
		for(int i=0;i<1000;i++) {
			for(int j=0;j<1000;j++) {
				if(j>=1) {
					presum[i][j]+=presum[i][j-1];
				}
				if(i>=1) {
				presum[i][j]+=presum[i-1][j];
				}
				if(i>=1&&j>=1) {
				presum[i][j]-=presum[i-1][j-1];
				}
			}
		}
		int ans=0;
		for(int i=0;i<1000;i++) {
			for(int j=0;j<1000;j++) {
				if(presum[i][j]==k) {
					ans++;
				}
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
