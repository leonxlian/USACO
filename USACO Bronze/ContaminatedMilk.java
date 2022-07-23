import java.io.*;
import java.util.*;
public class ContaminatedMilk {
	public static void main(String[] args) throws IOException {
		//BufferedReader br=new BufferedReader(new FileReader("badmilk.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("badmilk.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int d=Integer.parseInt(st.nextToken());
		int s=Integer.parseInt(st.nextToken());
		int p[]=new int[d];
		int m[]=new int[d];
		int t[]=new int[d];
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			p[i]=Integer.parseInt(st.nextToken());
			m[i]=Integer.parseInt(st.nextToken());
			t[i]=Integer.parseInt(st.nextToken());
		}
		int P[]=new int[s];
		int T[]=new int[s];
		for(int i=0;i<s;i++) {
			st=new StringTokenizer(br.readLine());
			P[i]=Integer.parseInt(st.nextToken());
			T[i]=Integer.parseInt(st.nextToken());
		}
		int ans=0;
		for(int i=1;i<=M;i++) {
		}
	}
}

