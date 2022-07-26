import java.io.*;
import java.util.*;
public class IWouldWalk500Miles{
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("walk.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("walk.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		long d[]=new long[n+1];
		for(int i=1;i<=n;i++) {
			d[i]=2019201997;
		}
		boolean visited[]=new boolean[n+1];
		for(int i=0;i<n;i++) {
			int min=0;//index of the smallest
			for(int j=1;j<=n;j++) {
				if(!visited[j]&&(min==0||d[j]<d[min])) {
					min=j;
				}
			}
			visited[min]=true;
			for(int j=1;j<=n;j++) {
				if(!visited[j]) {
					d[j]=Math.min(d[j], ((long)2019201913*Math.min(min, j)+(long)2019201949*Math.max(min,j))%(long)(2019201997));
				}
			}
		}
		Arrays.sort(d);
		/*for(long i:d) {
			out.println(i);
		}*/
		//out.println(d[n+1-k]);
		//out.close();
		pw.println(d[n+1-k]);
		pw.close();
	}
}
