import java.io.*;
import java.util.*;
public class SubsequencesSummingToSevens{
	//public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("div7.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		long a[]=new long[n+1];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			a[i+1]=a[i]+x;
		}
		int max=0;
		long remainders[]=new long[n+1];
		for(int i=1;i<=n;i++){
			remainders[i]=a[i]%7;
		}
		int[] appearancemin=new int[8];
		int[] appearancemax=new int[8];
		for(int i=0;i<8;i++) {
			for(int j=1;j<=n;j++) {
				if(remainders[j]==i) {
					appearancemin[i]=j;
					break;
				}
			}
		}
		for(int i=0;i<8;i++) {
			for(int j=n;j>=1;j--) {
				if(remainders[j]==i) {
					appearancemax[i]=j;
					break;
				}
			}
		}
		for(int i=0;i<8;i++) {
			max=Math.max(max, appearancemax[i]-appearancemin[i]);
		}
		//out.println(max);
		//out.close();
		pw.println(max);
		pw.close();
	}
}
