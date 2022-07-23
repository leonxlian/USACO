import java.io.*;
import java.util.*;
public class Triangles {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int x[]=new int[n];
		int y[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
		}
		double area=Double.MIN_VALUE;
		double curr=0;
		for(int i=0;i<n;i++) {//loop through all first values
			int x1=x[i];
			int y1=y[i];
			for(int j=0;j<n;j++) {//loop through all second values
				int x2=x[j];
				int y2=y[j];
				for(int q=0;q<n;q++) {//loop through all the third values
					int x3=x[q];
					int y3=y[q];
					if(x3-x2==0||x3-x1==0||x2-x1==0) {
						if(y3-y2==0||y3-y1==0||y2-y1==0) {
					curr=x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2);
					curr=Math.abs(curr);
					area=Math.max(curr, area);
					curr=0;
						}
					}
				}
			}
		}
		int ans=(int)area;
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
