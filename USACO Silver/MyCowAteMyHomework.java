import java.io.*;
import java.util.*;
public class MyCowAteMyHomework {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("homework.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("homework.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		long m=Integer.MAX_VALUE;
		long sum=0,remaining=0,c=1; //sum remaining(sum-min) count
		ArrayList<Integer> ans=new ArrayList<Integer>();
		for(int i=n-1;i>0;i--) {
			sum+=a[i];
			m=Math.min(m, a[i]);
			if(i<=n-2&&(sum-m)*c>remaining*(n-i-1)) {//if found better result
				ans.clear();//clear arraylist
				remaining=sum-m;//sum-min
				c=n-i-1;
			}
			if(i<=n-2&&(sum-m)*c==remaining*(n-i-1)) {//if found better result just add it
				ans.add(i);
			}
		}
		Collections.sort(ans);
		for(long ret:ans) {
			//System.out.println(ret);
			pw.println(ret);
		}
		pw.close();
	}
}
