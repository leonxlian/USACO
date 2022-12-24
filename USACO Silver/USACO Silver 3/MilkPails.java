import java.io.*;
import java.util.*;
public class MilkPails {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		boolean a[][]=new boolean[x+1][y+1];
		a[0][0]=true;
		for(int op=0;op<k;op++) {
			boolean b[][]=new boolean[x+1][y+1];
			for(int i=0;i<x+1;i++) {
				for(int j=0;j<y+1;j++) {
					if(!a[i][j]) {
						continue;
					}
					b[i][j]=true;
					b[0][j]=true;
					b[i][0]=true;
					b[x][j]=true;
					b[i][y]=true;
					int change=Math.min(i, y-j); //current amount or space you have left, if space you have left is 
					b[i-change][j+change]=true;  //less, only pour space
					change=Math.min(x-i, j);
					b[i+change][j-change]=true;
				}
			}
			a=b;
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<x+1;i++) {
			for(int j=0;j<y+1;j++) {
				if(!a[i][j]) {
					continue;
				}else {
					ans=Math.min(ans, Math.abs(m-(i+j)));
				}
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
