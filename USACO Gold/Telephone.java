import java.io.*;
import java.util.*;
public class Telephone {
	public static PrintWriter out;
	static ArrayList<TreeSet<Integer>>al;
	static ArrayList<ArrayList<Integer>>adj;
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int k=Integer.parseInt(st.nextToken());
	    al=new ArrayList<>();
	    for(int i=0;i<k;i++) {
	    	al.add(new TreeSet<Integer>());
	    }
	    adj=new ArrayList<>();
	    int a[]=new int[n];
	    st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	    	a[i]=Integer.parseInt(st.nextToken())-1;
	    	al.get(a[i]).add(i);
	    	adj.add(new ArrayList<Integer>());
	    }
	    int grid[][]=new int[k][k];
	    for(int i=0;i<k;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	String s=st.nextToken();
	    	for(int j=0;j<k;j++) {
	    		grid[i][j]=(s.charAt(j)-'0');
	    	}
	    }
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<k;j++) {
	    		if(grid[a[i]][j]==1) {
	    			Integer low=al.get(j).lower(i);
	    			Integer high=al.get(j).higher(i);
	    			if(low!=null) {
	    				adj.get(i).add(low);
	    			}
	    			if(high!=null) {
	    				adj.get(i).add(high);
	    			}
	    		}
	    	}
	    }
	    /*for(int i=0;i<n;i++){
	    	for(int cur:adj.get(i)) {
	    		out.println(i+" "+cur);
	    	}
	    }*/
	    int dijk[]=new int[n];
	    Arrays.fill(dijk, Integer.MAX_VALUE);
	    PriorityQueue<Integer>q=new PriorityQueue<>((Integer p1, Integer p2)->Integer.compare(dijk[p1], dijk[p2]));
	    q.add(0);
	    int ans=Integer.MAX_VALUE;
	    dijk[0]=0;
	    while(!q.isEmpty()) {
	    	int cur=q.poll();
	    	if(grid[a[cur]][a[n-1]]==1) {
	    		ans=Math.min(dijk[cur]+Math.abs(cur-(n-1)), ans);
	    	}
	    	for(int next:adj.get(cur)) {
	    		int cost=Math.abs(cur-next);
	    		if(dijk[next]>dijk[cur]+cost) {
	    			dijk[next]=dijk[cur]+cost;
	    			q.add(next);
	    		}
	    	}
	    }
	    out.println(Math.min(dijk[n-1], ans));
	    out.close();
	}
}


/*
1 4 2 3 4


//connect node value to itself
*/