import java.io.*;
import java.util.*;
public class Lifeguards {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader(".in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(".out")));
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];//start
		int b[]=new int[n];//end
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
		}
		int covered[]=new int[1000];
		for(int i=0;i<n;i++) {
			for(int j = a[i]; j < b[i]; j++) {
				covered[j]++;
			}
		}
		int ans=0; //maximum amount covered
		for(int i=0;i<n;i++) {
			for(int j=a[i];j<b[i];j++) {
				covered[j]--;
			}
		}
	}
}
	
