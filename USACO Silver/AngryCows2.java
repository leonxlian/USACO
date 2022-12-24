import java.io.*;
import java.util.*;
public class AngryCows2 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int low=0;
		int high=a[a.length-1];
		while(low<high) {
			int mid=(low+high)/2;
			int group=0;//number of groups
			int point=0; //starting point of group
			while(point<n) {
				group++;//start group
				int c=point+1; //checks how far it can go
				while(c<n && (a[c]-a[point]<=2*mid)) {
					c++;
				}
				point=c; //c cannot blow haybale anymore update it
			}
			if(group<=k) {
				high=mid;
			}else{
				low=mid+1;
			}
		}
		//System.out.println(low);
		pw.println(low);
		pw.close();
	}
}
