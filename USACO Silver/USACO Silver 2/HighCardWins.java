import java.io.*;
import java.util.*;
public class HighCardWins {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		boolean e[]=new boolean[n*2+1];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			e[x]=true;
		}
		ArrayList<Integer> ee=new ArrayList<Integer>();
		ArrayList<Integer> bb=new ArrayList<Integer>();
		for(int i=1;i<=n*2;i++) {
			if(e[i]) {
				ee.add(i);
			}else {
				bb.add(i);
			}
		}
		int ans=0;
		int bi=0;
		int ei=0;
		while(bi<n && ei<n) {
			if(bb.get(bi)>ee.get(ei)) {
				bi++;
				ei++;
				ans++;
			}else {
				bi++;
			}
		}
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
}
