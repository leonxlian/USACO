import java.io.*;
import java.util.*;
public class BovineShuffle {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		int b[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken())-1;
			b[a[i]]++;
		}
		int ans=n;
		LinkedList<Integer>q=new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			if(b[i]==0) {
				q.add(i);
				ans--;
			}
		}
		while(!q.isEmpty()) {
			int cur=q.poll();
			b[a[cur]]--;
			if(b[a[cur]]==0) {
				ans--;
				q.add(a[cur]);
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
