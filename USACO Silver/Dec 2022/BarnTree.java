import java.io.*;
import java.util.*;
public class BarnTree {
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	static long bales[];
	static ArrayList<Triple>collection;
	static int size[];
	static long sum;
	static ArrayList<Triple>add;
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		long a[]=new long[n];
		al=new ArrayList<>();
		sum=0;
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
			sum+=a[i];
			al.add(new ArrayList<Integer>());
		}
		al.add(new ArrayList<Integer>());
		sum/=n;
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			al.get(x).add(y);
			al.get(y).add(x);
		}
		size=new int[n];
		bales=new long[n];
		Arrays.fill(size, 1);
		for(int i=0;i<n;i++) {
			bales[i]=a[i];
		}
		dfs(0, -1);
		//for(int i=0;i<n;i++) {
			//out.println(bales[i]);
		//}
		collection=new ArrayList<Triple>();
		add=new ArrayList<Triple>();
		//for(int i=0;i<n;i++) {
			//out.println(size[i]);
		//}
		dfs2(0, -1);
		out.println(collection.size()+add.size());
		for(int i=collection.size()-1;i>=0;i--) {
			Triple t=collection.get(i);
			out.println((t.x+1)+" "+(t.y+1)+" "+t.z);
		}
		for(Triple t:add) {
			out.println((t.x+1)+" "+(t.y+1)+" "+t.z);
		}
		out.close();
	}
	static void dfs(int cur, int par) {
		for(int next:al.get(cur)) {
			if(next!=par) {
				dfs(next, cur);
				bales[cur]+=bales[next];
				size[cur]+=size[next];
			}
		}
	}
	static void dfs2(int cur, int par) {
		for(int next:al.get(cur)) {
			if(next!=par) {
				if(sum*size[next]>bales[next]) {
					add.add(new Triple(cur, next, (long)sum*size[next]-bales[next]));
				}else if(sum*size[next]<bales[next]) {
					collection.add(new Triple(next, cur, bales[next]-(long)sum*size[next]));
				}
				dfs2(next, cur);
			}
		}
	}
	static class Triple{
		int x, y;
		long z;
		public Triple(int x, int y, long z) {
			this.x=x;this.y=y;this.z=z;
		}
	}
}
