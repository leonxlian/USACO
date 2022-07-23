import java.io.*;
import java.util.*;
public class SleepyCowHerding {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int max=0; //4 7 9
		for(int i=0;i<n;i++) {
			int count=0;
			for(int j=i;j<n;j++) {
				if(a[j]>=a[i] + n) {
					break;
				}
				count++;
			}
			max=Math.max(max, count);
		}
		if(a[n-2]-a[0]==n-2&&a[n-1]-a[n-2]>2) {
			max=n-2;
		}if(a[n-1]-a[1]==n-2&&a[1]-a[0]>2) {
			max=n-2;
		}
		System.out.println(n-max);
		System.out.println(Math.max(a[n-1]-a[1], a[n-2]-a[0])-(n-2));
		//pw.println(n-max);
		//pw.println(Math.max(a[n-1]-a[1], a[n-2]-a[0])-(n-2));
		//pw.close();
	}
}
