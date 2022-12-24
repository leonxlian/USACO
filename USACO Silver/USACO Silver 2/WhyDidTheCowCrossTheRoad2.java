import java.io.*;
import java.util.*;

public class WhyDidTheCowCrossTheRoad2 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("maxcross.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("maxcross.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int a[]=new int[b];
		for(int i=0;i<b;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		boolean broken[]=new boolean[n];
		for(int i=0;i<b;i++) {
			broken[a[i]-1]=true;
		}
		int num=0;
		int start=0;
		for(int i=0;i<k;i++) {
			if(broken[i]) {
				num++;
			}
		}
		int min=Integer.MAX_VALUE;
		min=Math.min(min, num);
		for(int i=k;i<n;i++) {
			if(broken[i]) {
				num++;
			}
			if(broken[start]) {
				num--;
			}
			start++;
			min=Math.min(min, num);
		}
		//System.out.println(min);
		pw.println(min);
		pw.close();
	}
}
