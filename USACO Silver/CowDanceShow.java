import java.io.*;
import java.util.*;
public class CowDanceShow {
	static int Tmax;
	static int durations[];
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		Tmax=Integer.parseInt(st.nextToken());
		durations=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			durations[i]=Integer.parseInt(st.nextToken());
		}
		int low=1;
		int high=n;
		while(low!=high) {
			int mid=(low+high)/2;
			if(check(mid)) {
				high=mid;
			}else {
				low=mid+1;
			}
		}
		System.out.println(low);
		//pw.println(low);
		//pw.close();
		
	}
	public static boolean check(int n) {
		int current=0;
		PriorityQueue<Integer> q=new PriorityQueue<Integer>();
		for(int i=0;i<durations.length;i++) {
			if(q.size()==n) {
				current=q.poll();
			}
			if(current+durations[i]>Tmax) {
				return false;
			}
			q.add(current+durations[i]);
		}
		return true;
	}
}
