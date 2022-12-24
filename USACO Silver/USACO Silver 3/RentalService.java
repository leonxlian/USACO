import java.io.*;
import java.util.*;
public class RentalService {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		long[] cows=new long[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			cows[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(cows);
		state a[]=new state[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=new state(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(a);
		int[] b=new int[r];
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			b[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(b);
		int c[]=new int[r];
		for(int i=0;i<r;i++) {
			c[i]=b[r-i-1];
		}
		long cur=0;
		for(int i=0;i<r&&i<n;i++) {
			cur+=c[i];
		}
		int j=0;
		if(n>r) {//sell to store
			long t=0;//can't rent
			for(int i=r;i<n;i++) {
				t+=cows[i];
			}
			while(t>0&&j<m) {
				if(t>a[j].i) { //if store can take 
					cur+=a[j].i*a[j].v;
					t-=a[j].i;
					a[j].i=0;
					j++;
				}else {
					cur+=t*a[j].v;
					a[j].i-=t;
					break;
				}
			}
		}
		long ans=cur;
		if(j<m) {
			int last=0;
			if(n>=r) {//if more cows than rents
				last=r-1;
			}else {//if less cow then rents
				last=n-1;
			}
			while(last>=0&&j<m) {//while there are still last to check
				cur-=c[last];//subtract rental value
				long t=cows[last];//get the current cow milk production
				while(t>0&&j<m) {
					if(t>a[j].i) { //store takes full
						cur+=a[j].i*a[j].v;
						t-=a[j].i;
						a[j].i=0;
						j++;
					}else {//store takes leftover
						cur+=t*a[j].v;
						a[j].i-=t;
						break;
					}
				}//after cur has been changed, compare it with the prev answer to see if it has increased the money;
				ans=Math.max(ans, cur);
				last--;
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
			return o.v-v;
		}
	}
}
