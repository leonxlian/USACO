import java.io.*;
import java.util.*;
public class MountainView {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			a[i]=new state(x, y);
		}
		Arrays.sort(a);//sort by left then right
		int max=-1;int ans=0;
		for(int i=0;i<n;i++) { //count only if current mountain right is greater than the big mountain right
			if(a[i].r>max) { 
				ans++;
				max=a[i].r;
			}
		}
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
	static class state implements Comparable<state>{
		int x,y,l,r;
		public state(int x, int y) {
			this.x=x;this.y=y;this.l=x-y;this.r=x+y;
		}
		public int compareTo(state o) {
		if(l==o.l)return r-o.r;
		else return l-o.l;
		}
	}
}
