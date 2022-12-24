import java.io.*;
import java.util.*;
public class LemonadeLine {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int w[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			w[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(w);
		int a[]=new int[n];
		int time=0;
		int count=0;
		for(int i=n-1;i>=0;i--) {
			if(w[i]<time) {
				break;
			}
			time++;
		}
		//System.out.println(time);
		pw.println(time);
		pw.close();
	}
}
