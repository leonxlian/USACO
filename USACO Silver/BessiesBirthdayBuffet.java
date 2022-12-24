import java.io.*;
import java.util.*;

public class BessiesBirthdayBuffet {
	static int n;
	static int e;
	static int[][]a;
	static int[]b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("buffet.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buffet.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        a=new int[n][];
        b=new int[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	b[i]=Integer.parseInt(st.nextToken());
        	int x=Integer.parseInt(st.nextToken());
        	a[i]=new int[x];
        	for(int j=0;j<x;j++) {
        		a[i][j]=Integer.parseInt(st.nextToken())-1;
        	}
        }
        int [][]c=new int[n][]; //cost from one node to the rest
        for(int i=0;i<n;i++) {
        	c[i]=bfs(i);
        }  
        state[] p=new state[n];//choose which node to start
        for(int i=0;i<n;i++) {
        	p[i]=new state(b[i], i); //sorted by energy in ascending order
        }
        Arrays.sort(p);
        int m[]=new int[n];//simulate the move from low quality grass
        m[0]=p[0].v; //m saved the accumulated energy
        int ret=m[0];
        for(int i=1;i<n;i++) {
        	m[i]=p[i].v;
        	for(int j=0;j<i;j++) {
        		if(c[p[j].i][p[i].i]==-1) {// node i and node j not connected
        			continue;
        		}
        		if(m[j]-c[p[j].i][p[i].i]<0) { //not enough energy to walk from i to j
        			continue;
        		}
        		m[i]=Math.max(m[i], m[j]-c[p[j].i][p[i].i]+p[i].v);
        	}
        	ret=Math.max(ret, m[i]);
        }
        //System.out.println(ret);
        pw.println(ret);
        pw.close();
	}
	static int[] bfs(int v){
		int []d=new int[n];
		Arrays.fill(d, -1);
		d[v]=0;
		LinkedList<Integer> q=new LinkedList<Integer>();
		q.offer(v);
		while(q.size()>0) {
			int cur=q.poll();
			int dis=d[cur]; //accumulated distance from v
			for(int i=0;i<a[cur].length;i++) { //loop the neighbor nodes
				int next=a[cur][i];
				if(d[next]==-1) {//not visited
					q.offer(next);
					d[next]=d[cur]+e;
				}
			}
		}
		return d;
	}
	static class state implements Comparable<state>{
		public int v, i;
		public state(int v, int i) {
			this.v=v; this.i=i;
		}
		public int compareTo(state o) {
			return v-o.v;
		}
	}
}
