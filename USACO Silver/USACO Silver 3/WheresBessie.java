import java.io.*;
import java.util.*;
public class WheresBessie {
	static int n;
	static int a[][];
	static ArrayList<state>pcl;
	static boolean v[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("where.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        a=new int[n][n];
        v=new boolean[n][n];
        pcl=new ArrayList<state>();
        for(int i=0;i<n;i++) {
        	String str=br.readLine();
        	char[] arr=str.toCharArray();
        	for(int j=0;j<n;j++) {
        		a[i][j]=(char)(arr[j]-'A');
        	}
        }
        int ans=0;
        for(int x1=0;x1<n;x1++) {
        	for(int x2=0;x2<n;x2++) {
        		for(int x3=0;x3<n;x3++) {
        			for(int x4=0;x4<n;x4++) {
        				if(isPcl(x1, x2, x3, x4)) {
        					pcl.add(new state(x1, x2, x3, x4));
        				}
        			}
        		}
        	}
        }
        for(int i=0;i<pcl.size();i++) {
        	if(hasNoLarger(i)) {
        		ans++;
        	}
        }
        //System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
	static boolean hasNoLarger(int index) {
		for(int i=0;i<pcl.size();i++) {
			if(i!=index&&contains(pcl.get(index), pcl.get(i))) {
				return false;
			}
		}
		return true;
	}
	static boolean contains(state x, state y) {
		return x.i1>=y.i1&&x.i2<=y.i2&&x.j1>=y.j1&&x.j2<=y.j2;
	}
	static void ff(int x, int y, int c, int i1, int j1, int i2, int j2) {
		v[x][y]=true;
		if(x>i1&&a[x-1][y]==c&&!v[x-1][y]) {
			ff(x-1, y, c, i1, j1, i2, j2);
		}
		if(x<i2&&a[x+1][y]==c&&!v[x+1][y]){
			ff(x+1, y, c, i1, j1, i2, j2);
		}
		if(y>j1&&a[x][y-1]==c&&!v[x][y-1]){
			ff(x, y-1, c, i1, j1, i2, j2);
		}
		if(y<j2&&a[x][y+1]==c&&!v[x][y+1]){
			ff(x, y+1, c, i1, j1, i2, j2);
		}
	}
	static boolean isPcl(int i1, int j1, int i2, int j2) {
		int colors=0;
		int cnt[]=new int[26];
		for(int i=i1;i<=i2;i++) {
			for(int j=j1;j<=j2;j++) {
				v[i][j]=false;
			}
		}
		for(int i=i1;i<=i2;i++) {
			for(int j=j1;j<=j2;j++) {
				if(!v[i][j]) {
					int c=a[i][j];
					if(cnt[c]==0) {
						colors++;
					}
					cnt[c]++; //count groups of each color
					ff(i, j, c, i1, j1, i2, j2);
				}
			}
		}
		if(colors!=2) {
			return false;
		}
		boolean two=false;
		boolean one=false;
		for(int i=0;i<26;i++) {
			if(cnt[i]==1) {
				one=true;
			}
			if(cnt[i]>1) {
				two=true;
			}
		}
		return two&&one;
	}
	static class state{
		int i1, j1, i2, j2;
		public state(int i1, int j1, int i2, int j2) {
			this.i1=i1;this.j1=j1;this.i2=i2;this.j2=j2;
		}
	}
}
