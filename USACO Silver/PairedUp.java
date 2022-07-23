import java.io.*;
import java.util.*;
public class PairedUp {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int num=Integer.parseInt(st.nextToken());
			int milk=Integer.parseInt(st.nextToken());
			a[i]=new state(num, milk);
		}
		Arrays.sort(a);
		int ans=0;
		int i=0;
		int j=n-1;
		while(i<=j) {
			int x=Math.min(a[i].i, a[j].i);
			if(i==j) {
				x/=2;
			}
			ans=Math.max(ans, a[i].v+a[j].v);
			a[i].i-=x;
			a[j].i-=x;
			if(a[i].i==0) {
				i++;
			}
			if(a[j].i==0) {
				j--;
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static class state implements Comparable<state>{
		int i, v;
		public state(int i, int v) {
			this.i=i;this.v=v;
		}
		public int compareTo(state o) {
			return v-o.v;
		}
	}
}
