import java.io.*;
import java.util.*;

public class MooParticle {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("moop.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moop.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		State arr[]=new State[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			arr[i]=new State(a, b);
		}
		Arrays.sort(arr);
		/*
		 minimum y-coordinate in the left component is at most the maximum y-coordinate of the right coordinate, combine.
		 if not the case, need a new component
		 */
		int max[]=new int[n];
		int min[]=new int[n];
		int prevmin=Integer.MAX_VALUE;
		min[0]=arr[0].spin2; //go from left side to get min
		max[n-1]=arr[n-1].spin2;//max will represent the highest y of the connected component
		for(int i=1;i<n;i++) {
			min[i]=Math.min(arr[i].spin2, min[i-1]);
		}
		for(int i=n-2;i>=0;i--) {
			max[i]=Math.max(max[i+1], arr[i].spin2); //right side to get max
		}
		int ans=1;
		for(int i=0;i<n-1;i++) {
			if(min[i]>max[i+1]) { //check if we need new component, if the other area's y is smaller
				ans++;				//unable to get rid of the particle, will have one left
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static class State implements Comparable<State>{
		int spin1, spin2;
		public State(int spin1, int spin2) {
			this.spin1=spin1;this.spin2=spin2;
		}
		public int compareTo(State o) {
		if(spin1==o.spin1)return spin2-o.spin2;
		else return spin1-o.spin1;
		}
	}
}
