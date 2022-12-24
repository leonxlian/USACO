import java.io.*;
import java.util.*;
public class Meetings {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("herding.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int l=Integer.parseInt(st.nextToken());
		ArrayList<state> a=new ArrayList<state>();
		ArrayList<Integer>left=new ArrayList<>();
		ArrayList<Integer>right=new ArrayList<>();
		ArrayList<pair>tw=new ArrayList<>();
		ArrayList<Integer>leftx=new ArrayList<>();
		int weight=0;
		for(int i=0;i<n;i++) {
			int w=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			a.add(new state(x, w, d));
			weight+=w;
			if(d==-1) {
				leftx.add(x);
			}
		}
		Collections.sort(a);
		for(int i=0;i<n;i++) {
			if(a.get(i).d==-1) {
				left.add(a.get(i).x);
			}else {
				right.add(l-a.get(i).x);
			}
		}
		for(int i=0;i<left.size();i++) {
			tw.add(new pair(left.get(i), a.get(i).w));
		}
		Collections.sort(right, Collections.reverseOrder());
		for(int i=0;i<right.size();i++) {
			tw.add(new pair(right.get(i), a.get(n-i-1).w));
		}
		Collections.sort(tw);
		int count=0;
		int t=0;
		while(2*count<weight) {
			count+=tw.get(t).w;
			t++;
		}
		t=tw.get(t-1).t;
		Collections.sort(leftx);
		int ans=0;
		for(int i=0;i<n;i++) {
			if(a.get(i).d==1) {
				
			}
		}
	}
	static class state implements Comparable<state>{
		int x, w, d;
		public state(int x, int w, int d) {
			this.x=x;this.w=w;this.d=d;
		}
		public int compareTo(state o) {
		if(x==o.x)return w-o.w;
		if(w==o.w)return d-o.d;
		else return x-o.x;
		}
	}
	static class pair implements Comparable<pair>{
		int t, w;
		public pair(int t, int w) {
			this.t=t;this.w=w;
		}
		public int compareTo(pair o) {
		if(t==o.t)return w-o.w;
		else return t-o.t;
		}
	}
}
