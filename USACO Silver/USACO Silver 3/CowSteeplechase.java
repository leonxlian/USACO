import java.io.*;
import java.util.*;
public class CowSteeplechase {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        //PrintWriter out=new PrintWriter(System.out);
        int n=Integer.parseInt(st.nextToken());
        Point p[]=new Point[n*2];
        Segment s[]=new Segment[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x1=Integer.parseInt(st.nextToken());
        	int y1=Integer.parseInt(st.nextToken());
        	int x2=Integer.parseInt(st.nextToken());
        	int y2=Integer.parseInt(st.nextToken());
        	p[i*2]=new Point(x1, y1, i);
        	p[i*2+1]=new Point(x2, y2, i);
        	s[i]=new Segment(p[i*2], p[i*2+1], i);
        }
        Arrays.sort(p);
        TreeSet<ActiveSegment>active=new TreeSet<>();
        HashMap<Integer, ActiveSegment> activeIndex=new HashMap<>();//for a y, connect to index
        int ans1=0;
        int ans2=0; //segment id
        for(int i=0;i<n*2;i++) {
        	ans1=p[i].segindex;
        	if(activeIndex.containsKey(ans1)) {
        		ActiveSegment startSeg=activeIndex.get(ans1);
        		active.remove(startSeg);
        		ActiveSegment before=active.floor(startSeg);//find lower y
        		ActiveSegment after=active.ceiling(startSeg);//find higher y
        		if(before!=null&&after!=null&&Segment.isIntersect(s[before.index], s[after.index])) {//if intersection is found
        			ans1=before.index;
        			ans2=after.index;
        			break;
        		}
        		activeIndex.remove(ans1);
        	}else {//add new active segment
        		ActiveSegment startSeg=new ActiveSegment(p[i].y, ans1);//get y value + id;
        		activeIndex.put(ans1, startSeg);
        		ActiveSegment after=active.ceiling(startSeg);//find higher y
        		if(after!=null&&Segment.isIntersect(s[after.index], s[ans1])) {
        			ans2=after.index;
        			break;
        		}
        		ActiveSegment before=active.floor(startSeg);
        		if(before!=null&&Segment.isIntersect(s[before.index], s[ans1])) {
        			ans2=before.index;
        			break;
        		}
        		active.add(startSeg);
        	}
        }
		if(ans1>ans2) {//ans2 needs to be larger
			int temp=ans1;
			ans1=ans2;
			ans2=temp;
		}
		int ans2_count=0;
		for(int i=0;i<n;i++) {
			if(s[i].index!=ans2&&Segment.isIntersect(s[ans2], s[i])) {//check if we will need to print out 1 or 2
				ans2_count++;
			}
		}
		if(ans2_count>1) {
			//out.println(ans2+1);
			pw.println(ans2+1);
		}else {
			//out.println(ans1+1);
			pw.println(ans1+1);
		}
		//out.close();
		pw.close();
	}
	static class Point implements Comparable<Point>{
		public long x,y;
		public int segindex;
		public Point(long x, long y, int segindex) {
			this.x=x;this.y=y;this.segindex=segindex;
		}
		public int compareTo(Point e) {
			if(x==e.x) {
				return (int) (y-e.y);
			}else {
				return (int) (x-e.x);
			}
		}
	}
	static class ActiveSegment implements Comparable<ActiveSegment>{
		public long y;
		public int index;
		public ActiveSegment(long y, int index) {
			this.y=y; this.index=index;
		}
		public int compareTo(ActiveSegment e) {
			return (int)(y-e.y);
		}
	}
	static class Segment{
		public Point p, q;
		public int index;
		public Segment(Point p, Point q, int index) {
			this.p=p; this.q=q; this.index=index;
		}
		public static int product(Point p1, Point p2) {
			return sign(p1.x*p2.y-p1.y*p2.x);
		}
		public static int sign(long x) {
			if(x>0) {
				return 1;
			}else if(x<0) {
				return -1;
			}else {
				return 0;
			}
		}
		static Point sub(Point p1, Point p2) {
			return new Point(p1.x-p2.x, p1.y-p2.y,p1.segindex);
		}
		static boolean isIntersect(Segment s1, Segment s2) {
			Point p1=s1.p, q1=s1.q, p2=s2.p, q2=s2.q;
			return (product(sub(q2, p1),sub(q1, p1))*product(sub(q1,p1),sub(p2, p1))>=0)&&
				(product(sub(q1, p2),sub(q2, p2))*product(sub(q2,p2),sub(p1, p2))>=0);
		}
	}
}
