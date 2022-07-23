import java.io.*;
import java.util.*;
public class DanceMooves {
	static ArrayList<ArrayList<Integer>> connections=new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		PrintWriter out = new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int cow[]=new int[n+1];
		for(int i=0;i<n+1;i++) {
			cow[i]=i;
			connections.add(new ArrayList<Integer>());
			connections.get(i).add(i);
		}
		for(int i=1;i<k+1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=cow[a];
			int d=cow[b];
			cow[a]=d;
			cow[b]=c;
			connections.get(cow[a]).add(a);
			connections.get(cow[b]).add(b);
		}
		int ans[]=new int[n+1];
		for(int i=1;i<n+1;i++) {
			if(cow[i]!=0) {
				ArrayList<Integer>cycle=new ArrayList<Integer>();
				int j=i;
				while(cow[j]!=0) {
					cycle.add(j);
					j=cow[j];
					cow[cycle.get(cycle.size()-1)]=0;
				}
				HashSet<Integer> viewedHere = new HashSet<>();
                for (int cur : cycle) {
                    viewedHere.addAll(connections.get(cur));
                }
                for (int cur : cycle) {
                    ans[cur] = viewedHere.size();
                }
			}
		}
		for(int i=1;i<n+1;i++) {
			out.println(ans[i]);
		}
		out.close();
	}
}
