import java.io.*;
import java.util.*;
public class MooBuzz {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[8];
		a[0]=14;
		a[1]=1;
		a[2]=2;
		a[3]=4;
		a[4]=7;
		a[5]=8;
		a[6]=11;
		a[7]=13;
		int sum=a[n%8];
		//out.println(sum);
		int temp=sum+15*((n-1)/8);
		pw.println(temp);
		pw.close();
	}
}
