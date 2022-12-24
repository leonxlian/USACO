import java.io.*;
import java.util.*;

public class FencePlanning2 {
	static ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
	static int[][] cows;
	static boolean[] used, usedComponent;
	static int minX, maxX, minY, maxY;
	public static void main(String[] args) throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("fenceplan.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fenceplan.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		cows = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			edges.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			cows[i][0] = Integer.parseInt(st.nextToken());
			cows[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			edges.get(a).add(b);
			edges.get(b).add(a);
		}
		
		int smallestPerimeter = Integer.MAX_VALUE;
		used = new boolean[n];
		usedComponent = new boolean[n];
				
		for(int i = 0; i < n; i++) {
			if (!usedComponent[i]) {
				Arrays.fill(used, false);
				minX = Integer.MAX_VALUE;
				minY = Integer.MAX_VALUE;
				maxX = 0;
				maxY = 0;
				DFS(i);
				int p = 2 * ((maxX - minX) + (maxY - minY));
				smallestPerimeter = Math.min(smallestPerimeter, p);
			}
		}
		
		System.out.println(smallestPerimeter);
		//pw.println(smallestPerimeter);
		//pw.close();
	}
	static void DFS(int cur) {
		used[cur] = true;
		usedComponent[cur] = true;
		minX = Math.min(minX, cows[cur][0]);
		minY = Math.min(minY, cows[cur][1]);
		maxX = Math.max(maxX, cows[cur][0]);
		maxY = Math.max(maxY, cows[cur][1]);
		for(int k: edges.get(cur)) {
			if (!used[k]) {
				DFS(k);
			}
		}
	}

}
