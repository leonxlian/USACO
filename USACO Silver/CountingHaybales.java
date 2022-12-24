import java.io.*;
import java.util.*;
public class CountingHaybales {
	static int[]haybale;
	public static void main(String[] args)throws IOException{	
		//BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		haybale=new int[n];
		for(int i=0;i<n;i++) {
			haybale[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(haybale);
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int low=Integer.parseInt(st.nextToken());
			int high=Integer.parseInt(st.nextToken());
			System.out.println(bsearch(high)-bsearch(low-1));
		}
		//pw.close();
	}
	static int bsearch(int val) {
		if(haybale[0]>val) {
			return 0;
		}
		int low=0; 
		int high=haybale.length-1;
		while (low!=high) {
			int mid=((low+high+1)/2);
			if(haybale[mid]<=val) {
				low=mid;
			}else{
				high=mid-1;
			}
		}
		return low+1;
	}
}
