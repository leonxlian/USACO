import java.io.*;
import java.util.*;

public class CrossCountrySkiing {
	static int[][]a;
	static int[][]b;
	static boolean[][]v;
	static int wx, wy, m, n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ccski.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ccski.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        a=new int[m][n];
        b=new int[m][n];
        v=new boolean[m][n];
        for(int i=0;i<m;i++) {
        	Arrays.fill(a[i], 0);Arrays.fill(b[i],0);Arrays.fill(v[i], false);
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		a[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		b[i][j]=Integer.parseInt(st.nextToken());
        		if(b[i][j]>0) {
        			wy=i;wx=j;
        		}
        	}
        }
        int lo=0, hi=10000000;
        while(lo<hi) {
        	int mid=(lo+hi)/2;
        	if(is_reachable(mid)) {
        	hi=mid;
        	}else {
        	lo=mid+1;
        	}
        }
        //System.out.println(lo);
        pw.println(lo);
        pw.close();
	}
	static boolean is_reachable(int d) {
		for(int i=0;i<m;i++) {
			Arrays.fill(v[i],false);
		}
		bfs(d);
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(b[i][j]>0&&(!v[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
	static void bfs(int d) {//bfs
		int []dy= {-1,0,1,0};
		int []dx= {0,-1,0,1};
		LinkedList<state> q=new LinkedList<state>();
		q.add(new state(wy, wx)); //start from wayport
		v[wy][wx]=true;
		while(q.size()!=0) {
			state cur=q.poll();
			for(int i=0;i<4;i++) {//try neighbor
				int ny=cur.f+dy[i];
				int nx=cur.s+dx[i];
				if(ny>=0 && ny<m && nx>=0 && nx<n) {//check boundaries
					if(!v[ny][nx]&&Math.abs(a[cur.f][cur.s]-a[ny][nx])<=d) {//check if not visited
						q.add(new state(ny,nx));
						v[ny][nx]=true;
					}
				}
			}
		}
	}
	static class state{
		public int f, s;
		public state(int f, int s) {
			this.f=f; this.s=s;
		}
	}
}
