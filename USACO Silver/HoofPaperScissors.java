import java.io.*;
import java.util.*;
public class HoofPaperScissors {
	static int n;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			if(s.equals("P")) {
				a[i]=1;
			}else if(s.equals("S")) {
				a[i]=2;
			}
			b[n-1-i]=a[i];
		}
		int b1[][]=solve(a);
		int b2[][]=solve(b);
		int ret=0;
		for(int i=0;i<n;i++){
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					ret=Math.max(ret, b1[j][i]+b2[k][n-i]);
				}
			}
		}
		//System.out.println(ret);
		pw.println(ret);
		pw.close();
	}
	static int[][] solve(int[]a){//return winning map
		int[][]ret=new int[3][n+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				ret[j][i+1]=ret[j][i];
			}
				ret[a[i]][i+1]++;
		}
		return ret;
	}
}
