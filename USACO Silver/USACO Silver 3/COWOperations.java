import java.io.*;
import java.util.*;
public class COWOperations {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		String s=st.nextToken();
		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		StringBuilder ans=new StringBuilder();
		long cur=System.currentTimeMillis();
		int pre[]=new int[n];
		while(n-->0) {
			st=new StringTokenizer(br.readLine());
			int l=Integer.parseInt(st.nextToken())-1;
			int r=Integer.parseInt(st.nextToken())-1;
			if(r==l&&s.charAt(l)=='C') {
				ans.append('Y');
			}else if(r-l==1&&s.charAt(l)=='O'&&s.charAt(r)=='W') {
				ans.append('Y');
			}else if(r-l==1&&s.charAt(l)=='W'&&s.charAt(r)=='O') {
				ans.append('Y');
			}else {
				ans.append('N');
			}
		}
		long end=System.currentTimeMillis();
		out.println(end-cur);
		out.println(ans);
		out.close();
	}
}