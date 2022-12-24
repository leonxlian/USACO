import java.io.*;
import java.util.*;
public class ClosingTheFarm2 {
	static ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();//same
	static boolean v[];
	static boolean closed[];
	static HashSet<Integer>s=new HashSet<>();
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        v=new boolean[n+1];
        closed=new boolean[n+1];
        for(int i=0;i<n+1;i++) {
        	aa.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	aa.get(a).add(b);
        	aa.get(b).add(a);
        }
        int c[]=new int[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	c[i]=Integer.parseInt(st.nextToken());
        }
        dfs(1);
        if(s.size()==n) {
        	System.out.println("YES");
        	//pw.println("YES");
        }else if(s.size()!=n) {
        	System.out.println("NO");
        	//pw.println("NO");
        }
        for(int i=0;i<n-1;i++) {
        	Arrays.fill(v, false);
        	closed[c[i]]=true;
        	s.clear();
        	dfs(c[n-1]);
        	if(s.size()==n-i-1) {
        		System.out.println("YES");
        	}else {
        		System.out.println("NO");
        	}
        }
	}
	static void dfs(int cur) {
		if(v[cur]==true||closed[cur]==true) {
			return;
		}
		s.add(cur);
		v[cur]=true;
		for(int i=0;i<aa.get(cur).size();i++) {
			dfs(aa.get(cur).get(i));
		}
	}
}
