import java.io.*;
import java.util.*;
public class SleepyCowSorting{
	//public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("sleepy.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("sleepy.out")));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken())-1;
		}
		FenwickTree ft=new FenwickTree(n);
		int k=n-1;
		while(a[k]>a[k-1]&&k>0) {
			ft.update(a[k], 1);
			k--;
		}
		//out.println(k);
		pw.println(k);
		if(k>=1) {
			ft.update(a[k], 1);
		}
		/*for(int i=0;i<=n;i++) {
			out.print(ft.arr[i]+" ");
		}*/
		for(int i=0;i<k;i++) {
			//out.print(ft.prefixSum(a[i])+k-i-1);
			pw.print(ft.prefixSum(a[i])+k-i-1);
			if(i<k-1) {
				//out.print(" ");
				pw.print(" ");
			}
			ft.update(a[i], 1);
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