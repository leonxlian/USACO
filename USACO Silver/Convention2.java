import java.io.*;
import java.util.*;
public class Convention2 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		TreeSet<state>cow=new TreeSet<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int t=Integer.parseInt(st.nextToken());
			cow.add(new state(a, t, i));
		}
		int ans=0;
		int time=cow.first().arrival+cow.first().eating;
		cow.remove(cow.first());
		for(int i=1;i<n;i++) {
			state higher=cow.first();
			if(higher.arrival<=time) {
				Iterator it=cow.iterator();
				while(it.hasNext()) {
					state next=(state) it.next();
					if(next.arrival<=time) {
						if(higher.seniority>next.seniority) {
							higher=next;
						}
					}else {
						break;
					}
				}
				ans=Math.max(ans, time-higher.arrival);
				time+=higher.eating;
			}else {
				time=higher.arrival+higher.eating;
			}
			cow.remove(higher);
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static class state implements Comparable<state>{
		int arrival, eating, seniority;
		public state(int arrival, int eating, int seniority) {
			this.arrival=arrival;this.eating=eating;this.seniority=seniority;
		}
		public int compareTo(state o) {
		if(arrival==o.arrival)return seniority-o.seniority;
		else return arrival-o.arrival;
		}
	}
}
