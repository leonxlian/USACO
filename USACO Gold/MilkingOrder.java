import java.io.*;
import java.util.*;
public class MilkingOrder {
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	static ArrayList<ArrayList<Pair>>edges;
	static int n;
	static ArrayList<Integer>ans;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkorder.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkorder.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    edges=new ArrayList<>();
	    al=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	al.add(new ArrayList<Integer>());
	    }
	    //add each layer
	    //edges[i] contains all connections on observation i
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int l=Integer.parseInt(st.nextToken());
	    	edges.add(new ArrayList<Pair>());
	    	int last=-1;
	    	for(int j=0;j<l;j++) {
	    		int cur=Integer.parseInt(st.nextToken())-1;
	    		if(j>0) {
	    			edges.get(i).add(new Pair(last, cur));
	    		}
	    		last=cur;
	    	}
	    }
	    //binary search on answer
	    int low=0;
	    int high=m+1;
	    int ret=0;
	    while(low<high-1) {
	    	int mid=(low+high)/2;
	    	if(check(mid)) {
	    		low=mid;
	    		ret=low;
	    	}else {
	    		high=mid;
	    	}
	    }
	    check(ret);
	    for(int i=0;i<ans.size();i++) {
	    	if(i==ans.size()-1) {
	    		pw.println(ans.get(i)+1);
	    		continue;
	    	}
	    	out.print((ans.get(i)+1)+" ");
	    	pw.print((ans.get(i)+1)+" ");
	    }
	    pw.close();
	    //out.close();
	}
	static boolean check(int mid) {
		int in_deg[]=new int[n];
		//clear adj list
		for(int i=0;i<n;i++) {
			al.get(i).clear();
		}
		//connect connections up to this observation
		for(int i=0;i<mid;i++) {
			for(Pair p:edges.get(i)) {
				al.get(p.x).add(p.y);
				in_deg[p.y]++;
			}
		}
		/*for(int i=0;i<n;i++) {
			for(int next:al.get(i)) {
				out.println(i+" "+next);
			}
		}*/
		//kahns
		PriorityQueue<Integer>q=new PriorityQueue<>();
		for(int i=0;i<n;i++){
			if(in_deg[i]==0) {
				q.add(i);
			}
		}
		ans=new ArrayList<Integer>();
		while(!q.isEmpty()) {
			int cur=q.poll();
			ans.add(cur);
			for(int next:al.get(cur)) {
				in_deg[next]--;
				if(in_deg[next]==0) {
					q.add(next);
				}
			}
		}
		//ake sure it's possible
		return ans.size()==n;
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
	}
}