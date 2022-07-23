import java.io.*;
import java.util.*;
public class Cowntagion {
	static ArrayList<ArrayList<Integer>> connections=new ArrayList<ArrayList<Integer>>();
	static boolean v[];
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        v=new boolean[n];
        for(int i=0;i<n;i++) {
        	connections.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n-1;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	connections.get(a).add(b);
        	connections.get(b).add(a);
        }
        v[0]=true;
        int ans=0;
        ArrayDeque<Integer>q=new ArrayDeque<>();
        q.add(0);
        for(int i=0;i<n;i++) {
        	while(!q.isEmpty()) {
        		int cur=q.poll();
	        	int unvis=0;
	        	for(int next:connections.get(cur)) { //check neighbors
	        		if(!v[next]) {
	        			unvis++;	//see how many unvisited neighbors
	        			v[next]=true; //visit all unvisited neighbors
	        			q.add(next);
	        		}
	        	}
	        	int k=1;
	    		int days=0;
	    		days+=unvis;
	    		while(k<unvis+1) {//check how many days it needs
	    			days++;
	    			k*=2;
	    		}
	    		ans+=days;
        	}
        }
        System.out.println(ans);
	}
}
