import java.io.*;
import java.util.*;
public class DiamondCollector {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());	
		}
		Arrays.sort(a);
		int j=0;
		int left_index[]=new int[n];
		for(int i=0;i<n;i++) {
			while(j<n&&a[i]-a[j]>k) {
				j++;
			}
			left_index[i]=j;
		}
		j=n-1;
		int right_index[]=new int[n];
		for(int i=n-1;i>=0;i--) {
			while(j>=0&&a[j]-a[i]>k) {
				j--;
			}
			right_index[i]=j;
		}
		int left_cumulative[]=new int[n];
		for(int i=0;i<n;i++) {
			left_cumulative[i]=i-left_index[i]+1;
			if(i>0) {
				left_cumulative[i]=Math.max(left_cumulative[i], left_cumulative[i-1]);
			}
		}
		int right_cumulative[]=new int[n];
		for(int i=n-1;i>=0;i--){
			right_cumulative[i]=right_index[i]-i+1;
			if(i<n-1) {
				right_cumulative[i]=Math.max(right_cumulative[i+1], right_cumulative[i]);
			}
		}
		int ans=0;
		for(int i=0;i<n-1;i++) {
			ans=Math.max(ans, left_cumulative[i]+right_cumulative[i+1]);
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
