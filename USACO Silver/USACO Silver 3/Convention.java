import java.io.*;
import java.util.*;
public class Convention {
	static int a[];
	static int m, c;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int low=0;
		int high=Integer.MAX_VALUE;
		while(low<high) {
			int mid=(low+high)/2;
			if(check(mid)) {
				high=mid;
			}else {
				low=mid+1;
			}
		}
		//System.out.println(low);
		pw.println(low);
		pw.close();
	}
	public static boolean check(int mid) {
		int bus=1;
		int cur=a[0];
		int cow=0;
		for(int i=1;i<a.length;i++) {
			if(a[i]-cur>mid||i-cow>=c) {
				bus++;
				cur=a[i];
				cow=i;
			}	
		}
		return bus<=m;
	}
}
