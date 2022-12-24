import java.io.*;
import java.util.*;
public class PaintingTheBarn {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int a[][]=new int[1001][1001];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			for(int j=x1;j<x2;j++) {
				a[j][y1]++;
				a[j][y2]--;
			}
		}
		int ans=0;
		for(int i=0;i<1000;i++) {
			for(int j=0;j<1000;j++) {
				if(a[i][j]==k) {
					ans++;
				}
				a[i][j+1]+=a[i][j];
			}
		}
		System.out.println(ans);
	}
}
/*
  3 2
1 1 5 5
4 4 7 6
3 3 8 7
*/
