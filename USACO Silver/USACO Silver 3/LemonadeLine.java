import java.io.*;
import java.util.*;
public class LemonadeLine {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lemonade.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int ans=0;
		int b[]=new int[n];
		for(int i=0;i<n;i++) {
			b[i]=a[n-i-1];
		}
		int index=1;
		ArrayList<Integer> aa=new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			if(b[i]>=aa.size()) {
				aa.add(b[i]);
				ans++;
			}
		}
		System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}