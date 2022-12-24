import java.io.*;
import java.util.*;

public class ClosingTheFarm {
	static ArrayList<ArrayList<Integer>> connections = new ArrayList<ArrayList<Integer>>();
	static int v[];
	static int closed[];
	static HashSet<Integer> s=new HashSet<Integer>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());//order  closed
        int m=Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
        	connections.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken())-1;
        	int b=Integer.parseInt(st.nextToken())-1;
        	connections.get(a).add(b);
        	connections.get(b).add(a);
        }
        int c[]=new int[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	c[i]=Integer.parseInt(st.nextToken())-1;
        }
        v=new int[n];
        closed=new int[n];
        s=new HashSet<Integer>();
        dfs(1);
        if(s.size()==n) {
        	//System.out.println("YES");
        	pw.println("YES");
        }else {
        	//System.out.println("NO");
        	pw.println("NO");
        }
        for(int i=0;i<n-1;i++) {
        	s.clear();
        	Arrays.fill(v, 0);
        	closed[c[i]]=1;
        	dfs(c[n-1]);
        	if(s.size()==n-i-1) {
        		//System.out.println("YES");
        		pw.println("YES");
        	}else {
        		//System.out.println("NO");
        		pw.println("NO");
        	}
        }
        pw.close();
	}
	static void dfs(int cur) {
		if(v[cur]!=0||closed[cur]==1) {
			return;
		}
		s.add(cur);
		v[cur]=1;
		for(int i=0;i<connections.get(cur).size();i++) {
			dfs(connections.get(cur).get(i));
		}
	}
}
