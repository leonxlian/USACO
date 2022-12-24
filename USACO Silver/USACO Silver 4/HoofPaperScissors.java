import java.io.*;
import java.util.*;
public class HoofPaperScissors{
	//public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int h[]=new int[n+1];
		int p[]=new int[n+1];
		int s[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			if(str.equals("H")) {
				h[i]=h[i-1]+1;
				p[i]=p[i-1];
				s[i]=s[i-1];
			}else if(str.equals("P")) {
				h[i]=h[i-1];
				p[i]=p[i-1]+1;
				s[i]=s[i-1];
			}else if(str.equals("S")) {
				h[i]=h[i-1];
				p[i]=p[i-1];
				s[i]=s[i-1]+1;
			}
		}
		int max=0;
		int res[]=new int[6];
		for(int i=1;i<n+1;i++) {
			int hb=h[i]-h[0];
			int ha=h[n]-h[i];
			int pb=p[i]-p[0];
			int pa=p[n]-p[i];
			int sb=s[i]-s[0];
			int sa=s[n]-s[i];
			res[0]=Math.max(res[0], hb+sa);
			res[1]=Math.max(res[1], hb+pa);
			res[2]=Math.max(res[2], pb+sa);
			res[3]=Math.max(res[3], pb+ha);
			res[4]=Math.max(res[4], sb+ha);
			res[5]=Math.max(res[5], sb+pa);
		}
		for(int i=0;i<6;i++) {
			max=Math.max(res[i], max);
		}
		//out.println(max);
		//out.close();
		pw.println(max);
		pw.close();

	}
}
