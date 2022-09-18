import java.io.*;
import java.util.*;
public class CowAtLarge {
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("atlarge.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("atlarge.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int start=Integer.parseInt(st.nextToken())-1;
	    al=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	al.add(new ArrayList<Integer>());
	    }
	    for(int i=0;i<n-1;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken())-1;
	    	int b=Integer.parseInt(st.nextToken())-1;
	    	al.get(a).add(b);
	    	al.get(b).add(a);
	    }
	    ArrayDeque<Integer>q=new ArrayDeque<>();
	    q.add(start);
	    int dist[]=new int[n];
	    Arrays.fill(dist, -1);
	    dist[start]=0;
	    //bessie bfs from start
	    while(!q.isEmpty()) {
	    	int cur=q.poll();
	    	for(int next:al.get(cur)) {
	    		if(dist[next]==-1) {
	    			dist[next]=dist[cur]+1;
	    			q.add(next);
	    		}
	    	}
	    }
	    int dist2[]=new int[n];
	    //farmer bfs, all leaf nodes
	    Arrays.fill(dist2, -1);
	    for(int i=0;i<n;i++) {
	    	if(al.get(i).size()==1) {
	    		q.add(i);
	    		dist2[i]=0;
	    	}
	    }
	    while(!q.isEmpty()) {
	    	int cur=q.poll();
	    	for(int next:al.get(cur)) {
	    		if(dist2[next]==-1) {
	    			dist2[next]=dist2[cur]+1;
	    			q.add(next);
	    		}
	    	}
	    }
	    q.add(start);
	    boolean vis[]=new boolean[n];
	    vis[start]=true;
	    int count=0;
	    //if bessie reaches this place before we block all paths from this subtree
	    while(!q.isEmpty()) {
	    	int cur=q.poll();
	    	if(dist2[cur]<=dist[cur]) {
	    		count++;
	    		continue;
	    	}
	    	for(int next:al.get(cur)) {
	    		if(!vis[next]) {
	    			vis[next]=true;
	    			q.add(next);
	    		}
	    	}
	    }
	    out.println(count);
	    pw.println(count);
	    pw.close();
	    //out.close();
	}
}
