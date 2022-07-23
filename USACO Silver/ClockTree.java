import java.io.*;
import java.util.*;
public class ClockTree {
	static ArrayList<ArrayList<Integer>> connections = new ArrayList<ArrayList<Integer>>();
	static int colors[];
	static HashSet<String> Diff=new HashSet<>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("clocktree.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("clocktree.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int[] clock=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			connections.add(new ArrayList<Integer>());
		}
		for(int i=0;i<n;i++) {
			clock[i]=Integer.parseInt(st.nextToken());
		}
		colors=new int[n];
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken())-1;
			int b=Integer.parseInt(st.nextToken())-1;
			Diff.add(a+" "+b);
			Diff.add(b+" "+a);
			connections.get(a).add(b);
			connections.get(b).add(a);
		}
		for(int i=0;i<n;i++) {
			if(colors[i]!=0) {
				continue;
			}
			ArrayDeque<Integer> q=new ArrayDeque<>();
			q.add(i);
			colors[i]=1;
			while(!q.isEmpty()) {
				int cur=q.poll();
				for(int next:connections.get(cur)) {
					if(colors[next]==0) {
						if(Diff.contains(cur+" "+next)) {
							colors[next]=3-colors[cur];
						}
					}
				}
			}
		}
		int color1=0;
		int c1count=0;
		int c2count=0;
		int color2=0;
		for(int i=0;i<n;i++) {
			if(colors[i]==1) {
				color1+=clock[i];
				c1count++;
			}else {
				color2+=clock[i];
				c2count++;
			}
		}
		color1%=12;
		color2%=12;
		if(color1==0) {
			color1+=12;
		}
		if(color2==0) {
			color2+=12;
		}
		if(color1-color2==1) {
			System.out.println(c1count);
			pw.println(c1count);
		}else if(color2-color1==1) {
			System.out.println(c2count);
			pw.println(c2count);
		}else if(color2==color1) {
			System.out.println(c1count+c2count);
			pw.println(c1count+c2count);
		}else{
			System.out.println(0);
			pw.println(0);
		}
		pw.close();
		
	}
}
