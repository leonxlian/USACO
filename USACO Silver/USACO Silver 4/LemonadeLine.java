import java.io.*;
import java.util.*;
public class LemonadeLine{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		for(int i=0;i<n/2;i++) {
			int temp=a[i];
			a[i]=a[n-i-1];
			a[n-i-1]=temp;
		}
		int count=0;
		for(int i=0;i<n;i++) {
			if(a[i]>=i) {
				count++;
			}
		}
		//out.println(count);
		//out.close();
		pw.println(count);
		pw.close();
	}
}
