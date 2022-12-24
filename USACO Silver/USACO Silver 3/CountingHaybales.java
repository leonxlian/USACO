import java.io.*;
import java.util.*;
public class CountingHaybales {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("haybales.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int q=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		for(int i=0;i<q;i++) {
			st=new StringTokenizer(br.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			System.out.println((search(end, a)-search(start-1, a)));
			//pw.println((search(end, a)-search(start-1, a)));
		}
		//pw.close();
	}
	public static int search(int num, int[] arr) {
		if(arr[0]>num) {
			return 0;
		}
		int low=0;
		int high=arr.length-1;
		while(low<high) {
			int mid=(low+high+1)/2;
			if(arr[mid]<=num) {
				low=mid;
			}else {
				high=mid-1;
			}
		}
		return low+1;
	}
}
