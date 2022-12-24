import java.io.*;
import java.util.*;
public class BovineGenomics {
	public static PrintWriter out;
	static int n;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		String s[]=new String[n];
		String p[]=new String[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			s[i]=st.nextToken();
		}
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			p[i]=st.nextToken();
		}
		int ans=0;
		for(int i=0;i<m;i++) {
			for(int j=i+1;j<m;j++) {
				for(int k=j+1;k<m;k++) {
					if(check(s, p, i, j, k)) {
						ans++;
					}
				}
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
	static boolean check(String s[],String p[], int i, int j, int k) {
		boolean a[]=new boolean[64];
		for(int c=0;c<n;c++) {
			int val=convert(s[c].charAt(i))*16+convert(s[c].charAt(j))*4+convert(s[c].charAt(k));
			a[val]=true;
		}
		boolean b[]=new boolean[64];
		for(int c=0;c<n;c++) {
			int val=convert(p[c].charAt(i))*16+convert(p[c].charAt(j))*4+convert(p[c].charAt(k));
			b[val]=true;
		}
		for(int c=0;c<64;c++) {
			if(a[c]&&b[c]) {
				return false;
			}
		}
		return true;
	}
	static int convert(char c) {
		if(c=='A') {
			return 0;
		}else if(c=='C') {
			return 1;
		}else if(c=='G') {
			return 2;
		}else {
			return 3;
		}
	}
}
