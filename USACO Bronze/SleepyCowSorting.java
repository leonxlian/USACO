import java.io.*;
import java.util.*;
public class SleepyCowSorting {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int a[]=new int[100];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int swap=n;
		for(int i=n-1;i>0;i--) {
			if(a[i]<a[i-1]) {
				swap=i;
				break;
			}
		}
		//System.out.println(swap);
		pw.println(swap);
		pw.close();
	}
}
