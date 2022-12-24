import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad1 {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int c=Integer.parseInt(st.nextToken());//chicken
		int n=Integer.parseInt(st.nextToken());
		state animals[]=new state[c+n];
		for(int i=0;i<c;i++) {
			st=new StringTokenizer(br.readLine());
			int chicken=Integer.parseInt(st.nextToken());
			animals[i]=new state(chicken, chicken, false);
		}
		state cow[]=new state[n];
		for(int i=c;i<c+n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			animals[i]=new state(a, b, true);
		}
		Arrays.sort(animals);
		int ans=0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i=0; i<animals.length; i++) {

			// If it's a cow, add it to our list of cows waiting to get help from chickens.
			if (animals[i].isCow) {
				pq.offer(animals[i].b);
			// We get a chicken!
			}else {
				// Get rid of cows who are no longer avaiable.
				while (pq.size() > 0 && pq.peek() < animals[i].a) pq.poll();
				// This chicken can help a cow!
				if (pq.size() > 0) {
					ans++;
					// We greedily remove the cow who is available the least.
					pq.poll();
				}
			}
		}
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
	static class state implements Comparable<state>{
		int a, b;
		public boolean isCow;
		public state(int a, int b, boolean isCow) {
			this.a=a;this.b=b;this.isCow=isCow;
		}
		public int compareTo(state o) {
			if (this.a != o.a)
				return this.a - o.a;
			if (this.isCow && !o.isCow) return -1;
			if (!this.isCow && o.isCow) return 1;
			return 0;
		}
	}
}
