import java.io.*;
import java.util.*;
public class BreedCounting {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bcount.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int prefixh[]=new int[n+1];
		int prefixg[]=new int[n+1];
		int prefixj[]=new int[n+1];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int cow=Integer.parseInt(st.nextToken());
			if(cow==1) {
				prefixh[i]=prefixh[i-1]+1;
			}else {
				prefixh[i]=prefixh[i-1];
			}
			if(cow==2) {
				prefixg[i]=prefixg[i-1]+1;
			}else {
				prefixg[i]=prefixg[i-1];
			}	
			if(cow==3) {
				prefixj[i]=prefixj[i-1]+1;
			}else {
				prefixj[i]=prefixj[i-1];
			}
		}
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			//System.out.println((prefixh[end]-prefixh[start-1])+" "+(prefixg[end]-prefixg[start-1])+" "+(prefixj[end]-prefixj[start-1]));
			pw.println((prefixh[end]-prefixh[start-1])+" "+(prefixg[end]-prefixg[start-1])+" "+(prefixj[end]-prefixj[start-1]));
		}
		
		pw.close();
	}
}
