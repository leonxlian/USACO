import java.io.*;
import java.util.*;
public class COWOperations {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		String s=st.nextToken();
		int n=s.length();
		int c[]=new int[n+1];
		int o[]=new int[n+1];
		int w[]=new int[n+1];
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='C') {
				c[i+1]=c[i]+1;
				o[i+1]=o[i];
				w[i+1]=w[i];
			}else if(s.charAt(i)=='O') {
				c[i+1]=c[i];
				o[i+1]=o[i]+1;
				w[i+1]=w[i];
			}else if(s.charAt(i)=='W') {
				c[i+1]=c[i];
				o[i+1]=o[i];
				w[i+1]=w[i]+1;
			}
		}
		st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		while(t-->0) {
			st=new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken())-1;
			int r=Integer.parseInt(st.nextToken())-1;
			int cCount=c[r+1]-c[l];
			int oCount=o[r+1]-o[l];
			int wCount=w[r+1]-w[l];
			cCount+=Math.min(oCount, wCount);
			int temp=oCount;
			oCount-=Math.min(oCount, wCount);
			wCount-=Math.min(temp, wCount);
			if(cCount%2==0||wCount%2==1||oCount%2==1) {
				out.print("N");
			}else {
				out.print("Y");
			}
		}
		out.close();
	}
}
