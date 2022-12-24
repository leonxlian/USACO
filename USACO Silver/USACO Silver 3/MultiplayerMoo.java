import java.io.*;
import java.util.*;
public class MultiplayerMoo {
	static int cur=0;
	static int n;
	static boolean v[][];
	static int a[][];
	static int[] dx={-1, 1, 0, 0};
	static int[] dy={0, 0, -1, 1};
	static HashMap<String, node> nodemap=new HashMap<>();
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PrintWriter out=new PrintWriter(System.out);
        n=Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer>cells=new HashMap<>();
        a=new int[n][n];
        v=new boolean[n][n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<n;j++) {
        		int x=Integer.parseInt(st.nextToken());
        		if(cells.containsKey(x)) {
        			cells.put(x, cells.get(x)+1);
        		}else {
        			cells.put(x, 1);
        		}
        		a[i][j]=x;
        	}
        }
        int single=0;
        ArrayList<node>nodes=new ArrayList<node>();
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(!v[i][j]) {
        			v[i][j]=true;
        			node nd=new node(a[i][j], cur);
        			ff(i, j, a[i][j], nd);
        			single=Math.max(single, cur);
        			nd.a=cur;
        			nodes.add(nd);
        			cur=0;
        		}
        	}
        }
        for(node nd:nodes) {
        	for(String s:nd.cell) {
        		String[] ind=s.split(" ");
        		int x=Integer.valueOf(ind[0]);
        		int y=Integer.valueOf(ind[1]);
        		for(int i=0;i<4;i++) {
        			int nx=x+dx[i];
        			int ny=y+dy[i];
        			if(bounds(nx, ny)&&a[x][y]!=a[nx][ny]) {
        				connect(nd, nodemap.get((nx)+" "+(ny)));
        			}
        		}
        	}
        }
        int team=0;
        Collections.sort(nodes);
        for(int i=0;i<nodes.size();i++) {
        	node x=nodes.get(i);
        	for(node y: x.connect) {
        		if(team>=cells.get(x.i)+cells.get(y.i)) {
        			continue;
        		}
        		int cur1=0;
        		ArrayList<node> q=new ArrayList<>();
        		HashSet<node> v1=new HashSet<>();
        		q.add(x);
        		v1.add(x);
        		while(!q.isEmpty()) {
        			node nd=q.remove(0);
        			cur1+=nd.a;
        			for(node o:nd.connect) {
        				if(!v1.contains(o)&&(o.i==x.i||o.i==y.i)) {
        					v1.add(o);
        					q.add(o);
        				}
        			}
        		}
        		team=Math.max(team, cur1);
        	}
        }
        out.println(single);
        out.println(team);
        out.close();
        //pw.println(single);
        //pw.println(team);
        //pw.close();
	}
	static void ff(int x, int y, int val, node nd) {
		if(a[x][y]==val) {
			v[x][y]=true;
			nd.cell.add(x+" "+y);
			nodemap.put(x+" "+y, nd);
			cur++;
			for(int i=0;i<4;i++) {
				int nextX=dx[i]+x;
				int nextY=dy[i]+y;
				if(bounds(nextX, nextY)&&!v[nextX][nextY]) {
					ff(nextX, nextY, val, nd);
				}
			}
		}
	}
	static boolean bounds(int x, int y) {
		return x>=0&&x<n&&y>=0&&y<n;
	}
	static void connect(node a, node b) {
		a.connect.add(b);
		b.connect.add(a);
	}
	static class node implements Comparable<node>{
		int i, a;
		HashSet<String>cell=new HashSet<String>();
		HashSet<node>connect=new HashSet<node>();
		public node(int i, int a) {
			this.i=i;this.a=a;
		}
		public int compareTo(node o) {
			return o.a-a;
		}
	}
}
