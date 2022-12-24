import java.io.*;
import java.util.*;
public class CrowdedCows {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("crowded.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crowded.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int g=Integer.parseInt(st.nextToken());
        state[] a=new state[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken());
        	int y=Integer.parseInt(st.nextToken());
        	a[i]=new state(x, y, i);
        }
        Arrays.sort(a);//sort by position then index
        IntTree itree=new IntTree(0, n-1);
        for(int i=0;i<n;i++) {
        	itree.change(i, i, a[i].h); //save the height of each node in tree
        }
        int ret=0;
        int lo=0, hi=0;
        for(int i=0;i<n;i++) {
        	while(lo<n && a[lo].l+g<a[i].l)//find leftmost cow within threshold
        		lo++;
        	while(hi<n && a[hi].l<=a[i].l+g)
        		hi++;
        	hi--;
        	int left=(lo<=i-1)?itree.query(lo, i-1):0;
        	int right=(hi>=i+1)?itree.query(i+1, hi):0;
        	if(left >= 2*a[i].h && right >= 2*a[i].h)
        		ret++;
        }
        //System.out.println(ret);     
        pw.println(ret);
        pw.close();
	}
	static class state implements Comparable<state>{
		int l, h, i;
		public state(int l, int h, int i) {
			this.l=l; this.h=h; this.i=i;
		}
		public int compareTo(state o) {
			if(l != o.l) return l-o.l;
			return i-o.i;
		}
	}
}
	class IntTree{ //generic interval tree implementation
		public int low, high; //range
		public int delta, value; //aggregate
		public IntTree left, right;
		public IntTree(int low, int high) {
			this.low=low;this.high=high; delta=0; value=0;
			if(low==high) {
				left=null; right=null;
			}else {
				int mid=(low+high)/2;
				left=new IntTree(low, mid); right=new IntTree(mid+1,high);
			}
		}
		public void prop() {//push down delta
			if(left!= null) {left.delta+=delta; right.delta+=delta; delta=0;}
			else { value+=delta; delta=0;}
		}
		public void update(){
			if(left!= null) value=Math.max(left.value+left.delta, right.value+right.delta);
		}
		public void change(int start, int end, int extra) {//store in interval tree by adding extra
			if(high < start || end <low) return;
			prop();
			if(start <= low && high <= end) {
				delta+=extra;
				update();
				return;
			}
			left.change(start, end, extra);
			right.change(start, end, extra);
			update();
		}
		public int query(int start, int end) {
			if(high < start || end < low) return 0;
			if(start <= low && high <= end)
				return value + delta;
			prop();
			int leftSide=left.query(start, end);
			int rightSide=right.query(start, end);
			update();
			return Math.max(leftSide, rightSide);
		}
	}
