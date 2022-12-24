import java.io.*;
import java.util.*;
public class AngryCows {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int min=0;
		int max=500000000;
		while(min != max) {
			int mid=(min+max)/2;
			int x=0;
			int l=0;
			while(l < n) {
				x++;
				int cur = l+1;
				while(cur < n && a[cur] - a[l] <= 2*mid) {
					cur++;
				}
				l = cur;
			}
			if(x <= k) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		System.out.println(min);
		//pw.println(min);
		//pw.close();
	}
}
