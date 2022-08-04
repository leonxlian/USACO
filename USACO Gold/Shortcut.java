import java.io.*;
import java.util.*;
public class Shortcut {
	public static PrintWriter out;
	static ArrayList<ArrayList<Pair>>al;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shortcut.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shortcut.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    long t=Long.parseLong(st.nextToken());
	    long a[]=new long[n];
	    st=new StringTokenizer(br.readLine());
	    al=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	al.add(new ArrayList<Pair>());
	    }
	    for(int i=0;i<n;i++) {
	    	a[i]=Integer.parseInt(st.nextToken());
	    }
	    //add weights
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken())-1;
	    	int y=Integer.parseInt(st.nextToken())-1;
	    	long weight=Long.parseLong(st.nextToken());
	    	al.get(x).add(new Pair(y, weight));
	    	al.get(y).add(new Pair(x, weight));
	    }
	    long dijk[]=new long[n];
	    int from[]=new int[n];
	    Arrays.fill(from, -1);
	    Arrays.fill(dijk, Long.MAX_VALUE);
	    PriorityQueue<Integer>pq=new PriorityQueue<>((Integer p1, Integer p2)->Long.compare(dijk[p1],dijk[p2]));
	    dijk[0]=0;
	    pq.add(0);
	    //do a dijkstra from the ending node
	    while(!pq.isEmpty()) {
	    	int cur=pq.poll();
	    	for(Pair p:al.get(cur)) {
	    		int next=p.x;
	    		long c=p.weight;
	    		if(dijk[next]>dijk[cur]+c) {
	    			from[next]=cur;
	    			dijk[next]=(long)(dijk[cur]+c);
	    			pq.add(next);
	    		}else if(dijk[next]==dijk[cur]+c&&cur<from[next]) {//lexicographically smaller
	    			from[next]=cur;
	    			pq.add(next);
	    		}
	    	}
	    }
	    //backtrack and get sum of nodes that go through this point
	    long sum[]=new long[n];
	    for(int i=0;i<n;i++) {
	    	int cur=i;
	    	while(cur!=-1) {
	    		sum[cur]+=a[i];
	    		cur=from[cur];
	    	}
	    }
	    //get max answer
	    long ans=0;
	    for(int i=0;i<n;i++) {
	    	//if(i!=0) {
	    	ans=Math.max(ans, sum[i]*(dijk[i]-t));
	    	//}
	    }
	    out.println(ans);
	    pw.println(ans);
	    pw.close();
	    //out.close();
	}
	static class Pair{
		int x; 
		long weight;
		public Pair(int x, long weight) {
			this.x=x;this.weight=weight;
		}
	}
}
