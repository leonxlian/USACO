import java.io.*;
import java.util.*;
public class Moocast {
	static int n;
	static boolean[][] isReachable;
	static ArrayList<Integer>v;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        v=new ArrayList<>();
        int x[]=new int[n];
        int y[]=new int[n];
        int p[]=new int[n];
        isReachable=new boolean[n][n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	x[i]=Integer.parseInt(st.nextToken());
        	y[i]=Integer.parseInt(st.nextToken());
        	p[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		isReachable[i][j]=false;
        	}
        }
        for(int i=0;i<n;i++) {  
        	for(int j=0;j<n;j++) {
        		int squareDist = (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]);
				if(squareDist <= p[i] * p[i]) {
					isReachable[i][j] = true;
				}
        	}
        }
        int ans=0;
        for(int i=0;i<n;i++) {
        	dfs(i);
        	ans=Math.max(ans, v.size());
        	v.clear();
        }
        //System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
	static void dfs(int cur) {	
		v.add(cur);
		for(int i=0;i<n;i++) {
			if(!v.contains(i)&&isReachable[cur][i]) {
				dfs(i);
			}
		}
	}
}
