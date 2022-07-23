import java.io.*;
import java.util.*;
public class LoanRepayment {
	static Long m;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("loan.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("loan.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		Long n=Long.parseLong(st.nextToken());
		Long k=Long.parseLong(st.nextToken());
		m=Long.parseLong(st.nextToken());
		long low=0;
		long high=(long) 1e12;
		while(low<high) {
			long mid=((low+high+1)/2);
			if(check(mid, n, k)) {
				low=mid;
			}else {
				high=mid-1;
			}
		}
		//System.out.println(low);
		pw.println(low);
		pw.close();
	}
	public static boolean check(long mid, long n, long k) {
		long given=0;
		while(given<n&&k>0) {
			long y=(n-given)/mid;
			if(y<m) {//once you reach less than m
				return m*k>=(n-given);
			}
			long days=(n-mid*y-given)/y+1; //what you have now minus the max divide by the factor
			if(days>k) {
				days=k;
			}
			given+=days*y;
			k-=days;
		} 
		return given>=n;
	}
}
