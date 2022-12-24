import java.io.*;
import java.util.*;
public class RestStops {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int l=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int rf=Integer.parseInt(st.nextToken());
		int rb=Integer.parseInt(st.nextToken());
		int pos[]=new int[n];
		int t[]=new int[n];
		boolean max[]=new boolean[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			pos[i]=Integer.parseInt(st.nextToken());
			t[i]=Integer.parseInt(st.nextToken());
		}
		int m=0;
		for(int i=n-1;i>=0;i--) {
			if(t[i]>m) {
				m=t[i];
				max[i]=true;
			}
		}
		long result=0;
		long rest=0;
		long fj=0;
		long b=0;
		for(int i=0;i<n;i++) {
			if(max[i]==true) { //if reached max
				fj+=(pos[i]-rest)*rf;
				b+=(pos[i]-rest)*rb;
				result+=(fj-b)*t[i];
				b=fj;
				rest=pos[i];//last rest stop;
			}
		}
		//System.out.println(result);
		pw.println(result);
		pw.close();
	}
}