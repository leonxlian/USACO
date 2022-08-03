import java.io.*;
import java.util.*;
public class FineDining {
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	static HashMap<String, Long>hm=new HashMap<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("dining.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("dining.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int m=Integer.parseInt(st.nextToken());
	    int k=Integer.parseInt(st.nextToken());
	    al=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	al.add(new ArrayList<Integer>());
	    }
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken())-1;
	    	int b=Integer.parseInt(st.nextToken())-1;
	    	long weight=Long.parseLong(st.nextToken());
	    	al.get(a).add(b);
	    	al.get(b).add(a);
	    	hm.put(a+" "+b, weight);
	    	hm.put(b+" "+a, weight);
	    }
	    long[] dijk=new long[n];
	    Arrays.fill(dijk, Long.MAX_VALUE);
	    //dijkstra from end
	    PriorityQueue<Integer>pq=new PriorityQueue<>((Integer p1, Integer p2)->Long.compare(dijk[p1], dijk[p2]));
	    dijk[n-1]=0;
	    pq.add(n-1);
	    while(!pq.isEmpty()) {
	    	int cur=pq.poll();
	    	for(int next:al.get(cur)) {
	    		long c=hm.get(cur+" "+next);
	    		if(dijk[next]>dijk[cur]+c) {
	    			dijk[next]=dijk[cur]+c;
	    			pq.add(next);
	    		}
	    	}
	    }
	    //add an extra node that connects to all the haybales
	    al.add(new ArrayList<Integer>());
	    for(int i=0;i<k;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken())-1;
	    	int val=Integer.parseInt(st.nextToken());
	    	//shortest distance from the end to a haybale, subtract the value to get negative weight that I can compensate
	    	if(hm.containsKey(a+" "+n)&&dijk[a]-val<=hm.get(a+" "+n)) {//if there is better haybale
	    		hm.put(a+" "+n, dijk[a]-val);
	    		hm.put(n+" "+a, dijk[a]-val);
	    	}else {
	    		al.get(n).add(a);
		    	al.get(a).add(n);
		    	hm.put(a+" "+n, dijk[a]-val);
		    	hm.put(n+" "+a, dijk[a]-val);
	    	}
	    }
	    //System.out.println(hm.get(1+" "+4));
	    long dijk1[]=new long[n+1];
	    Arrays.fill(dijk1, Long.MAX_VALUE);
	    PriorityQueue<Integer>pq1=new PriorityQueue<>((Integer p1, Integer p2)->Long.compare(dijk1[p1], dijk1[p2]));
	    dijk1[n]=0;
	    pq1.add(n);
	    //do dijkstra from the node that connects to all haybales with compensated edges
	    while(!pq1.isEmpty()) {
	    	int cur=pq1.poll();
	    	for(int next:al.get(cur)) {
	    		long c=hm.get(cur+" "+next);
	    		if(dijk1[next]>dijk1[cur]+c&&dijk1[next]>=0) {
	    			dijk1[next]=dijk1[cur]+c;
	    			pq1.add(next);
	    		}
	    	}
	    }
	    /*for(int i=0;i<=n;i++) {
	    	out.println(dijk1[i]);
	    }*/
	    //if the distance from the current node to the end node is shorter answer is yes
	    for(int i=0;i<n-1;i++) {
	    	if(dijk1[i]<=dijk[i]) {
	    		out.println(1);
	    		pw.println(1);
	    	}else {
	    		out.println(0);
	    		pw.println(0);
	    	}
	    }
	    pw.close();
	    //out.close();
	}
}