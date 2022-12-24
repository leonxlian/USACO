import java.io.*;
import java.util.*;
public class ClosestCowWins{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int k=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		Haybale a[]=new Haybale[k];
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			a[i]=new Haybale(x, y);
		}
		Arrays.sort(a);
		TreeSet<Integer>ts=new TreeSet<>();
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			ts.add(Integer.parseInt(st.nextToken()));
		}
		int shortestDist[]=new int[k];
		for(int i=0;i<k;i++) {
			int closestDist=Integer.MAX_VALUE;
			Integer left=ts.floor(a[i].x);
			Integer right=ts.ceiling(a[i].x);
			if(left!=null) {
				closestDist=Math.min(closestDist, a[i].x-left);
			}
			if(right!=null) {
				closestDist=Math.min(closestDist, right-a[i].x);
			}
			shortestDist[i]=closestDist;
		}
		ArrayList<ArrayList<Haybale>>al=new ArrayList<>();
		ArrayList<ArrayList<Haybale>> connectedPatches = new ArrayList<>();
		int curLeft = 0;
		connectedPatches.add(new ArrayList<>());
        int curSize = 1;//keep track of size
        for(int i=0;i<k;i++) {//loop through patches //can it be connected, check the closest cow for each bounds 
        	boolean isConnected = (a[i].x-a[curLeft].x) < (shortestDist[i]+shortestDist[curLeft]);
        	if(!isConnected) {//check current and to the left, if not connected make the current left index to the current index
                curLeft = i;
                connectedPatches.add(new ArrayList<>());
                curSize++;
            }
            connectedPatches.get(curSize-1).add(a[i]);
        }
        long[] tastinesses = new long[connectedPatches.size()];
        for(int i = 0; i < connectedPatches.size(); i++) {//loop through all the connections between two points
            for(int j = 0; j < connectedPatches.get(i).size(); j++) {
                tastinesses[i] += connectedPatches.get(i).get(j).taste; //add the tastiness groups with the connections
            }
        }
        Arrays.sort(tastinesses);//sort tasty

        long ans = 0;
        for(int i = connectedPatches.size()-1; i >= connectedPatches.size()-n; i--) {//add tastiness 
            ans += tastinesses[i];
        }
        System.out.println(ans);
		//out.println(ans);
		//out.close();
	}
	static class Haybale implements Comparable<Haybale> {
		int x, taste;
		public Haybale(int x, int taste) {
			this.x=x;this.taste=taste;
		}
		public int compareTo(Haybale h) {
			return Integer.compare(x, h.x);
		}
	}
}
