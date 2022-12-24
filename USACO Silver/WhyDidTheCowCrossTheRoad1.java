import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad1 {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int T[]=new int[c];
		for(int i=0;i<c;i++) {
			st=new StringTokenizer(br.readLine());
			T[i]=Integer.parseInt(st.nextToken());
		}
		int a[]=new int[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		
	}
}
