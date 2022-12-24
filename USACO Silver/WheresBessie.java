import java.io.*;
import java.util.*;
public class WheresBessie {
	static int n;
	static boolean[][]v;
	static ArrayList<state>pcls;
	static int[][]a;
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("where.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("where.out")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        a=new int[n][n];
        v=new boolean[n][n];
        pcls=new ArrayList<state>();
        for(int i=0;i<n;i++) {
        	String str=br.readLine();
        	char [] arr=str.toCharArray();
        	for(int j=0;j<n;j++) {
        		a[i][j]=(char)(arr[j]-'A');
        	}
        }
        int ret=0;
        for(int i1=0;i1<n;i1++) { //check if it is pcl
        	for(int i2=0;i2<n;i2++) {
        		for(int i3=0;i3<n;i3++) {
        			for(int i4=0;i4<n;i4++) {
        	        	if(is_pcl(i1, i2, i3, i4)) {
        	        		pcls.add(new state(i1, i2, i3, i4));
        	        	}
        	        }
                }
            }
        }
        for(int i=0;i<pcls.size();i++) {
        	if(pcl_roll(i))
        		ret++;
        }
        //System.out.println(ret);
        //pw.println(ret);
        //pw.close();
	}
	static boolean check_pcl(state x, state y) { //compare 2 pcls, see if one contains another
		return x.i1>=y.i1 && x.i2<=y.i2 && x.j1>=y.j1 && x.j2<=y.j2;
	}
	static boolean pcl_roll(int x) {
		for(int i=0;i<pcls.size();i++) {
			if(i!=x && check_pcl(pcls.get(x), pcls.get(i))){
				return false;
			}
		}
		return true;
	}
	static void floodfill(int i, int j, int c, int i1, int j1, int i2, int j2) {
		v[i][j]=true;
		if(i>i1 &&a[i-1][j]==c &&!v[i-1][j]) floodfill(i-1,j,c,i1,j1,i2,j2);
		if(i<i2 &&a[i+1][j]==c &&!v[i+1][j]) floodfill(i+1,j,c,i1,j1,i2,j2);
		if(j>j1 &&a[i][j-1]==c &&!v[i][j-1]) floodfill(i,j-1,c,i1,j1,i2,j2);
		if(j<j2 &&a[i][j+1]==c &&!v[i][j+1]) floodfill(i,j+1,c,i1,j1,i2,j2);
	}
	static boolean is_pcl(int i1, int j1, int i2, int j2) {
		int colors=0;
		int[]cnt=new int[26];
		for(int i=i1;i<=i2;i++) {
			for(int j=j1;j<=j2;j++) {
				v[i][j]=false;
			}
		}
		for(int i=i1;i<=i2;i++) {
			for(int j=j1;j<=j2;j++) {
				if(!v[i][j]) { //if not visited
					int c=a[i][j];
					if(cnt[c]==0) {
						colors++;
					}
					cnt[c]++;
					floodfill(i,j,c,i1,j1,i2,j2);
				}
			}
		}
		if(colors!=2) {
			return false;
		}
		boolean bOne=false, bTwo=false;
		for(int i=0;i<26;i++) {
			if(cnt[i]==1)bOne=true;
			if(cnt[i]>1)bTwo=true;
		}
		return bOne && bTwo;
	}
	static class state{
		int i1, j1, i2, j2;
		public state(int i1, int j1, int i2, int j2) {
			this.i1=i1; this.j1=j1; this.i2=i2; this.j2=j2;
		}
	}
}
