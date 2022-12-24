import java.io.*;
import java.util.*;
public class Acowdemia{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int l=Integer.parseInt(st.nextToken());
		int b[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(b);
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=b[n-i-1];
		}
		int low=0;
		int high=n;
		while(low!=high) {
			int mid=(low+high+1)/2;
			long need=0;
			for(int i=0;i<mid;i++) {
				if(a[i]<mid) {
					need+=mid-a[i];
				}
			}
			if(need<=((long)k*(long)l)&&a[mid-1]+k>=mid) {
				low=mid;
			}else {
				high=mid-1;
			}
		}
		out.println(low);
		out.close();
	}
}
