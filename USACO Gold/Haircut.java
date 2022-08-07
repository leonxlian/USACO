/*
 * build seg tree and add 1 backwards from decreasing order
 */
import java.io.*;
import java.util.*;
public class Haircut {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader("haircut.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("haircut.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int a[]=new int[n];
	    st=new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	    	a[i]=Integer.parseInt(st.nextToken());
	    }
	    FenwickTree ft=new FenwickTree(n+1);
	    long inversion[]=new long[n+1];
	    for(int i=0;i<n;i++) {
	    	inversion[a[i]]+=ft.prefixRange(a[i]+1, n+1);
	    	ft.update(a[i], 1);
	    }
	    out.println(0);
	    pw.println(0);
	    long sum=0;
	    for(int i=0;i<n-1;i++) {
	    	sum+=inversion[i];
	    	//out.println(sum);
	    	pw.println(sum);
	    }
	    pw.close();
	    //out.close();
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
		//0 to n-1
		public long prefixRange(int index1, int index2) {
			index1--;
			index2--;
			return prefixSum(index2)-prefixSum(index1);
		}
	}
}
