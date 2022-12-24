import java.io.*;
import java.util.*;
public class SubsetEquality{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		String s=st.nextToken();
		st=new StringTokenizer(br.readLine());
		String t=st.nextToken();
		int sCount[]=new int[26];
		int tCount[]=new int[26];
		for(int i=0;i<s.length();i++) {
			sCount[s.charAt(i)-'a']++;
		}
		for(int i=0;i<t.length();i++) {
			tCount[t.charAt(i)-'a']++;
		}
		boolean[][] ok= new boolean[26][26];
		for(char i='a';i<='r';i++) {
			for(char j='a';j<=i;j++) {
				StringBuilder s1=new StringBuilder();
				StringBuilder s2=new StringBuilder();
				for(int l=0;l<s.length();l++) {
					if(s.charAt(l)==i||s.charAt(l)==j) {
						s1.append(s.charAt(l));
					}
				}
				for(int l=0;l<t.length();l++) {
					if(t.charAt(l)==i||t.charAt(l)==j) {
						s2.append(t.charAt(l));
					}
				}
				ok[j-'a'][i-'a']=s1.toString().equals(s2.toString());
				ok[i-'a'][j-'a']=s1.toString().equals(s2.toString());
			}
		}
		st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		while(n-->0) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			int tSum=0;
			int sSum=0;
			for(char x:str.toCharArray()) {
				sSum+=sCount[x-'a'];
				tSum+=tCount[x-'a'];
			}
			if(sSum!=tSum) {
				out.print("N");
				continue;
			}
			boolean ans=true;
			for(int i=0;i<str.length();i++) {
				for(int j=i+1;j<str.length();j++) {
					if(!ok[str.charAt(i)-'a'][str.charAt(j)-'a']) {
						out.print("N");
						ans=false;
						break;
					}
				}
				if(!ans) {
					break;
				}
			}
			if(ans) {
				out.print("Y");
			}
		}
        out.close();
	}
}
