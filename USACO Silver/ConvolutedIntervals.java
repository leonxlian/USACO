import java.io.*;
import java.util.*;
public class ConvolutedIntervals {
	static int n;
	static int m;
	static long ne[], ns[], ans[];
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		ns=new long[m+1];
		ne=new long[m+1];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			ns[a]++;
			ne[b]++;
		}
		ans=new long[2*m+2];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=m;j++) {
				ans[i+j]+=ns[i]*ns[j];
				ans[i+j+1]-=ne[i]*ne[j];
			}
		}
		long total=0;
		for(int i=0;i<=2*m;i++) {
			total+=ans[i];
			System.out.println(total);
		}
	}
}
