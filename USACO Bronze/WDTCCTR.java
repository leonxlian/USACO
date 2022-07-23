import java.io.*;
import java.util.*;
public class WDTCCTR {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("crossroad.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a[]=new int[11];
		int count=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int c=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			k+=1;
			if(a[c] > 0 && a[c] != k) {
				count++;
			}
			a[c]=k;
		}
		System.out.println(count);
		//pw.println(count);
		//pw.close();
	}
}