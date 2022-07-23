import java.io.*;
import java.util.*;
public class SwapitySwap {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a1=Integer.parseInt(st.nextToken());
		int a2=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int b1=Integer.parseInt(st.nextToken());
		int b2=Integer.parseInt(st.nextToken());
		int cowIndicies[]=new int[n];
		for(int i=0;i<n;i++) {
			cowIndicies[i]=i+1;
		}
		int firstswap[]=new int[a2-a1+1]; 
		int secondswap[]=new int[b2-b1+1];
		for(int i=0;i<k;i++) {//for each time needed to loop
			int temp=b2;
			int temp3=a2;
			for(int j=0;j<firstswap.length;j++) {	//get reversed array
				firstswap[j]=cowIndicies[a2-1];
				a2-=1;
			}
			a2=temp3;
			int m=0;
			for(int j=a1-1;j<=a2-1;j++) {
				cowIndicies[j]=firstswap[m];
				m++;
			}
			for(int j=0;j<secondswap.length;j++) {	//get reversed array
				secondswap[j]=cowIndicies[b2-1];
				b2-=1;
			}
			b2=temp;
			m=0;
			for(int j=b1-1;j<=b2-1;j++) {
				cowIndicies[j]=secondswap[m];
				m++;
			}
		}
		for(int i=0;i<cowIndicies.length;i++) {
			System.out.println(cowIndicies[i]);
			//pw.println(cowIndicies[i]);
		}
		//pw.close();
	}
}
