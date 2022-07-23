import java.io.*;
import java.util.*;
public class CowntactTracing {
	public static void main(String[] args)throws IOException {
		//BufferedReader br=new BufferedReader(new FileReader("socdist2.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int t=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String s=st.nextToken();
		int time[]=new int[t];
		int x[]=new int[t];
		int y[]=new int[t];
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			time[i]=Integer.parseInt(st.nextToken());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
		}
	}
}
