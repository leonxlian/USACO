import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("helpcross.out")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int[] chicken=new int[c];
        for(int i=0;i<c;i++) {
        	st=new StringTokenizer(br.readLine());
        	chicken[i]=Integer.parseInt(st.nextToken());
        }
        state cows[]=new state[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	cows[i]=new state(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(chicken);
        Arrays.sort(cows);
        boolean taken[]=new boolean[c];
        int ans=0;
        for(int i=0;i<n;i++) {//loop all cow
        	for(int j=0;j<c;j++) {//loop all chicken
        		if(taken[j]) {
        			continue;
        		}
        		if(chicken[j]<cows[i].start) {
        			continue;
        		}
        		if(chicken[j]>cows[i].end) {
        			break;
        		}
        		if(chicken[j]>=cows[i].start&&chicken[j]<=cows[i].end) {
        			taken[j]=true;
        			ans++;
        			break;
        		}
        	}
        }
        for(int i=0;i<n;i++) {
        	System.out.println(cows[i].start+" "+cows[i].end);
        }
        System.out.println(ans);
        //pw.println(ans);
        //pw.close();
	}
	static class state implements Comparable<state>{
		int start, end;
		public state(int start, int end) {
			this.start=start;this.end=end;
		}
		public int compareTo(state o) {//sort by end, if ends are equal sort by start
		if(end==o.end)return start-o.start;//if ends are not equal
		else return end-o.end;
		}
	}
}
