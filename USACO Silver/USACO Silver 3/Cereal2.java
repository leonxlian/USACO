import java.io.*;
import java.util.*;
public class Cereal2 {
	static PrintWriter out;
	static ArrayList<ArrayList<Cow>>connections=new ArrayList<>();
	static int v[];
	static Cow cycleEdge=null;
	static Cow edgeHere[];
	static ArrayList<Integer> ans=new ArrayList<>();
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		for(int i=0;i<=m;i++) {
			connections.add(new ArrayList<>());
		}
		v=new int[m+1];
		edgeHere=new Cow[m+1];
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine());
			int f=Integer.parseInt(st.nextToken());
			int s=Integer.parseInt(st.nextToken());
			connections.get(f).add(new Cow(i, f, s, f));//add each pair, index, first, second, favorite
			connections.get(s).add(new Cow(i, s, f, f));//add each pair, index, second, first favorite
		}
		for(int i=1;i<=m;i++) {
			if(v[i]==0) {
				cycleEdge=null;
				dfs1(i, null);
				if(cycleEdge==null) {
					v[i]=2;
					dfs2(i);
				}else {
					ArrayList<Integer>restOfCycle=new ArrayList<>();
					for(int j=cycleEdge.from;j!=cycleEdge.to;j=edgeHere[j].from) {
						v[j]=2;
						restOfCycle.add(edgeHere[j].id);
					}
					v[cycleEdge.to] = 2;
                    ans.add(cycleEdge.id);
                    if (cycleEdge.fav == cycleEdge.to) {
                        Collections.reverse(restOfCycle);
                    }
                    ans.addAll(restOfCycle);
                    for (int j = cycleEdge.from; j != cycleEdge.to; j = edgeHere[j].from) {
                        dfs2(j);
                    }
                    dfs2(cycleEdge.to);
				}
			}
		}
		HashSet<Integer> hs = new HashSet<>(ans);
        for (int j = 1; j <= n; j++) {
            if (!hs.contains(j)) {
                ans.add(j);
            }
        }
        System.out.println(n - hs.size());
        for (int i : ans) {
            out.println("" + i);
        }
        out.close();
	}
	static void dfs1(int a, Cow edge) {//connected components, edge is only null if it's starting node
		if(v[a]==1) {//if visited
			if(cycleEdge==null) {//if already visited, can make the edge not null
				cycleEdge=edge;
			}
		}else {
			v[a]=1;
			edgeHere[a]=edge;
			for(Cow next:connections.get(a)) {
				if(edge==null||edge.id!=next.id) {//if current edge is null, starting node||current id is not the same as next id
					dfs1(next.to, next);
				}
			}
		}
	}
	static void dfs2(int a) {
		for(Cow next:connections.get(a)) {
			if (v[next.to] == 1) {//if already visited
                v[next.to] = 2;
                ans.add(next.id);
                dfs2(next.to);
            }
		}
	}
	static class Cow{
		public int id, from, to, fav;
		public Cow(int id, int from, int to, int fav) {
			this.id=id;this.from=from;this.to=to;this.fav=fav;
		}
	}
}
