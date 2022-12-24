import java.io.*;
import java.util.*;
public class MountainView {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mountains.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		state a[]=new state[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			a[i]=new state(x-y, x+y);
		}
		Arrays.sort(a);
		int ans=n;
		int max=0;
		for(int i=0;i<n-1;i++){
			if(a[i].right > max){
				max = a[i].right; //new max
			}
			if(a[i].left == a[i+1].left){
				//Since no two points can be equal, one mountain must be covering another if their
				//left point is equal 
				ans--;
			}else if(max >= a[i+1].right){//if the max is greater than the next right, know that left is already within bounds
				ans--;
			}

		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static class state implements Comparable<state>{
		int left;
		int right;
		public state(int left, int right) {
			this.left=left; this.right=right;
		}
		public int compareTo(state o) {
			if(left==o.left)return right-o.right;
			else return left-o.left;
		}
	}
}
