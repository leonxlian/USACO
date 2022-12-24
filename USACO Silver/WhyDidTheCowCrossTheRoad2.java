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
		int ID[]=new int[n];
		Arrays.fill(ID, -1);
		int a[]=new int[n];
		for(int i=0;i<b;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken())-1;
		}
		for(int i=0;i<b;i++) {
			ID[a[i]]=0;
		}
		int count=0;
		for(int i=0;i<k;i++) {
			if(ID[i]==0) {
				count++;
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int i=k-1;i<n-1;i++) {
			if(ID[i+1]==0) {
				count++;
			}
			if(ID[i-(k-1)]==0) {
				count--;
			}
			ans=Math.min(ans, count);
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
