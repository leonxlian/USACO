import java.io.*;
import java.util.*;
public class MilkPumping {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        ArrayList<edge>edges=new ArrayList<>();
        HashMap<Integer, ArrayList<edge>>hm=new HashMap<>();
        for(int i=0;i<m;i++) {
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	int cost=Integer.parseInt(st.nextToken());
        	int flow=Integer.parseInt(st.nextToken());
        	edges.add(new edge(a, b, cost, flow));
        	edges.add(new edge(b, a, cost, flow));
        	
        }
        for(int i=0;i<n;i++) {
        	hm.put(i, new ArrayList<edge>());
        }
	}
	static class edge{
		public int x, y, cost, flow;
		public edge(int x, int y, int cost, int flow) {
			this.x=x;this.y=y;this.cost=cost;this.flow=flow;
		}
	}
	static class compareCost implements Comparator<edge>{
		public int compare(edge a, edge b) {
			return a.cost-b.cost;
		}
	}
	static class compareFlow implements Comparator<edge>{
		public int compare(edge a, edge b) {
			return b.flow-a.flow;
		}
	}

}
