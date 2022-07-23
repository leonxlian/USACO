import java.io.*;
import java.util.*;
public class CowGymnastics2 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int[][]a=new int[k][n];
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int c=Integer.parseInt(st.nextToken());;
				a[i][c-1]=j;
			}
		}
		int count=0;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				int temp=0;
				for(int c=0;c<k;c++) {
					if(a[c][i]<a[c][j]) {
						temp++;
					}
				}
				if(temp==0||temp==k) {
					count++;
				}
			}
		}
		pw.println(count);
		pw.close();
	}
}