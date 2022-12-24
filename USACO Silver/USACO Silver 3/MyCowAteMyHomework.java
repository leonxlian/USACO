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
		long sum=0;
		long min=Integer.MAX_VALUE;
		long count=1;
		long remaining=0;
		ArrayList<Integer> ans=new ArrayList<>();
		for(int i=n-1;i>0;i--) {
			sum+=a[i];
			min=Math.min(min, a[i]);
			if(i<=n-2&&count*(sum-min)>remaining*(n-i-1)) {
				ans.clear();
				remaining=sum-min;
				count=n-i-1;
			}
			if(i<=n-2&&count*(sum-min)==remaining*(n-i-1)) {
				ans.add(i);
			}
		}
		Collections.sort(ans);
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
			pw.println(ans.get(i));
		}
		pw.close();
	}
}
