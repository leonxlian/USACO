import java.io.*;
import java.util.*;
public class BovineGenomics {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		String spotted[]=new String[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			spotted[i]=st.nextToken();
		}
		String plain[]=new String[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			plain[i]=st.nextToken();
		}
		int ans=0;
		for(int i=0;i<m;i++) {
			HashSet<Character> hs=new HashSet<Character>();
			boolean contains=false;
			for(int j=0;j<n;j++) {
				hs.add(spotted[j].charAt(i));
			}
			for(int j=0;j<n;j++) {
				if(hs.contains(plain[j].charAt(i))) {
					contains=true;
					break;
				}
			}
			if(!contains) {
				ans++;
			}
		}
		pw.println(ans);
		pw.close();
	}
}
