import java.io.*;
import java.util.*;

public class Superbull {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("superbull.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("superbull.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int []a=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		PriorityQueue<state> pq=new PriorityQueue<state>();
		for(int i=1;i<n;i++) {
			pq.offer(new state(0, i, a[0]^a[i]));//put in players and result
		}
		long ans=0;
		boolean[] v=new boolean[n];
		v[0]=true;
		int num=0;
		while(num<n-1) {
			state cur=pq.poll(); //give largest weight
			if(v[cur.x]&&v[cur.y])continue; //two players matched before
			int next=v[cur.x]?cur.y:cur.x;//choose next player
			ans+=cur.w;
			v[next]=true;
			num++; //already found the next player with the largest score with current player
			for(int i=0;i<n;i++) {
				if(i!=next) {
					pq.offer(new state(next,i, a[next]^a[i])); //play next player and the rest
				}
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static class state implements Comparable<state>{
		int x, y, w;
		public state(int x, int y, int w) {
			this.x=x;this.y=y;this.w=w;
		}
		public int compareTo(state o) {
			return o.w-w;
		}
	}
}

