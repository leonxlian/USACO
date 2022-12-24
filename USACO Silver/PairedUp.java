import java.io.*;
import java.util.*;
public class PairedUp {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			a[i]=new state(x, y); 
		}
		Arrays.sort(a);
		int ret=0;
		int i=0; // start 
		int j=n-1; // end
		while(i<=j) {
			int x=Math.min(a[i].n, a[j].n); //how many cows can be matched
			if(i==j) { //final middle group
				x=x/2;
			}
			ret=Math.max(ret,a[i].m+a[j].m); //pair i and j
			a[i].n-=x; //update and count of cow
			a[j].n-=x;
			if(a[i].n==0) {
				i++;
			}
			if(a[j].n==0) {
				j--;
			}
		}
		//System.out.println(ret);
		pw.println(ret);
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
