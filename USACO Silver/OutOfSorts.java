import java.io.*;
import java.util.*;
public class OutOfSorts {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int v=Integer.parseInt(st.nextToken());
			a[i]=new state(i, v);
		}
		Arrays.sort(a);
		int ans=0;
		for(int i=0;i<n;i++) {
			ans=Math.max(ans, a[i].n-i);
		}
		//System.out.println(ans+1);
		pw.println(ans+1);
		pw.close();
	}
	static class state implements Comparable<state>{
		Integer n;
		Integer m; 
		public state(int n, int m) {
			this.n=n;this.m=m;
		}
		public int compareTo(state o) {
			return m-o.m;
		}
	}
}