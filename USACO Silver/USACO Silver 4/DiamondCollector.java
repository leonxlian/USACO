import java.io.*;
import java.util.*;
public class DiamondCollector {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int leftI[]=new int[n];
		int j=0;
		//store index of the smallest diamond u can hold given the current diamond
		for(int i=0;i<n;i++) {
			while(j<n&&a[i]-a[j]>k) {
				j++;
			}
			leftI[i]=j;
		}
		j=n-1;
		int rightI[]=new int[n];
		for(int i=n-1;i>=0;i--) {
			while(j>=0&&a[j]-a[i]>k) {
				j--;
			}
			rightI[i]=j;
		}
		int left_cumulative[]=new int[n];
		//get largest amount that u can get up to this diamond
		for(int i=0;i<n;i++) {
			left_cumulative[i]=i-leftI[i]+1;
			if(i>0) {
				left_cumulative[i]=Math.max(left_cumulative[i], left_cumulative[i-1]);
			}
		}
		int right_cumulative[]=new int[n];
		for(int i=n-1;i>=0;i--){
			right_cumulative[i]=rightI[i]-i+1;
			if(i<n-1) {
				right_cumulative[i]=Math.max(right_cumulative[i+1], right_cumulative[i]);
			}
		}
		int ans=0;
		for(int i=0;i<n-1;i++) {
			ans=Math.max(ans, left_cumulative[i]+right_cumulative[i+1]);
		}
		/*for(int i:leftI) {
			out.print(i+" ");
		}
		out.println();
		for(int i:rightI) {
			out.print(i+" ");
		}
		out.println();
		for(int i:left_cumulative) {
			out.print(i+" ");
		}
		out.println();
		for(int i:right_cumulative) {
			out.print(i+" ");
		}*/
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
}
