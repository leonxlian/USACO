import java.io.*;
import java.util.*;
public class FencePlanning {
	static int n;
	static HashSet<Integer>v;
	static ArrayList<Integer>[] adj;
	static int x[];
	static int y[];
	static int minX, minY, maxX, maxY;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
	    //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st=new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    x=new int[n];
	    y=new int[n];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	x[i]=Integer.parseInt(st.nextToken());
	    	y[i]=Integer.parseInt(st.nextToken());
	    }
	    adj=new ArrayList[n];
	    for(int i=0;i<n;i++) {
	    	adj[i]=new ArrayList<>();
	    }
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken())-1;
	    	int b=Integer.parseInt(st.nextToken())-1;
	    	adj[a].add(b);
	    	adj[b].add(a);
	    }
	    
	    int ans=Integer.MAX_VALUE;
	    v=new HashSet<Integer>();
	    for(int i=0;i<n;i++) {
	    	if(v.contains(i)) {
	    		continue;
	    	}
	    	minX=Integer.MAX_VALUE;
	    	maxX=Integer.MIN_VALUE;
	    	minY=Integer.MAX_VALUE;
	    	maxY=Integer.MIN_VALUE;
	    	dfs(i);
	    	int perimeter=2*((maxX - minX) + (maxY - minY));
	    	ans=Math.min(ans, perimeter);
	    }
	    //System.out.println(ans);
	    pw.println(ans);
	    pw.close();
	}
	static void dfs(int cur) {
		Queue<Integer>q=new LinkedList<>();
		q.add(cur);
		while(!q.isEmpty()) {
			int now=q.poll();
			for(int i: adj[now]) {
				if(!v.contains(i)) {
					q.add(i);
					v.add(i);
				}
			}
			minX=Math.min(minX, x[now]);
			maxX=Math.max(maxX, x[now]);
			minY=Math.min(minY, y[now]);
			maxY=Math.max(maxY, y[now]);
		}
	}
}
