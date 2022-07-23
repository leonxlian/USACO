import java.io.*;
import java.util.*;
public class CowTipping {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowtip.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		char[][] grid = new char[n][n];
		char WRONG = '1';
		char RIGHT = '0';
				
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				grid[i][j] = s.charAt(j);
			}
		}
		
		int ans=0;
		for(int i = n-1; i >= 0; i--) {
			for(int j = n-1; j >= 0; j--) {
				if(grid[i][j] == WRONG) {
					ans++;
					for(int a = 0; a <= i; a++) {
						for(int b = 0; b <= j; b++) {
							if(grid[a][b] == WRONG) {
								grid[a][b] = '0';
							}
							else {
								grid[a][b] = '1';
							}
						}
					}
				}
			}
	}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();		
	}
}
