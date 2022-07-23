import java.io.*;
import java.util.*;
public class Herdle {
	static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		char a[][]=new char[3][3];
		for(int i=0;i<3;i++) {
			String str=st.nextToken();
			for(int j=0;j<3;j++) {
				a[i][j]=str.charAt(j);
			}
			st=new StringTokenizer(br.readLine());
		}
		char b[][]=new char[3][3];
		for(int i=0;i<3;i++) {
			String str=st.nextToken();
			for(int j=0;j<3;j++) {
				b[i][j]=str.charAt(j);
			}
			if(i!=2) {
				st=new StringTokenizer(br.readLine());
			}
		}
		int green=0;
		boolean v[][]=new boolean[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(a[i][j]==b[i][j]) {
					green++;
					v[i][j]=true;
				}
			}
		}
		int acount[]=new int[26];
		int bcount[]=new int[26];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(!v[i][j]) {
					acount[a[i][j]-'A']++;
				}
			}
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(!v[i][j]) {
					bcount[b[i][j]-'A']++;
				}
			}
		}
		int yellow=0;
		for(int i=0;i<26;i++) {
			yellow+=Math.min(acount[i], bcount[i]);
		}
		out.println(green);
		out.println(yellow);
		out.close();
	}
}
