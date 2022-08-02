import java.io.*;
import java.util.*;
public class MilkPumping {
	static ArrayList<ArrayList<state>>edge;
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pump.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pump.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        out=new PrintWriter(System.out);
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        edge=new ArrayList<>();
        for(int i=0;i<n;i++) {
        	edge.add(new ArrayList<state>());
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	int cost=Integer.parseInt(st.nextToken());
        	int flow=Integer.parseInt(st.nextToken());
        	edge.get(a).add(new state(b, cost, flow));
        	edge.get(b).add(new state(a, cost, flow));
        }
        int dp[][]=new int[1001][1001];//smallest cost by node n and flow rate f
        for(int i=0;i<1001;i++) {
        	Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][1000]=0;
        double ret=-1;
        PriorityQueue<Pair>pq=new PriorityQueue<Pair>((Pair p1, Pair p2)->
        	Integer.compare(dp[p1.node][p1.flow], dp[p2.node][p2.flow]));//sort by smallest cost
        pq.add(new Pair(0, 1000));
        while(!pq.isEmpty()) {
        	Pair cur=pq.poll();
        	if(cur.node==n-1) {
        		//reached end node
        		ret=Math.max(ret, (double)cur.flow/dp[cur.node][cur.flow]);
        		continue;
        	}
        	for(state next:edge.get(cur.node)) {
        		int nextFlow=Math.min(cur.flow, next.flow);
        		int nextCost=dp[cur.node][cur.flow]+next.cost;
        		int nextNode=next.node;
        		if(dp[nextNode][nextFlow]>nextCost) {//dijkstra to get next smallest cost
        			dp[nextNode][nextFlow]=nextCost;
        			pq.add(new Pair(nextNode, nextFlow));
        		}
        	}
        }
        out.println((int)(ret*1000000));
        pw.println((int)(ret*1000000));
        pw.close();
        //out.close();
	}
	static class Pair{
		int node, flow;
		public Pair(int node, int flow) {
			this.node=node;this.flow=flow;
		}
	}
	static class state{
		int node, cost, flow;
		public state(int node, int cost, int flow) {
			this.node=node;this.cost=cost;this.flow=flow;
		}
	}
}
