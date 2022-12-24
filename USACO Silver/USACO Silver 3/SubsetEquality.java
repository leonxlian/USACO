import java.io.*;
import java.util.*;
public class SubsetEquality {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		String s=st.nextToken();
		String s1=st.nextToken();
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[s.length()];
		int b[]=new int[s1.length()];
		for(int i=0;i<a.length;i++) {
			a[i]=s.charAt(i)-'a';
		}
		for(int i=0;i<b.length;i++) {
			b[i]=s1.charAt(i)-'a';
		}
	}
}