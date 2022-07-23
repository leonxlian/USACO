import java.io.*;
import java.util.*;
public class BlockGame {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("blocks.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		String a[]=new String[n];
		String b[]=new String[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=st.nextToken();
			b[i]=st.nextToken();
		}		
		int ans[]=new int[26];
		int a1[]=new int[26];
		int b1[]=new int[26];
		for(int i=0;i<26;i++) {
			a1[i]=0;
			b1[i]=0;
		}
		for(int i=0;i<n;i++) { //lines of words   
			for(int j=0;j<a[i].length();j++) { //each character 
				char a2=a[i].charAt(j);
				for(int q=0;q<26;q++) {
					char ch='a';
					ch=(char)(ch+q);
					if(a2==ch) {
						a1[q]++;
					}					
				}
			}
			for(int j=0;j<b[i].length();j++) { //each character 
				char b2=b[i].charAt(j);
				for(int q=0;q<26;q++) {
					char ch='a';
					ch=(char)(ch+q);
					if(b2==ch) {
						b1[q]++;
					}					
				}
			}
			for(int c=0;c<26;c++) {//compare
				int k=Math.max(a1[c], b1[c]);
				ans[c]+=k;
			}
			for(int c=0;c<26;c++) {
				a1[c]=0;
				b1[c]=0;
			}
		}
		for(int i=0;i<26;i++) {
			//System.out.println(ans[i]);
			pw.println(ans[i]);
		}
		pw.close();
	}
}