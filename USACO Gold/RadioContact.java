import java.io.*;
import java.util.*;
public class RadioContact{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("radio.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("radio.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int x1=Integer.parseInt(st.nextToken());
		int y1=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int x2=Integer.parseInt(st.nextToken());
		int y2=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String fjS=st.nextToken();
		st=new StringTokenizer(br.readLine());
		String bessieS=st.nextToken();
		int fj[][]=new int[n+1][2];
		int bessie[][]=new int[m+1][2];
		fj[0][0]=x1;
		fj[0][1]=y1;
		for(int i=1;i<=n;i++) {
			int dx=0;
			int dy=0;
			if(fjS.charAt(i-1)=='N') {
				dy=1;
			}else if(fjS.charAt(i-1)=='S'){
				dy=-1;
			}else if(fjS.charAt(i-1)=='E') {
				dx=1;
			}else {
				dx=-1;
			}
			fj[i][0]=dx+fj[i-1][0];
			fj[i][1]=dy+fj[i-1][1];
		}
		bessie[0][0]=x2;
		bessie[0][1]=y2;
		for(int i=1;i<=m;i++) {
			int dx=0;
			int dy=0;
			if(bessieS.charAt(i-1)=='N') {
				dy=1;
			}else if(bessieS.charAt(i-1)=='S'){
				dy=-1;
			}else if(bessieS.charAt(i-1)=='E') {
				dx=1;
			}else {
				dx=-1;
			}
			bessie[i][0]=dx+bessie[i-1][0];
			bessie[i][1]=dy+bessie[i-1][1];
		}
		int dp[][]=new int[n+1][m+1];
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				dp[i][j]=(int) 1e9;
			}
		}
		dp[0][0]=0;
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				if(i!=0||j!=0) {
					if(i>0) {
						dp[i][j]=Math.min(dp[i][j], dp[i-1][j]);
					}
					if(j>0) {
						dp[i][j]=Math.min(dp[i][j], dp[i][j-1]);
					}
					if(i>0&&j>0) {
						dp[i][j]=Math.min(dp[i][j], dp[i-1][j-1]);
					}
					dp[i][j]+=(fj[i][0]-bessie[j][0])*(fj[i][0]-bessie[j][0])+(fj[i][1]-bessie[j][1])*(fj[i][1]-bessie[j][1]);
					//out.println((fj[i][0]-bessie[j][0])*(fj[i][0]-bessie[j][0])+(fj[i][1]-bessie[j][1])*(fj[i][1]-bessie[j][1]));
				}
			}
		}
		/*for(int i=0;i<=n;i++) {
			for(int j=0;j<=m;j++) {
				out.print(dp[i][j]+" ");
			}
			out.println();
		}*/
		out.println(dp[n][m]);
		out.close();
		pw.println(dp[n][m]);
		pw.close();
	}
}
