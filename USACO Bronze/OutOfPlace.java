import java.io.*;
import java.util.*;
public class OutOfPlace {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("outofplace.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		int swaps=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		int copy[]=new int[n];
		for(int i=0;i<n;i++) {
			copy[i]=a[i];
		}
		Arrays.sort(copy);
		for(int i=0;i<n;i++) {
			if(a[i]!=copy[i]) {
				swaps++;
			}
		}
		//System.out.println(swaps-1);
		pw.println(swaps-1);
		pw.close();
	}
}
