import java.io.*;
import java.util.*;
public class BerryPicking {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("berries.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int ans=0;
		for(int i=1;i<=a[n-1];i++) {
			int baskets=0;
			for(int j=0;j<n;j++) {
				baskets+=a[j]/i;
			}
			if(baskets<(k/2)) {//not enough
				continue;
			}
			if(baskets>=k) { //if you can split it
				ans=Math.max(ans, (k/2)*i); //do k/2*i berries
				continue;
			}
			//this only occurs if there are not enough baskets for a[i] berries;
			ArrayList<Integer>aa=new ArrayList<>();
			int bessie=(baskets-k/2)*i; //subtract elsie's baskets then multiply by berries
			for(int j=0;j<n;j++) {
				aa.add(a[j]%i);
			}
			Collections.sort(aa);
			for(int j=0;j<n;j++) { //loop through the baskets
				if(j+baskets>=k) {//once there are too many baskets
					break;
				}
				bessie += aa.get(n-j-1) % i; //mod the berries, get leftovers
			}
			ans=Math.max(bessie, ans);
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
/*
5 4
3 6 8 4 2

2 3 4 6 8

*/
