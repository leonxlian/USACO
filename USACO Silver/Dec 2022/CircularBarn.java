import java.io.*;
import java.util.*;
public class CircularBarn {
	public static PrintWriter out;
	static TreeSet<Integer>one=new TreeSet<>();
	static TreeSet<Integer>three=new TreeSet<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int t=Integer.parseInt(st.nextToken());
		for(int i=3;i<2000000;i+=2) {
			if(isPrime(i)) {
				if(i%4==1) {
					one.add(i);
				}else if(i%4==3){
					three.add(i);
				}
			}
		}
		outer: while(t-->0) {
			st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			int a[]=new int[n];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				a[i]=Integer.parseInt(st.nextToken());
			}
			ArrayList<Triple>al=new ArrayList<>();
			for(int i=0;i<n;i++) {
				if(a[i]==1||a[i]==2||a[i]==3||(one.contains(a[i])||three.contains(a[i]))) {
					out.println("Farmer John");
					continue outer;
				}else if(a[i]%4==0) {//4 rounds
					al.add(new Triple("Farmer Nhoj", a[i]/4, i));
				}else if(a[i]%4==2) {//4 rounds
					al.add(new Triple("Farmer John", a[i]/4, i));
				}else if(a[i]%4==3) {
					al.add(new Triple("Farmer John", (a[i]-three.lower(a[i]))/4, i));
				}else if(a[i]%4==1) {
					al.add(new Triple("Farmer John", (a[i]-one.lower(a[i]))/4, i));
				}
			}
			Collections.sort(al);
			out.println(al.get(0).s);
		}
		out.close();
	}
	static boolean isPrime(int n) {
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	static class Triple implements Comparable<Triple>{
		String s;
		int x, y;
		public Triple(String s, int x, int y) {
			this.s=s;this.x=x;this.y=y;
		}
		public int compareTo(Triple t) {
			if(x==t.x) {
				return Integer.compare(y, t.y);
			}else {
				return Integer.compare(x, t.x);
			}
		}
	}
}
