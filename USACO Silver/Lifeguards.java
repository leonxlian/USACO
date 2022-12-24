import java.io.*;
import java.util.*;
public class Lifeguards {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n*2]; //start and end
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			a[i*2]=new state(s,i);
			a[i*2+1]=new state(e,i);
		}
		Arrays.sort(a);//(1,1) (3,2) (4,1) (5,0) (7,2) (9,0)
		int t=0; //1-9 have 8 coverage
		int b[]=new int[n];//single coverage for each lifeguard
		int p=0;
		TreeSet<Integer>ts=new TreeSet<Integer>(); //track the in and out for the lifeguards
		for(state cur:a) {
			if(ts.size()==1) { //only one coverage, find the group number
				b[ts.first()]+=cur.p-p;//update the single appearance until we see another coverage
			}
			if(!ts.isEmpty()) {//there is some coverage, count in total
				t+=cur.p-p;
			}
			if(ts.contains(cur.i)){//starting point already add the group index in the ts
				ts.remove(cur.i);//we reach the ending point, we need to remove this group out of ts
			}else {
				ts.add(cur.i);//we reach starting point, add to the ts
			}
				p=cur.p;
		}
			int ret=0;
			for(int i=0;i<n;i++) {
				ret=Math.max(ret,t-b[i]);
			}
			//System.out.println(ret);
			pw.println(ret);
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
