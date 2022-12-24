import java.io.*;
import java.util.*;
public class RestStops{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int l=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int rf=Integer.parseInt(st.nextToken());
		int rb=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
		}
		boolean max[]=new boolean[n];
		int t=0;
		for(int i=n-1;i>=0;i--) {
			if(b[i]>t) {
				max[i]=true;
				t=b[i];
			}
		}
		int rate=rf-rb;
		int last=0;
		long ans=0;
		for(int i=0;i<n;i++) {
			if(max[i]) {
				long tast=(long)(a[i]-last)*rate*b[i];
				ans+=tast;
				last=a[i];
			}
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
}
