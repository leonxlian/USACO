import java.io.*;
import java.util.*;
public class CitiesAndStates{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int a[][]=new int[676][676];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			String ch=st.nextToken();
			calculate(ch, s, a);
		}
		long ans=0;
		for(int i=0;i<676;i++) {
			for(int j=i+1;j<676;j++) {
				if(a[i][j]>=1&&a[j][i]>=1) {
					ans+=a[i][j]*a[j][i];
				}
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
	static void calculate(String ch, String s, int a[][]) {
		int num=(ch.charAt(0)-'A')+(ch.charAt(1)-'A')*26;
		int num1=(s.charAt(0)-'A')+(s.charAt(1)-'A')*26;
		a[num][num1]++;
	}
}
