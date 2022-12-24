import java.io.*;
import java.util.*;
public class TheGreatRevegetation {
	static ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();//same
	static ArrayList<ArrayList<Integer>> bb = new ArrayList<ArrayList<Integer>>();//diff
	static int[]v;
	static boolean f;// is there solution
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        v=new int[n+1];
        for(int i=0;i<n+1;i++) {
        	v[i]=0;
        	aa.add(new ArrayList<Integer>());
        	bb.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	String s=st.nextToken(); 
        	int x=Integer.parseInt(st.nextToken());
        	int y=Integer.parseInt(st.nextToken());
        	if(s.equals("S")) {aa.get(x).add(y); aa.get(y).add(x);}
        	if(s.equals("D")) {bb.get(x).add(y); bb.get(y).add(x);}
        }
        int count=0;
        for(int i=1;i<=n;i++) {
        	if(v[i]==0) {
        		floodfill(i, 1);
        	}
        }
	}
	static void floodfill(int x, int val) {
		v[x]=val;
		for(int i:aa.get(x)) {
			
		}
	}
}
