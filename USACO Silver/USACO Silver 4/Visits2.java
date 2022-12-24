import java.io.*;
import java.util.*;
public class Visits2{
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	static boolean vis[];
	static int min;
	static int val[];
	static long sum;
	static boolean onstack[];
	static int cnt=0;
	static long ans=0;
	static int par[];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		al=new ArrayList<>();
		for(int i=0;i<n;i++) {
			al.add(new ArrayList<Integer>());
		}
		val=new int[n];
		par=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			al.get(i).add(a);
			par[a]=i;
			val[i]=Integer.parseInt(st.nextToken());
			ans+=val[i];
		}
		onstack=new boolean[n];
		vis=new boolean[n];
		for(int i=0;i<n;i++) {
			if(!vis[i]) {
				//min=Integer.MAX_VALUE;
				dfs(i);
				//ans-=min;
			}
		}
		out.println(ans);
		//out.println(cnt);
		out.close();
	}
	static void dfs(int cur) {
		vis[cur]=true;
		onstack[cur]=true;
		//min=Math.min(min, val[cur]);
		int next=al.get(cur).get(0);
		if(onstack[next]) {
			min=Integer.MAX_VALUE;
		}else if(!vis[next]){
			dfs(next);
		}
		onstack[cur]=false;
	}
}
