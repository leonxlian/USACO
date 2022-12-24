import java.io.*;
import java.util.*;
public class TheGreatRevegetation {
	static ArrayList<ArrayList<Integer>> connections = new ArrayList<ArrayList<Integer>>();
	static int colors[];
	static HashSet<String> Same, Diff;
	static boolean possible=true;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		colors=new int[n];
		for(int i=0;i<n;i++) {
			connections.add(new ArrayList<Integer>());
		}
		Same=new HashSet<>();
		Diff=new HashSet<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			if(s.equals("S")) {
				Same.add(x+" "+y);
				Same.add(y+" "+x);
			}else {
				Diff.add(x+" "+y);
				Diff.add(y+" "+x);
			}
			connections.get(x).add(y);
			connections.get(y).add(x);
		}
		int count=0;
		for(int i=0;i<n;i++) {
			if(colors[i]!=0) {
				continue;
			}
			colors[i]=1;
			count++;
			dfs(i, 1);
		}
		String ans="1";
		for(int i=0;i<count;i++) {
			ans+=0;
		}
		if(possible) {
			//System.out.println(ans);
			pw.println(ans);
		}else {
			//System.out.println(0);
			pw.println(0);
		}
		pw.close();
	}
	public static void dfs(int cur, int color) {
		for(int i:connections.get(cur)) {
			if(Same.contains(cur+" "+i)&&colors[i]==(3-colors[cur])) {
				possible=false;
			}else if(Diff.contains(cur+" "+i)&&colors[i]==colors[cur]){
				possible=false;
			}
			if(colors[i]==0) {
				if(Same.contains(cur+" "+i)) {
					colors[i]=color;
					dfs(i, color);
				}else {
					colors[i]=3-color;
					dfs(i, 3-color);
				}
			}
		}
	}
}
