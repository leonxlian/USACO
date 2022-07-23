import java.io.*;
import java.util.*;
public class MilkVisits {
	static ArrayList<ArrayList<Integer>> connections=new ArrayList<ArrayList<Integer>>();
	static int components[];
	static int num=0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milkvisits.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("milkvisits.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String s=st.nextToken();
		char[] ch=s.toCharArray();
		components=new int[n];
		for(int i=0;i<n;i++) {
			connections.add(new ArrayList<Integer>());
		}
		for(int i=0;i<n-1;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			connections.get(x).add(y);
			connections.get(y).add(x);
		}
		String ans="";
		for(int i=0;i<n;i++) {
			if(components[i]!=0) {
				continue;
			}
			num++;
			dfs(i, ch);
		}
		for(int i=0;i<m;i++) {
			boolean b=false;
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			char c=st.nextToken().charAt(0);
			if((components[x]!=components[y])||(ch[x]==ch[y]&&ch[x]==c)) {
				ans+='1';
			}else {
				ans+='0';
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}  
	public static void dfs(int x, char[] ch) {
		if(components[x]!=0) {
			return;
		}
		components[x]=num;
		for(int i:connections.get(x)) {
			if(ch[x]==ch[i]) {
				dfs(i, ch);
			}
		}
	}
}
