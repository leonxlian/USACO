import java.io.*;
import java.util.*;
public class Convention1 {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int c=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int high=a[a.length-1];
		int low=0;
		int last=-1;
		while(low<=high) {
			int mid=(high+low)/2;
			if(mid==last) {
				break;
			}
			boolean ok=sim(a,mid,m,c);
			if(ok) {
				high=mid;
			}else {
				low=mid;
			}
			last=mid;
		}
		if(sim(a,high,m,c)) {
			System.out.println(high);
			//pw.println(high);
		}else {
			System.out.println(low);
			//pw.println(low);
		}
		//pw.close();
	}
	public static boolean sim(int[] arr, int time, int m, int c) {
		int curlow=arr[0];
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]-curlow>time||count==c) {
				curlow=arr[i];
				m--;
				count=0;
			}
			count++;
		}
		m--;
		if(m<0) {
			return false;
		}
		return true;
	}
}
