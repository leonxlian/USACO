import java.io.*;
import java.util.*;
public class HoofBall {
	public static void main(String[] args)throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader("hoofball.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int ans=0;
		Arrays.sort(a);
		for(int i=0;i<n;i++) {
			
		}
	}
}
