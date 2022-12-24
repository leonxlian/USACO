import java.io.*;
import java.util.*;
public class AngryCows{
	public static PrintWriter out;
	static int a[];
	static int k;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		a=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int low=1;
		int high=(int) 1e9;
		while(low!=high) {
			int mid=(low+high)/2;
			if(check(mid)) {
				high=mid;
			}else{
				low=mid+1;
			}
		}
		//out.println(low);
		//out.close();
		pw.println(low);
		pw.close();
	}
	static boolean check(int n) {
		int cur=a[0];
		int count=1;
		for(int i=0;i<a.length;i++) {
			if(a[i]>cur+2*n) {
				cur=a[i];
				count++;
			}
		}
		return count<=k;
	}
}
