import java.io.*;
import java.util.*;
public class IcyPerimeter {
	static char grid[][];
	static int n, k;
	static int b[][]=new int[1002][1002];
	static int area[]=new int[1000*1000];
	static int p[]=new int[1000*1000];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("perimeter.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        grid=new char[1002][1002];
        for(int i=0;i<n+2;i++) {
        	grid[0][i]=grid[n+1][i]='.';
        }
        for(int i=1;i<=n;i++) {
        	grid[i][0]=grid[i][n+1]='.';
        	st=new StringTokenizer(br.readLine());
        	String str=st.nextToken();
        	for(int j=1;j<=n;j++) {
        		grid[i][j]=str.charAt(j-1);
        	}
        }
        for(int i=1;i<=n;i++) {
        	for(int j=1;j<=n;j++) {
        		if(grid[i][j]=='#'&&b[i][j]==0) { //count number
        			k++;
        			floodfill(i, j, k);
        		}
        	}
        }
        for(int i=1;i<=n;i++) {
    		for(int j=1;j<=n;j++) {
    			int x=b[i][j];
    			if(b[i+1][j]==0)p[x]++;
    			if(b[i-1][j]==0)p[x]++;
    			if(b[i][j+1]==0)p[x]++;
    			if(b[i][j-1]==0)p[x]++;
    		}
    	}
        int aa=0;
        int pp=0;
        for(int i=1;i<=k;i++) {
        	if(area[i]>aa||(area[i]==aa&&p[i]<pp)) {
        		aa=area[i];
        		pp=p[i];
        	}
        }
        //System.out.println(aa+" "+pp);
        pw.println(aa+" "+pp);
        pw.close();
	}
    static void floodfill(int ii, int jj, int r) {
    	Stack<point> q=new Stack<>();
    	q.add(new point(ii, jj));
    	while(!q.isEmpty()) {
    		point cur=q.peek();
    		q.pop();
    		int i=cur.x;
    		int j=cur.y;
    		if(grid[i][j]=='.'||b[i][j]!=0) {
    			continue;
    		}
    		b[i][j]=r;
    		area[r]++;
    		q.push(new point(i-1, j));
    		q.push(new point(i+1, j));
    		q.push(new point(i, j+1));
    		q.push(new point(i, j-1));
    	}
    }
	static class point{
		public int x, y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
}
