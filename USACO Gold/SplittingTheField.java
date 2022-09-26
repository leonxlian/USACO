import java.io.*;
import java.util.*;
public class SplittingTheField {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
	    //BufferedReader br = new BufferedReader(new FileReader("split.in"));
	    //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("split.out")));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n=Integer.parseInt(st.nextToken());
	    PriorityQueue<Pair>oMiny=new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return Integer.compare(p1.y, p2.y);
			}
	    });
	    PriorityQueue<Pair>oMaxy=new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return -Integer.compare(p1.y, p2.y);
			}
	    });
	    PriorityQueue<Pair>oMaxX=new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return -Integer.compare(p1.x, p2.x);
			}
	    });
	    PriorityQueue<Pair>tMiny=new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return Integer.compare(p1.y, p2.y);
			}
	    });
	    PriorityQueue<Pair>tMaxy=new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return -Integer.compare(p1.y, p2.y);
			}
	    });
	    PriorityQueue<Pair>tminX=new PriorityQueue<>(new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				if(p1.x==p2.x) {
					return Integer.compare(p1.y, p2.y);
				}
				return Integer.compare(p1.x, p2.x);
			}
	    });
	    int maxx=0;
	    int minx=Integer.MAX_VALUE;
	    int maxy=0;
	    int miny=Integer.MAX_VALUE;
	    Pair p[]=new Pair[n];
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken());
	    	int y=Integer.parseInt(st.nextToken());
	    	minx=Math.min(minx, x);
	    	miny=Math.min(miny, y);
	    	maxx=Math.max(maxx, x);
	    	maxy=Math.max(maxy, y);
	    	p[i]=new Pair(x, y);
	    }
	    long ans=Long.MAX_VALUE;
	    long old=(maxy-miny)*(maxx-minx);
	    for(int i=0;i<n;i++) {
	    	tminX.add(p[i]);
	    	tMaxy.add(p[i]);
	    	tMiny.add(p[i]);
	    }
	    while(!tminX.isEmpty()) {
	    	int xdiff1=(maxx-tminX.peek().x);
	    	int ydiff1=(tMaxy.peek().y-tMiny.peek().y);
	    	long area1=(long)(xdiff1*ydiff1);
	    	long area2;
	    	if(oMaxy.size()==0) {
	    		area2=0;
	    	}else {
	    		int xdiff2=(oMaxX.peek().x-minx);
		    	int ydiff2=(oMaxy.peek().y-oMiny.peek().y);
		    	area2=(long)(xdiff2*ydiff2);
	    	}
	    	ans=Math.min(area2+area1, ans);
	    	Pair cur=tminX.poll();
	    	tMaxy.remove(cur);
	    	tMiny.remove(cur);
	    	oMaxy.add(cur);
	    	oMiny.add(cur);
	    	oMaxX.add(cur);
	    }
	    tminX.clear();
    	tMaxy.clear();
    	tMiny.clear();
    	oMiny.clear();
    	oMaxX.clear();
    	oMaxy.clear();
    	for(int i=0;i<n;i++) {
    		Pair pp=new Pair(p[i].y, p[i].x);
	    	tminX.add(pp);
	    	tMaxy.add(pp);
	    	tMiny.add(pp);
	    }
	    while(!tminX.isEmpty()) {
	    	int xdiff1=(maxy-tminX.peek().x);
	    	int ydiff1=(tMaxy.peek().y-tMiny.peek().y);
	    	long area1=(long)(xdiff1*ydiff1);
	    	long area2;
	    	if(oMaxy.size()==0) {
	    		area2=0;
	    	}else {
	    		int xdiff2=(oMaxX.peek().x-miny);
		    	int ydiff2=(oMaxy.peek().y-oMiny.peek().y);
		    	area2=(long)(xdiff2*ydiff2);
	    	}
	    	ans=Math.min(area2+area1, ans);
	    	Pair cur=tminX.poll();
	    	tMaxy.remove(cur);
	    	tMiny.remove(cur);
	    	oMaxy.add(cur);
	    	oMiny.add(cur);
	    	oMaxX.add(cur);
	    }
	    out.println(old-ans);
	    //pw.println(old-ans);
	    //pw.close();
	    out.close();
	}
	static class Pair{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
	}
	/*static class Pair implements Comparable<Pair>{
		int x; int y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
		public int compareTo(Pair o) {
			if(x==o.x) {
				return Integer.compare(this.y, o.y);
			}
			return Integer.compare(this.x, o.x);
		}
	}*/
}
