import java.io.*;
import java.util.*;
public class ClosestCowWins {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		Patch p[]=new Patch[k];
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			p[i]=new Patch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		int[] nhoj=new int[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			nhoj[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nhoj);
		Arrays.sort(p);
		int cur=0;
		int closestNhoj[]=new int[k];
		for(int i=0;i<k;i++) {
			cur=Math.max(cur-1, 0);//starting index
			int closestL=Integer.MAX_VALUE;//closest Left
			while(cur<m&&nhoj[cur]<p[i].index) {//cur<m and current cow position less than the grass index;
				closestL=Math.min(closestL, p[i].index-nhoj[cur]);
				cur++;
			}
			int closestR=0;//closest Right
			if(cur == m) {
                closestR = Integer.MAX_VALUE;
            } else {
                closestR = nhoj[cur] - p[i].index;
            }
			closestNhoj[i]=Math.min(closestL, closestR);
		}
		ArrayList<ArrayList<Patch>> connectedPatches = new ArrayList<>();
		int curLeft = 0;
		connectedPatches.add(new ArrayList<>());
        int curSize = 1;//keep track of size
        for(int i=0;i<k;i++) {//loop through patches //can it be connected, check the closest cow for each bounds 
        	boolean isConnected = (p[i].index-p[curLeft].index) < (closestNhoj[i]+closestNhoj[curLeft]);
        	if(!isConnected) {//check current and to the left, if not connected make the current left index to the current index
                curLeft = i;
                connectedPatches.add(new ArrayList<>());
                curSize++;
            }
            connectedPatches.get(curSize-1).add(p[i]);
        }
        long[] tastinesses = new long[connectedPatches.size()];
        for(int i = 0; i < connectedPatches.size(); i++) {//loop through all the connections between two points
            for(int j = 0; j < connectedPatches.get(i).size(); j++) {
                tastinesses[i] += connectedPatches.get(i).get(j).t; //add the tastiness groups with the connections
            }
        }
        Arrays.sort(tastinesses);//sort tasty

        long ans = 0;
        for(int i = connectedPatches.size()-1; i >= connectedPatches.size()-n; i--) {//add tastiness 
            ans += tastinesses[i];
        }
        System.out.println(ans);
	}
	static class Patch implements Comparable<Patch>{
		int index;
		int t;
		public Patch(int index, int t) {
			this.index=index; this.t=t;
		}
		@Override
		public int compareTo(Patch o) {
			return index-o.index;
		}
	}
}
