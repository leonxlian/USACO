import java.io.*;
import java.util.*;
public class GrassPlanting {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("planting.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int arr[]=new int[n];
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			arr[a]++;
			arr[b]++;
		}
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(arr[i], max);
		}
		//System.out.println(max+1);
		pw.println(max+1);
		pw.close();
	}
}
