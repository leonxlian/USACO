import java.io.*;
import java.util.*;
public class SubsequenceSummingToSevens2 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int prefix[]=new int[n];
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		prefix[0]=a[0];
		for(int i=1;i<n;i++) {
			prefix[i]=prefix[i-1]+a[i];
		}
		//find remainders
		int remainders[]=new int[n];
		for(int i=0;i<n;i++) {
			remainders[i]=prefix[i]%7;
		}
		//the smallest and largest points when they appear
		int appearancemin[]=new int[8];
		int appearancemax[]=new int[8];
		for(int i=0;i<8;i++) {
			for(int j=0;j<n;j++) {
				if(remainders[j]==i) {
					appearancemin[i]=j;
					break;
				}
			}
		}
		for(int i=0;i<8;i++) {
			for(int j=n-1;j>=0;j--) {
				if(remainders[j]==i) {
					appearancemax[i]=j;
					break;
				}
			}
		}
		//check which is largestest difference
		int max=Integer.MIN_VALUE;
		for(int i=0;i<8;i++) {
			max=Math.max(max, appearancemax[i]-appearancemin[i]);
		}
		System.out.println(max);
		//pw.println(max);
		//pw.close();
	}
}
	
