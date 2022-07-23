import java.io.*;
import java.util.*;
public class Moocast {
	static boolean isReachable[][];
	static int n;
	static ArrayList<Integer> v;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		int[] x=new int[n];
		int[] y=new int[n];
		int[] p=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		isReachable=new boolean[n][n];
		v=new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int distance=(y[j]-y[i])*(y[j]-y[i])+(x[j]-x[i])*(x[j]-x[i]);
				if(distance<=p[i]*p[i]) {
					isReachable[i][j]=true;
				}
			}
		}
		int max=0;
		for(int i=0;i<n;i++) {
			v.clear();
			dfs(i);
			max=Math.max(max, v.size());
		}
		//System.out.println(max);
		pw.println(max);
		pw.close();
	}
	public static void dfs(int cur) {
		v.add(cur);
		for(int i=0;i<n;i++) {
			if(isReachable[cur][i]&&!v.contains(i)) {
				dfs(i);
			}
		}
	}
}
