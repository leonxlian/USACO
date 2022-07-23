import java.io.*;
import java.util.*;
public class MilkFactory {
	public static void main(String[] args)throws IOException {
		//BufferedReader br=new BufferedReader(new FileReader("factory.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n-1];
		int b[]=new int[n-1];
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
		}	
		int ans[]=new int[n-1];
		for(int i=0;i<n-1;i++) {
			if(a[i]<b[i]) {
				ans[i]=b[i];
			}else {
				ans[i]=Integer.MAX_VALUE;
			}
		}
		int count=Integer.MAX_VALUE;
		for(int i=0;i<n-1;i++) {
			count=Math.min(count, ans[i]);
		}
		System.out.println(count);
		//pw.println(count);
		//pw.close();
	}
}
/*
10
6 1
10 7
3 6
7 2
9 8
1 5
2 3
4 5
8 5
*/

