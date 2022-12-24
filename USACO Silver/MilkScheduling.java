import java.io.*;
import java.util.*;
public class MilkScheduling {
	static int a[]; //input
	static int b[]; //minimum time for the cow
	static ArrayList<Integer>[]d; //tracks dependency
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("msched.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("msched.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		a=new int[n];
		b=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=-1;
		}
		d=new ArrayList[n];
		for(int i=0;i<n;i++) {
			d[i]=new ArrayList<Integer>();
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			d[y].add(x); //x is depending on y
		}
		int ret=0;
		for(int i=0;i<n;i++) {
			ret=Math.max(ret, getmin(i));
		}
		//System.out.println(ret);
		pw.println(ret);
		pw.close();
	}
	static int getmin(int i) {
		if(b[i]==-1) {
			int t=0;
			for(int j=0;j<d[i].size();j++) {//loop all dependency
				t=Math.max(t, getmin(d[i].get(j))); //depend on cow to finish first
			}
				b[i]=t+a[i];//for cow i its own time plus the dependency time
		}
		return b[i];
	}
}
