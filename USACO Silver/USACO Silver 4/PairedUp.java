import java.io.*;
import java.util.*;
public class PairedUp {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=new state(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		int j=n-1;
		int i=0;
		int curi=a[i].i;
		int curj=a[j].i;
		int min=0;
		while(true) {
			if(i>j) {
				break;
			}else if(i==j) {
				min=Math.max(min, a[i].v+a[j].v);
				break;
			}
			if(curi<curj) {
				curj-=curi;
				min=Math.max(min, a[i].v+a[j].v);
				i++;
				curi=a[i].i;
			}else if(curi==curj) {
				i++;
				j--;
				min=Math.max(min, a[i].v+a[j].v);
				curi=a[i].i;
				curj=a[j].i;
			}else {
				curi-=curj;
				min=Math.max(min, a[i].v+a[j].v);
				j--;
				curj=a[j].i;
			}
		}
		//out.println(min);
		//out.close();
		pw.println(min);
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
