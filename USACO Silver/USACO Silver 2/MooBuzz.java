import java.io.*;
import java.util.*;
public class MooBuzz {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moobuzz.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m[]=new int[9];
		m[0]=14;
		m[1]=1;
		m[2]=2;
		m[3]=4;
		m[4]=7;
		m[5]=8;
		m[6]=11;
		m[7]=13;
		m[8]=14;
		int ans=(n-1)/8;
		System.out.println(ans);
		ans*=15;
		System.out.println(ans);
		ans+=m[n%8];
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
}
