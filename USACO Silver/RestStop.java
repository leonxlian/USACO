import java.io.*;
import java.util.*;
public class RestStop {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int l=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		long rf=Integer.parseInt(st.nextToken());
		long rb=Integer.parseInt(st.nextToken());
		int r[]=new int[n];
		int d[]=new int[n];
		int m[]=new int[n];
		int max=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			r[i]=Integer.parseInt(st.nextToken());
			d[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=n-1;i>=0;i--) {
			if(d[i]>max) {
				m[i]=1;
				max=d[i];
			}
		}
		long pf=0;
		long pb=0;
		int rest=0;
		long result=0;
		for(int i=0;i<n;i++) {
			if(m[i]==1) {
				pf+=(r[i]-rest)*rf;
				pb+=(r[i]-rest)*rb;
				result+=(pf-pb)*d[i];
				pb=pf;
				rest=r[i];
			}
		}
		System.out.println(result);
		//pw.println(result);
		//pw.close();
	}
}
