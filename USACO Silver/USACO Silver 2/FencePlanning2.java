import java.io.*;
import java.util.*;
public class FencePlanning2 {
	static int x[];
	static int y[];
	static ArrayList<ArrayList<Integer>> connections = new ArrayList<ArrayList<Integer>>();
	static int maxX, maxY, minY, minX;
	static HashSet<Integer>v;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		x=new int[n];
		y=new int[n];
		v=new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			connections.add(new ArrayList<Integer>());
		}
		for(int i=0;i<n;i++) {
			 st=new StringTokenizer(br.readLine());
			 x[i]=Integer.parseInt(st.nextToken());
			 y[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int c1=Integer.parseInt(st.nextToken())-1;
			int c2=Integer.parseInt(st.nextToken())-1;
			connections.get(c1).add(c2);
			connections.get(c2).add(c1);
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(v.contains(i)) {
				continue;
			}
			maxX=Integer.MIN_VALUE;
			maxY=Integer.MIN_VALUE;
			minX=Integer.MAX_VALUE;
			minY=Integer.MAX_VALUE;
			dfs(i);
			int perimeter=2*((maxX-minX)+(maxY-minY));
			ans=Math.min(perimeter, ans);
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static void dfs(int cur) {
		ArrayDeque<Integer> q=new ArrayDeque<Integer>();
		q.add(cur);
		while(!q.isEmpty()) {
			int next=q.poll();
			for(int i: connections.get(next)) {
				if(!v.contains(i)) {
					q.add(i);
					v.add(i);
				}
				maxX=Math.max(maxX, x[i]);
				maxY=Math.max(maxY, y[i]);
				minY=Math.min(minY, y[i]);
				minX=Math.min(minX, x[i]);
			}
		}
	}
}
