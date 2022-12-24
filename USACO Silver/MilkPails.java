import java.io.*;
import java.util.*;
public class MilkPails {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		boolean a[][]=new boolean[x+1][y+1];
		a[0][0]=true;
		for(int op=0;op<k;op++) {
			boolean b[][]=new boolean[x+1][y+1]; //the operation
			for(int i=0;i<x+1;i++) {
				for(int j=0;j<y+1;j++) {
					if(!a[i][j])continue;
					b[i][j]=true;
					b[0][j]=true; //empty p1
					b[x][j]=true; //fill up p1
					b[i][0]=true; //empty p2
					b[i][y]=true; //fill up p2
					int delta=Math.min(i, y-j); // i is current number in pail 1, j is cur number of pail 2
					b[i-delta][j+delta]=true; //pour left p1 to right p2
					delta=Math.min(x-i, j);
					b[i+delta][j-delta]=true; //pour right p2 to left p1
				}
			}
			a=b;
		}
		int ret=Integer.MAX_VALUE;
		for(int i=0;i<x+1;i++) {
			for(int j=0;j<y+1;j++) {
				if(!a[i][j]) {
					continue;
				}else{
				ret=Math.min(ret, Math.abs(i+j-m));
				}
			}
		}
		//System.out.println(ret);
		pw.println(ret);
		pw.close();
	}
}
