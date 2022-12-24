import java.io.*;
import java.util.*;
public class Steeple {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowjump.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowjump.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		Point[]p=new Point[n*2];
		Segment[]s=new Segment[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			p[i*2]=new Point(x1,y1,i);
			p[i*2+1]=new Point(x2,y2,i);
			s[i]=new Segment(p[i*2],p[i*2+1],i);
		}
		Arrays.sort(p);
		TreeSet<ActiveSegment> active=new TreeSet<ActiveSegment>();
		HashMap<Integer,ActiveSegment> activeIndex=new HashMap<Integer,ActiveSegment>();
		int ans1=0, ans2=0;
		for(int i=0;i<n*2;i++) {
			ans1=p[i].segindex;
			if(activeIndex.containsKey(ans1)) {
				ActiveSegment startSeg=activeIndex.get(ans1);
				active.remove(startSeg);
				ActiveSegment before=active.floor(startSeg);
				ActiveSegment after=active.ceiling(startSeg);
				if(before!=null&&after!=null&&Segment.isIntersect(s[before.index],s[after.index])) {
					ans1=before.index;
					ans2=after.index;
					break;
				}
				activeIndex.remove(ans1);
			}else {
				ActiveSegment startSeg=new ActiveSegment(p[i].y,ans1);
				activeIndex.put(ans1, startSeg);
				
				ActiveSegment after=active.ceiling(startSeg);
				if(after!=null&&Segment.isIntersect(s[after.index], s[ans1])) {
					ans2=after.index;
					break;
				}
				
				ActiveSegment before=active.floor(startSeg);
				if(before!=null&&Segment.isIntersect(s[before.index],s[ans1])) {
					ans2=before.index;
					break;
				}
				active.add(startSeg);
			}
		}//swap
		if(ans1>ans2) {
			int temp=ans1;
			ans1=ans2;
			ans2=temp;
		}
		int ans2_count=0;
		for(int i=0;i<n;i++) {
			if(s[i].index!=ans2&&Segment.isIntersect(s[i], s[ans2])) {
				ans2_count++;
			}
		}
		//System.out.println(ans2_count>1?ans2+1:ans1+1);
		pw.println(ans2_count>1?ans2+1:ans1+1);
		pw.close();
	}
	static class Point implements Comparable<Point>{
		public long x,y;
		public int segindex;
		public Point(long x, long y, int segindex) {
			this.x=x; this.y=y; this.segindex=segindex;
		}
		public int compareTo(Point e) {
			return x==e.x ?(int)(y-e.y):(int)(x-e.x);
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
		static int product(Point p1, Point p2) {
			return sign(p1.x*p2.y-p1.y*p2.x);
		}
		static Point sub(Point p1, Point p2) {
			return new Point(p1.x-p2.x, p1.y-p2.y,p1.segindex);
		}
		static int sign(long x) {
			if(x==0) {
				return 0;
			}else {
				return x<0? -1:1;
			}
		}
		static boolean isIntersect(Segment s1, Segment s2) {
			Point p1=s1.p, q1=s1.q, p2=s2.p, q2=s2.q;
			return (product(sub(q2, p1),sub(q1, p1))*product(sub(q1,p1),sub(p2, p1))>=0)&&
				(product(sub(q1, p2),sub(q2, p2))*product(sub(q2,p2),sub(p1, p2))>=0);
		}
	}
}
