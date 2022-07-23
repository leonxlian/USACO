import java.io.*;
import java.util.*;
public class MeasuringTraffic {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("traffic.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		String a[]=new String[n];
		int b[]=new int[n];
		int c[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=st.nextToken();
			b[i]=Integer.parseInt(st.nextToken());
			c[i]=Integer.parseInt(st.nextToken());
		}		
		int x=-999999999;
		int y=999999999;
		for(int i=n-1;i>=0;i--) {
			if (a[i].equals("none")) { //if it is equal to none
				x = Math.max(x, b[i]); 
				y = Math.min(y, c[i]); 
			}else if (a[i].equals("off")) { //if it is equal to on
				x += b[i]; 
				y += c[i]; 
			}else if (a[i].equals("on")) { //if it is equal to off
				x -= c[i]; 
				y -= b[i]; 
				x = Math.max(0,x); 
			}
		}
		//System.out.println(x+" "+y);
		pw.println(x+" "+y);
		x=-999999999; //min
		y=999999999; //max
		for(int i=0;i<n;i++) {
			if (a[i].equals("none")) { //if it is equal to none
				x = Math.max(x, b[i]); 
				y = Math.min(y, c[i]); 
			}else if (a[i].equals("on")) { //if it is equal to on
				x += b[i]; 
				y += c[i]; 
			}else if (a[i].equals("off")) { //if it is equal to off
				x -= c[i]; 
				y -= b[i]; 
				x = Math.max(0,x); 
			}
		}
		//System.out.println(x+" "+y);
		pw.println(x+" "+y);
		pw.close();
	}
}