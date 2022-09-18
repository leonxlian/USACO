import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad3 {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
	    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    int a[][]=new int[n][2];
	    for(int i=0;i<n;i++) {
	    	a[i][0]=a[i][1]=-1;
	    }
	    for(int i=0;i<2*n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken())-1;
	    	if(a[x][0]==-1) {
	    		a[x][0]=i;
	    	}else {
	    		a[x][1]=i;
	    	}
	    }
	    ArrayList<Pair>al=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	al.add(new Pair(a[i][0], a[i][1]));
	    }
	    Collections.sort(al);
	    for(int i=0;i<n;i++) {
	    	out.println(al.get(i).x+" "+al.get(i).y);
	    }
	    FenwickTree ft=new FenwickTree(n<<1);
	    long ans=0;
	    //check overlapping intervals
	    for(int i=0;i<n;i++) {
	    	ans+=ft.prefixRange(al.get(i).x, al.get(i).y+1);
	    	ft.update(al.get(i).y, 1);
	    }
	    out.println(ans);
	    pw.println(ans);
	    pw.close();
	    //out.close();
	}
	static class Pair implements Comparable<Pair>{
		int x; int y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
		public int compareTo(Pair o) {
			if(x==o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
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
		//0 to n-1
		public long prefixRange(int index1, int index2) {
			index1--;
			index2--;
			return prefixSum(index2)-prefixSum(index1);
		}
	}
}
