import java.io.*;
import java.util.*;
public class CowGymnastics {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken());//row
		int n=Integer.parseInt(st.nextToken());//column
		int a[][]=new int[k][n];
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				int c=Integer.parseInt(st.nextToken());
				a[i][c-1]=j;
			}
		}
		int pairs=0;	
		//Go through all pairs
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {							
				int iwinsj = 0;
				for (int g=0; g<k; g++)
					if (a[g][i] < a[g][j]) {
						iwinsj++;
					}
						
				// 0 or all is consistent
				if (iwinsj == 0 || iwinsj == k) {
					pairs++;
				}
			}
		}
		
		//System.out.println(pairs);
		pw.println(pairs);
		pw.close();
	   }
}