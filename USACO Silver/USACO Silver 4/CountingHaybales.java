import java.io.*;
import java.util.*;
public class CountingHaybales {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			out.println((search(y, a)-search(x-1, a)));
			//pw.println((search(y, a)-search(x-1, a)));
		}
		//pw.close();
		out.close();
	}
	static int search(int x, int a[]) {
		if(a[0]>x) {
			return 0;
		}
		int lo=0;
		int high=a.length-1;
		while(lo<high) {
			int mid=(lo+high+1)/2;
			if(a[mid]<=x) {
				lo=mid;
			}else {
				high=mid-1;
			}
		}
		return lo+1;
	}
}
