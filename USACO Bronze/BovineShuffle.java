import java.io.*;
import java.util.*;
public class BovineShuffle {
	public static void main(String[] args) throws IOException {
		//BufferedReader br=new BufferedReader(new FileReader("shuffle.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int j=Integer.parseInt(st.nextToken());
			a[j]=i;
		}
		st=new StringTokenizer(br.readLine());
		int b[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		int c[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			int k=i;
			for(int j=0;j<3;j++)
				k=a[k];
				c[k]=b[i];	
		}	
		for(int i=1;i<=n;i++) {
			System.out.println(c[i]);
			//pw.println(c[i]);
		}
		//pw.close();
	}
}