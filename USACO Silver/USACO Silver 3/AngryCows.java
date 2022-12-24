import java.io.*;
import java.util.*;
public class AngryCows {
	static int k;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int low=0;
		int high=a[a.length-1];
		while(low<high) {
			int mid=(low+high)/2;
			if(check(mid, a)) {
				high=mid;
			}else {
				low=mid+1;
			}
		}
		System.out.println(low);
		pw.println(low);
		pw.close();
	}
	public static boolean check(int mid, int[] a) {
		int start=0;
		int end=1;
		int counter=0;
		while(start<a.length) {
			counter++;
			end=start+1;
			while(end<a.length&&(a[end]-a[start]<=2*mid))	{
				end++;
			}
			start=end;
		}
		return counter<=k;
	}
}
