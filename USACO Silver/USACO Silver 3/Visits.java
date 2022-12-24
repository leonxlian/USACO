import java.io.*;
import java.util.*;
public class Visits {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		int b[]=new int[n];
		long ans=0;
		for(int i=0;i<n;i++){
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
			ans+=b[i];
		}
		Arrays.sort(b);
		System.out.println(ans-b[0]);
		
	}
}