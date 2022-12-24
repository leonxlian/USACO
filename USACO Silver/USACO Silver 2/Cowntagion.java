import java.io.*;
import java.util.*;
public class Cowntagion {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
        	adj.add(new ArrayList<Integer>());
        }
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		System.out.println(dfs(0, -2));
	}
	static int dfs(int node, int parent) {
		int ans=0;
		
		int cows=adj.get(node).size();
		if(parent==-2) {//if it is parent node
			cows++;
		}
		int k=1;
		int days=0;
		while(k<cows) {//check how many days it needs
			days++;
			k*=2;
		}
		ans+=days;
		for(int next:adj.get(node)) { //loop all adjacent nodes
			if(next!=parent) {
				ans+=dfs(next, node)+1;
			}
		}
		return ans;
	}
}
