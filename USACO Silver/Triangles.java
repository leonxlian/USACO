import java.io.*;
import java.util.*;
public class Triangles {
	public static PrintWriter out;
	static int[][] allPoints;
    static ArrayList<ArrayList<Point>> pointsOnLine;
    static long[][] perPointSum;
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int N = Integer.parseInt(st.nextToken());
        allPoints = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            allPoints[i][0] = Integer.parseInt(st.nextToken());
            allPoints[i][1] = Integer.parseInt(st.nextToken());
        }

        pointsOnLine = new ArrayList<>(20001);
        perPointSum = new long[N][2];

        for (int i = 0; i < 20001; i++) {
            pointsOnLine.add(new ArrayList<>());//initialize arraylist
        }
        //group all points with the same x coordinate
        for (int i = 0; i < N; i++) {
            pointsOnLine.get(allPoints[i][0] + 10000).add(new Point(allPoints[i][1], i));
        }
        check(1);
        for(int i = 0; i < 20001; i++) {
            pointsOnLine.set(i, new ArrayList<>());
        }
        //group all points with the same y coordinate
        for (int i = 0; i < N; i++) {
            pointsOnLine.get(allPoints[i][1] + 10000).add(new Point(allPoints[i][0], i));
        }
        check(0);
        long MOD = 1000000007L;
        long ans = 0L;
        for(long[] temp : perPointSum) {
            ans = (ans + (temp[0] * temp[1]) % MOD) % MOD;
        }
        
        //pw.println(ans);
        //pw.close();
    }
	public static void check(int sumIndex) {
        for(int i = 0; i < 20001; i++) {
            if(pointsOnLine.get(i).size() > 0) {
                int size = pointsOnLine.get(i).size();
                Collections.sort(pointsOnLine.get(i));
                long sum = 0;
                for(int j = 0; j < size; j++) {
                    sum += pointsOnLine.get(i).get(j).xOrY - pointsOnLine.get(i).get(0).xOrY;
                }
                for(int j = 0; j < size; j++) {
                    if(j > 0) {
                        sum += (2 * j - size) * (pointsOnLine.get(i).get(j).xOrY - pointsOnLine.get(i).get(j-1).xOrY);
                    }
                    perPointSum[pointsOnLine.get(i).get(j).index][sumIndex] = sum;
                }
            }
        }
    }
    static class Point implements Comparable<Point> {
        public int xOrY;
        public int index;

        public Point(int xOrY, int index) {
            this.xOrY = xOrY;
            this.index = index;
        }

        @Override
        public int compareTo(Point o) {
            return this.xOrY - o.xOrY;
        }
    }
}