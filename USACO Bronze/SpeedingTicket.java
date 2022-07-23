import java.io.*;
import java.util.*;
public class SpeedingTicket {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int a[]=new int[100];
		int c=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			for(int j=0;j<x;j++) {
				a[c]=y;
				c++;
			}
		}
		int b[]=new int[100];
		c=0;
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			for(int j=0;j<x;j++) {
				b[c]=y;
				c++;
			}		
		}
		int count=0;
		for(int i=0;i<100;i++) {
			count=Math.max(count, b[i]-a[i]);
		}
		System.out.println(count);
		//pw.println(count);
		//pw.close();
	}	
}
	