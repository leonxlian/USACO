import java.io.*;
import java.util.*;
public class ABCs {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a[]=new int[7];
		for(int i=0;i<7;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int a1=a[0];
		int b1=a[1];
		int sum=a1+b1;
		int ans=a[6]-sum;
		System.out.println(a1+" "+b1+" "+ans);
	}
}
