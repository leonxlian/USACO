import java.io.*;
import java.util.*;
public class ClosingTheFarm {
	static ArrayList<ArrayList<Integer>> connections = new ArrayList<ArrayList<Integer>>();
	static boolean[] v;
	static boolean[] closed;
	static HashSet<Integer>s=new HashSet<>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("closing.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		v=new boolean[n+1];
		closed=new boolean[n+1];
		for(int i=0;i<n+1;i++) {
			connections.add(new ArrayList<Integer>());
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			connections.get(a).add(b);
			connections.get(b).add(a);
		}
		int[] c=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			c[i]=Integer.parseInt(st.nextToken());
		}
		dfs(1);
		if(s.size()==n){
			//System.out.println("YES");
			pw.println("YES");
		}else {
			//System.out.println("NO");
			pw.println("NO");
		}
		for(int i=0;i<n-1;i++) {
			Arrays.fill(v, false);
			s.clear();
			closed[c[i]]=true;
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
	public static void dfs(int cur) {
		if(v[cur]==true||closed[cur]==true) {
			return;
		}
		v[cur]=true;
		s.add(cur);
		for(int i=0;i<connections.get(cur).size();i++) {
			dfs(connections.get(cur).get(i));
		}
	}
}
