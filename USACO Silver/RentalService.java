import java.io.*;
import java.util.*;
public class RentalService {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("rental.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken());
		long a[]=new long[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Long.parseLong(st.nextToken());//cow
		}
		Arrays.sort(a);
		state b[]=new state[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());//store
			int q=Integer.parseInt(st.nextToken());
			int p=Integer.parseInt(st.nextToken());
			b[i]=new state(q, p);
		}
		Arrays.sort(b);
		long c[]=new long[r];
		for(int i=0;i<r;i++) {
			st=new StringTokenizer(br.readLine());
			c[i]=Long.parseLong(st.nextToken());
		}
		Arrays.sort(c);
		for(int i=0;i<r/2;i++) {
			long temp=c[i];
			c[i]=c[r-1-i];
			c[r-1-i]=temp;
		}
		long cur=0;
		for(int i=0;i<n&&i<r;i++) {
			cur+=c[i];
		}
		int j=0;
		if(n>r) {
			long t=0; //for cows cannot rent accumulate gallons of milk
			for(int i=r;i<n;i++) 
				t+=a[i];
			while(t>0&&j<m) {
				if(t>b[j].gallons) {//store can take full amount of milk
					cur+=(long)b[j].gallons*b[j].cost;
					t-=b[j].gallons;
					b[j].gallons=0;
					j++;
				}else{//store can hold partial amount of milk
					cur+=t*b[j].cost;
					b[j].gallons-=(int)t;
					break;
				}
			}
		}
		//check which is better rent or sell
		long ans=cur;
		if(j<m) {
			int last = n>=r?r-1:n-1; //find last cow to be rented
			while(last>=0&&j<m) { //remove last cow to be rented, calculate if i can sell the production to store
				cur-=c[last];
				long t=a[last];//milk produced by this cow
				while(t>0&&j<m) {
					if(t>b[j].gallons) {//if it can store the amount of milk
						cur+=(long)b[j].gallons*b[j].cost;
						t-=b[j].gallons;
						b[j].gallons=0;
						j++;
					}else {//store can hold partial amount of milk
						cur+=t*b[j].cost;
						b[j].gallons-=(int)t;
						break;
					}
				}
				ans=Math.max(ans,cur);
				last--;
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static class state implements Comparable<state>{
		Integer gallons;
		Integer cost; 
		public state(int gallons, int cost) {
			this.gallons=gallons;this.cost=cost;
		}
		public int compareTo(state o) {
			return o.cost-cost;
		}
	}
}
