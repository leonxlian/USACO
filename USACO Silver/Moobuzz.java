import java.io.*;
import java.util.*;
public class Moobuzz {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[9];
		a[0]=14;
		a[1]=1;
		a[2]=2;
		a[3]=4;
		a[4]=7;
		a[5]=8;
		a[6]=11;
		a[7]=13;
		a[8]=14;
		int ans=(n-1)/8;
		ans*=15;
		ans+=a[n%8];
		System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
