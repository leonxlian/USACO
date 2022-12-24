import java.io.*;
import java.util.*;
public class RestStop {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reststops.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reststops.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int l=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		long rf=Integer.parseInt(st.nextToken());
		long rb=Integer.parseInt(st.nextToken());
		int x[]=new int[n];
		int c[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			c[i]=Integer.parseInt(st.nextToken());
		}
		int max=0;
		int m[]=new int[n];
		for(int i=n-1;i>=0;i--) {
			if(c[i]>max) {
				m[i]=1;
				max=c[i];
			}
		}
		long ans=0;
		long fj=0;
		long b=0;
		int rest=0;
		for(int i=0;i<n;i++) {
			if(m[i]==1) {
				fj+=(x[i]-rest)*rf; //calculate distance*rate to get time
				b+=(x[i]-rest)*rb;  //calculate distance*rate to get time
				ans+=(fj-b)*c[i];   //get difference of time*amount of tastiness grass
				fj=0;
				b=0;//set the time to be equal to 0;
				rest=x[i]; //set the rest stop to the current distance
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
