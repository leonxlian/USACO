import java.io.*;
import java.util.*;
public class BreedCounting {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int h[]=new int[n+1];
		int g[]=new int[n+1];
		int j[]=new int[n+1];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			if(x==1) {
				h[i+1]=h[i]+1;
			}else{
				h[i+1]=h[i];
			}
			if(x==2) {
				g[i+1]=g[i]+1;
			}else{
				g[i+1]=g[i];
			}
			if(x==3) {
				j[i+1]=j[i]+1;
			}else{
				j[i+1]=j[i];
			}
		}
		for(int i=0;i<=n;i++) {
			System.out.println(h[i]+" "+g[i]+" "+j[i]);
		}
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken());
			//System.out.println((h[b]-h[a])+" "+(g[b]-g[a])+" "+(j[b]-j[a]));
			pw.println((h[b]-h[a])+" "+(g[b]-g[a])+" "+(j[b]-j[a]));
		}
		pw.close();
	}
}
