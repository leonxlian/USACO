import java.io.*;
import java.util.*;
public class WordProcessor {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("word.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("word.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		String[] a=new String[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {	
			a[i]=st.nextToken();			
		}
		int c=0;
		for(int i=0;i<n;i++) {
			if(i==0) {
				//System.out.print(a[i]);
				pw.print(a[i]);
				c+=a[i].length();
			} else if(c+a[i].length()<=k) {
				//System.out.print(" "+a[i]);
				pw.print(" "+a[i]);
				c+=a[i].length();
				
			} else {
				//System.out.println();
				pw.println();
				c=0;
				//System.out.print(a[i]);
				pw.print(a[i]);				
				c+=a[i].length();
			}
		}
		pw.close();
	}
}
