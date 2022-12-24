import java.io.*;
import java.util.*;
public class LemonadeLine {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int b[]=new int[n];
		for(int i=0;i<n;i++) {
			b[i]=a[n-1-i];
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			if(b[i]>=i) {
				ans++;
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
