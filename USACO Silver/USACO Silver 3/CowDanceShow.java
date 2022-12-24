import java.io.*;
import java.util.*;
public class CowDanceShow {
	static int tMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        tMax=Integer.parseInt(st.nextToken());
        int a[]=new int[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	a[i]=Integer.parseInt(st.nextToken());
        }
        int low=0;
        int high=n;
        while(low<high) {
        	int mid=(low+high)/2;
        	if(check(mid, a)) {
        		high=mid;
        	}else{
        		low=mid+1;
        	}
        }
        System.out.println(low);
        pw.println(low);
        pw.close();
	}
	public static boolean check(int mid, int[] arr) {
		int cur=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			if(pq.size()==mid) {
				cur=pq.poll();
			}
			if(cur+arr[i]>tMax) {
				return false;
			}
			pq.add(cur+arr[i]);
		}
		return true;
	}
}
/*
5 8
4
7
8
6
4*/
