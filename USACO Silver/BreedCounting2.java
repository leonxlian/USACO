import java.io.*;
import java.util.*;
public class BreedCounting2 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//PrintWriter out = new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int h[]=new int[n+1];
		int g[]=new int[n+1];
		int j[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			if(x==1) {
				h[i]=h[i-1]+1;
				g[i]=g[i-1];
				j[i]=j[i-1];
			}else if(x==2) {
				h[i]=h[i-1];
				g[i]=g[i-1]+1;
				j[i]=j[i-1];
			}else {
				h[i]=h[i-1];
				g[i]=g[i-1];
				j[i]=j[i-1]+1;
			}
		}
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			//System.out.println((h[b]-h[a-1])+" "+(g[b]-g[a-1])+" "+(j[b]-j[a-1]));
			pw.println((h[b]-h[a-1])+" "+(g[b]-g[a-1])+" "+(j[b]-j[a-1]));
		}
		pw.close();
	}
}
