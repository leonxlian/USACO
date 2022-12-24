import java.io.*;
import java.util.*;
public class CountingHaybales2 {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int haybale[]=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
        	haybale[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(haybale);
        for(int i=0;i<q;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
			System.out.println(bsearch(b, haybale)-bsearch((a-1), haybale));
        }
	}
	static int bsearch(int val,int haybale[]) {
		if(haybale[0]>val) {
			return 0;
		}
		int low=0; 
		int high=haybale.length-1;
		while (low<high) {
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
