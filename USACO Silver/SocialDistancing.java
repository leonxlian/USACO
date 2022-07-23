import java.io.*;
import java.util.*;
public class SocialDistancing {
	static int n, m;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("socdist.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("socdist.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		state[] arr=new state[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			Long a=Long.parseLong(st.nextToken());
			Long b=Long.parseLong(st.nextToken());
			arr[i]=new state(a, b);
		}
		Arrays.sort(arr);
		int low=0;
		int high=1000000000;
		while(low<high) {
			int mid=(low+high+1)/2;
			if(check(mid, arr)) {
				low=mid;
			}else {
				high=mid-1;
			}
		}
		System.out.println(low);
		pw.println(low);
		pw.close();
	}
	public static boolean check(int mid, state arr[]) {
		long curx=arr[0].a;
		int curinterval=0;
		for(int i=1;i<n;i++) {
			curx+=mid;
			while(curinterval<m&&(arr[curinterval].b<curx)) {
				curinterval++;
			}
			if(curinterval==m) {
				return false;
			}
			if(arr[curinterval].a>curx) {
				curx=arr[curinterval].a;
			}
		}
		return true;
	}
	static class state implements Comparable<state>{
		long a, b;
		public state(long a, long b) {
			this.a=a;this.b=b;
		}
		public int compareTo(state o) {
			return Long.compare(a, o.a);
		}
	}
}
