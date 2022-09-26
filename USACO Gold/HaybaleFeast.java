import java.io.*;
import java.util.*;
public class HaybaleFeast {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader("hayfeast.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hayfeast.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    long flavor=Long.parseLong(st.nextToken());
	    int f[]=new int[n];
	    int s[]=new int[n];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	f[i]=Integer.parseInt(st.nextToken());
	    	s[i]=Integer.parseInt(st.nextToken());
	    }
	    int left=0;
	    int ans=Integer.MAX_VALUE;
	    long sum=0;
	    TreeMap<Integer, Integer>tm=new TreeMap<>();
	    for(int i=0;i<n;i++) {
	    	sum+=f[i];
	    	update(tm, s[i], 1);
	    	while(sum>=flavor&&left<n) {
	    		ans=Math.min(ans, tm.lastKey());
	    		update(tm, s[left], -1);
	    		sum-=f[left++];
	    	}
	    }
	    out.println(ans);
	    pw.println(ans);
	    //out.close();
	    pw.close();
	}
	static void update(TreeMap<Integer, Integer>tm, int s, int upd) {
		if(upd==1) {
			tm.put(s, tm.getOrDefault(s, 0)+1);
		}else if(upd==-1) {
			tm.put(s, tm.getOrDefault(s, 0)-1);
		}
		if(tm.get(s)==0) {
			tm.remove(s);
		}
	}
}
