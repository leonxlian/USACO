import java.io.*;
import java.util.*;
public class OutOfSorts{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("sort.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sort.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			a[i]=new state(x, i);
		}
		Arrays.sort(a);
		int count=0;
		for(int i=0;i<n;i++) {
			count=Math.max(count, a[i].v-i+1);
		}
		//out.println(count);
		//out.close();
		pw.println(count);
		pw.close();
	}
	static class state implements Comparable<state>{
		int i, v;
		public state(int i, int v) {
			this.i=i;this.v=v;
		}
		public int compareTo(state o) {
			if(i==o.i)return v-o.v;
			else return i-o.i;
		}
	}
}
