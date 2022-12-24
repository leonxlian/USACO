import java.io.*;
import java.util.*;
public class BerryPicking {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("berries.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int b[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(b);
		ArrayList<Integer> al=new ArrayList<Integer>();
		int ans=0;
		for(int i=1;i<=b[n-1];i++) {
			int a[]=new int[b[n-1]+1];
			for(int j=0;j<=i;j++) {
				a[j]=0;
			}
			for(int j=0;j<n;j++) {
				a[i]+=b[j]/i;
				a[b[j]%i]++;
			}
			if(k/2>a[i]) {
				continue;
			}
			a[i]-=k/2;
			int given=0;
			int cur=i;
			int total=0;
			while(cur>0&&given<k/2) {
				if(a[cur]>0) {
					given++;
					total+=cur;
					a[cur]--;
				}else {
					cur--;
				}
			}if(given==k/2) {
				ans=Math.max(total, ans);
			}
		}
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
}
