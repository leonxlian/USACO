import java.io.*;
import java.util.*;
public class Convention1 {
	static int a[];
	static int n, m, c;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("convention.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken()); //cows
		m=Integer.parseInt(st.nextToken()); 
		c=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		a=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int low=0;
		int high=Integer.MAX_VALUE-1;
		while(low!=high) {
			int mid=(low+high)/2;
			if(check(mid)) {
				high=mid;
			}else {
				low=mid+1;
			}
		}
		//System.out.println(low);
		pw.println(low);
		pw.close();
	}
	static boolean check(int t) {
		int buses=1;
		int firstCowTime = a[0];
		int firstCow = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] - firstCowTime > t || i - firstCow == c) { //time too much or people too much create new bus
				buses++;
				firstCow = i;
				firstCowTime = a[i];
			}
		}
		return buses<=m;
	}
}
