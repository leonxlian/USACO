import java.io.*;
import java.util.*;
public class AngryCows {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int cows[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			cows[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(cows);
		int min=0;
		int max=500000000;
		while(min!=max) {
			int mid=(min+max)/2;
			int x=0; // attempts
			int l=0; //lower bound
			while(l<n) {
				x++;
				int cur=l+1;
				while(cur<n && cows[cur]-cows[l] <= 2*mid ) {// check if the area can be covered, 
					cur++; //increase until it cannot
				}
				l=cur;//set lower bound to current, to do the next part
			}
			if(x<=k) {
				max=mid;
			}else {
				min=mid+1;
			}
		}
		System.out.println(min);
		//pw.println(min);
		//pw.close();
	}
}
