import java.io.*;
import java.util.*;
public class BalancedPhoto {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader("bphoto.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bphoto.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    Pair a[]=new Pair[n];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	a[i]=(new Pair(Integer.parseInt(st.nextToken()), i));
	    }
	    Arrays.sort(a);
	    for(int i=0;i<n;i++) {
	    	out.println(a[i].val+" "+a[i].i);
	    }
	    FenwickTree ft=new FenwickTree(n);
	    int ans=0;
	    //go backwards, increment left and right side
	    for(int i=n-1;i>=0;i--) {
	    	long cnt1=ft.prefixRange(0, a[i].i+1);
	    	long cnt2=ft.prefixRange(a[i].i, n);
	    	ft.update(a[i].i, 1);
	    	if(cnt1*2<cnt2||cnt2*2<cnt1) {
	    		ans++;
	    	}
	    }
	    out.println(ans);
	    pw.println(ans);
	    pw.close();
	    //out.close();
	}
	static class Pair implements Comparable<Pair>{
		int val; int i;
		public Pair(int val, int i) {
			this.val=val;this.i=i;
		}
		public int compareTo(Pair o) {
			return Integer.compare(this.val, o.val);
		}
	}
	static class FenwickTree{
		int arr[];
		public FenwickTree(int size) {
			arr=new int[size+1];
		}
		public void update(int index, int amt) {
			index++;
			while(index<arr.length) {
				arr[index]+=amt;
				index+=(index&-index);
			}
		}
		public void build(int a[]) {
			for(int i=0;i<a.length;i++) {
				update(i, a[i]);
			}
		}
		public void fastBuild(int a[]) {
			for(int i=1;i<=a.length;i++) {
				arr[i]+=a[i-1];
				int index=i+(i&-i);//next index that it contributes to
				if(index<=a.length) {
					arr[index]+=arr[i];
				}
			}
		}
		public long prefixSum(int index){
			long res=0;
			index+=1;
			while(index!=0) {
				res+=arr[index];
				index-=(index&-index);
			}
			return res;
		}
		//0 to n-1/  (n)   (y+1-x)
		public long prefixRange(int index1, int index2) {
			index1--;
			index2--;
			return prefixSum(index2)-prefixSum(index1);
		}
	}
}
