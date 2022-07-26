import java.io.*;
import java.util.*;
public class LasersAndMirrors {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lasers.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lasers.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    Pair p[]=new Pair[n+2];
	    HashMap<Integer, ArrayList<Integer>>vertical=new HashMap<>();//same x
	    HashMap<Integer, ArrayList<Integer>>horizontal=new HashMap<>();//same y
	    int x1=Integer.parseInt(st.nextToken());
	    int y1=Integer.parseInt(st.nextToken());
	    int x2=Integer.parseInt(st.nextToken());
	    int y2=Integer.parseInt(st.nextToken());
	    p[0]=new Pair(x1, y1);
	    p[n+1]=new Pair(x2, y2);
	    for(int i=1;i<=n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken());
	    	int y=Integer.parseInt(st.nextToken());
	    	p[i]=new Pair(x, y);
	    }
	    //connect every x with its corresponding x, y as well
	    for(int i=0;i<=n+1;i++) {
	    	int x=p[i].x;
	    	int y=p[i].y;
	    	if(!vertical.containsKey(x)) {
	    		vertical.put(x, new ArrayList<Integer>());
	    	}
	    	if(!horizontal.containsKey(y)) {
	    		horizontal.put(y, new ArrayList<Integer>());
	    	}
	    	vertical.get(x).add(i);
	    	horizontal.get(y).add(i);
	    }
	    int dist[]=new int[n+2];
	    Arrays.fill(dist, -1);
	    ArrayDeque<Line>q=new ArrayDeque<>();
	    q.add(new Line(0, true));
	    q.add(new Line(0, false));
	    dist[0]=0;
	    //do a bfs on points
	    while(!q.isEmpty()) {
	    	int id=q.peek().i;
	    	boolean isVertical=q.peek().vertical;
	    	q.poll();
	    	if(isVertical) {
	    		int cur=p[id].x;//going to go up
	    		for(int next:vertical.get(cur)) {
	    			if(dist[next]==-1) {
	    				dist[next]=dist[id]+1;
	    				q.add(new Line(next,!isVertical));
	    			}
	    		}
	    	}else {
	    		int cur=p[id].y;//going to go up
	    		for(int next:horizontal.get(cur)) {
	    			if(dist[next]==-1) {
	    				dist[next]=dist[id]+1;
	    				q.add(new Line(next,!isVertical));
	    			}
	    		}
	    		//going to go to the right and left
	    	}
	    }
	    //out.println(dist[n+1]!=-1?dist[n+1]-1:-1);
	    //out.close();
	    pw.println(dist[n+1]!=-1?dist[n+1]-1:-1);
	    pw.close();
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
	}
	static class Line{
		int i;
		boolean vertical;
		public Line(int i, boolean vertical) {
			this.i=i;this.vertical=vertical;
		}
	}
}
