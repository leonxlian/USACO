import java.io.*;
import java.util.*;
public class NoTimeToPaint {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String str=" "+st.nextToken();
		int[] mc=new int[26];
		int[] p=new int[n+1];
		for(int i=1;i<=n;i++) {
			p[i]=p[i-1];
			int cur=str.charAt(i)-'A';
			boolean ok=mc[cur]==0;
			for(int j=0;j<cur;j++) {//loop previous colors
				if(mc[cur]<mc[j]) {//lighter than the last appearance
					ok=true;
				}
			}
			if(ok) {
				p[i]++;
			}
			mc[cur]=i;
		}
		Arrays.fill(mc, n+1);
		int[] s=new int[n+2];
		for(int i=n;i>=1;i--) {
			s[i]=s[i+1];
			int cur=str.charAt(i)-'A';
			boolean ok=mc[cur]==n+1;
			for(int j=0;j<cur;j++) {//loop previous colors
				if(mc[cur]>mc[j]) {//lighter than the last appearance
					ok=true;
				}
			}
			if(ok) {
				s[i]++;
			}
			mc[cur]=i;
		}
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			out.println(p[a-1]+s[b+1]);
		}
		out.close();
	}
}
