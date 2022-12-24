import java.io.*;
import java.util.*;
public class BreedCounting2 {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int prefix[][]=new int[4][n+1];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int cow=Integer.parseInt(st.nextToken());
			if(cow==1) {
				prefix[1][i]=prefix[1][i-1]+1;
			}else {
				prefix[1][i]=prefix[1][i-1];
			}
			if(cow==2) {
				prefix[2][i]=prefix[2][i-1]+1;
			}else {
				prefix[2][i]=prefix[2][i-1];
			}
			if(cow==3) {
				prefix[3][i]=prefix[3][i-1]+1;
			}else {
				prefix[3][i]=prefix[3][i-1];
			}
		}
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			int h=prefix[1][end]-prefix[1][start-1];
			int g=prefix[2][end]-prefix[2][start-1];
			int j=prefix[3][end]-prefix[3][start-1];
			//System.out.println(h+" "+g+" "+j);
			//pw.println(h+" "+g+" "+j);
		}
		//pw.close();
	}
}
