import java.io.*;
import java.util.*;
public class RobotInstructions {
	static ArrayList<ArrayList<Integer>>a=new ArrayList<>();
	static ArrayList<ArrayList<Integer>>al=new ArrayList<>();
	static ArrayList<ArrayList<Triple>>connections=new ArrayList<>();
	static ArrayList<ArrayList<Triple>>connections1=new ArrayList<>();
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		out=new PrintWriter(System.out);
		Pair arr[]=new Pair[n/2];
		Pair arr1[]=new Pair[n-n/2];
		for(int i=0;i<n;i++) {
			a.add(new ArrayList<Integer>());
			al.add(new ArrayList<Integer>());
			connections.add(new ArrayList<Triple>());
			connections1.add(new ArrayList<Triple>());
		}
		int ans[]=new int[n+1];
		st=new StringTokenizer(br.readLine());
		int endX=Integer.parseInt(st.nextToken());
		int endY=Integer.parseInt(st.nextToken());
		for(int i=0;i<n/2;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr[i]=new Pair(x, y);
		}
		for(int i=0;i<n-n/2;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			arr1[i]=new Pair(x, y);
		}
		for(int i=0;i<n/2;i++) {
			for(int j=i+1;j<n/2;j++) {
				a.get(i).add(j);
			}
		}
		for(int i=n/2;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				al.get(i).add(j);
			}
		}
		for(int i=0;i<n/2;i++) {
			connections.get(i).add(new Triple(arr[i].x, arr[i].y,1));
		}
		for(int i=n/2;i<n;i++) {
			connections1.get(i).add(new Triple(arr1[i-n/2].x, arr1[i-n/2].y,1));
		}
		for(int i=0;i<n/2;i++) {//from each start
			for(int next:a.get(i)) {
				for(Triple cur:connections.get(i)) {
					connections.get(next).add(new Triple(cur.x+arr[next].x, cur.y+arr[next].y, cur.size+1));
				}
			}
		}
		//split 2nd half
		for(int i=n/2;i<n;i++) {//from each start
			for(int next:al.get(i)) {
				for(Triple cur:connections1.get(i)) {
					connections1.get(next).add(new Triple(cur.x+arr1[next-n/2].x, cur.y+arr1[next-n/2].y, cur.size+1));
				}
			}
		}
		
		ArrayList<Triple>lower=new ArrayList<>();
		ArrayList<Triple>upper=new ArrayList<>();
		for(int i=0;i<n/2;i++) {
			for(Triple j:connections.get(i)) {
				lower.add(j);
			}
		}
		out.println();
		for(int i=n/2;i<n;i++) {
			for(Triple j:connections1.get(i)) {
				upper.add(j);
			}
		}
		Collections.sort(lower);
		Collections.sort(upper);
		Collections.reverse(upper);
		for(Triple i: lower) {
			out.println(i.x+" "+i.y+" "+i.size);
		}
		out.println();
		for(Triple i: upper) {
			out.println(i.x+" "+i.y+" "+i.size);
		}
		long[] answer = new long[n + 1];
        long[] amounts = new long[(n / 2) + 1];
        int j = 0;
        int k = 0;
        for (Triple choice : upper) {
            while (j < lower.size() && lower.get(j).compareTo(choice) <= 0) {
                amounts[lower.get(j).size]++;
                j++;
            }
            while (k < lower.size() && lower.get(k).compareTo(choice) < 0) {
                amounts[lower.get(k).size]--;
                k++;
            }
            for (int instructions = 0; instructions <= n / 2; instructions++) {
                answer[instructions + choice.size] += amounts[instructions];
            }
        }
        /*StringBuilder out = new StringBuilder();
        for (int instructionsUsed = 1; instructionsUsed <= n; instructionsUsed++) {
            out.append(answer[instructionsUsed]).append('\n');
        }*/
        //System.out.print(out);
		/*for(int i=1;i<=n;i++) {
			out.println(ans[i]);
		}
		out.close();*/
        out.close();
	}
	static class Pair implements Comparable<Pair>{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
		public int compareTo(Pair o) {
			return x-o.x;
		}
	}
	static class Triple implements Comparable<Triple>{
		public long x, y; 
		public int size;
		public Triple(long x, long y, int size) {
			this.x=x;
			this.y=y;
			this.size=size;
		}
		public int compareTo(Triple other) {
            if (y != other.y) {
                return Long.compare(y, other.y);
            } else {
                return Long.compare(x, other.x);
            }
        }
	}
}
/*
-2 0
1 0
2 0
3 0
4 0
5 0
7 0

5 20
5 10
5 10
5 10
5 0
5 0
5 0
5 -10
0 20
0 10
0 10
0 10
0 0
0 0
0 -10*/