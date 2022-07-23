import java.io.*;
import java.util.*;
public class Lifeguards {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n*2];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			a[i*2]=new state(s,i);
			a[i*2+1]=new state(e,i);
		}
		Arrays.sort(a);
		int t=0;//(1,1) (3,2) (4,1) (5,0) (7,2) (9,0)
		int b[]=new int[n];
		int p=0;//previous position
		TreeSet<Integer> ts=new TreeSet<Integer>();
		for(state cur: a) {
			if(ts.size()==1) {//only one coverage
				b[ts.first()]+=cur.p-p;//current minus previous position, update single appearance
			}
			if(!ts.isEmpty()) {//there is some coverage, count in total
				t+=cur.p-p;//add the difference between the previous position and the position right now
			}
			if(ts.contains(cur.i)) {//starting point already add the group index in the ts
				ts.remove(cur.i);//we reach the ending point, we need to remove this group out of ts
			}else {
				ts.add(cur.i);//we reach starting point, add to the ts
			}
			p=cur.p;
		}
		int max=0;
		for(int i=0;i<n;i++) {
			max=Math.max(max, t-b[i]);
		}
		//System.out.println(max);
		pw.println(max);
		pw.close();
	}
	static class state implements Comparable<state>{
		int p, i; //position and index
		public state(int p, int i) {
			this.p=p; this.i=i;
		}
		public int compareTo(state o) {
			return p-o.p;
		}
	}
}
