import java.io.*;
import java.util.*;
public class Convention2{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("convention2.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		Cow a[]=new Cow[n];
		TreeSet<Cow>ts=new TreeSet<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int arrive=Integer.parseInt(st.nextToken());
			int time=Integer.parseInt(st.nextToken());
			a[i]=new Cow(arrive, time, i);
			ts.add(a[i]);
		}
		Arrays.sort(a);
		long time=a[0].start+a[0].time;
		long ans=0;
		ts.remove(ts.first());
		for(int i=1;i<n;i++) {
			Cow first=ts.first();
			if(first.start<=time) {
				Iterator it=ts.iterator();
				while(it.hasNext()) {
					Cow cur=(Cow) it.next();
					if(cur.start<=time) {
						if(cur.i<first.i) {
							first=cur;
						}
					}else {
						break;
					}
				}
				ans=Math.max(ans, Math.abs(first.start-time));
				time+=first.time;
			}else {
				time=first.start+first.time;
			}
			ts.remove(first);
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
	static class Cow implements Comparable<Cow>{
		int start, time, i;
		public Cow(int start, int time, int i) {
			this.start=start;this.time=time;this.i=i;
		}
		public int compareTo(Cow o) {
			if(start==o.start) {
				return i-o.i;
			}else {
				return start-o.start;
			}
		}
	}
}
