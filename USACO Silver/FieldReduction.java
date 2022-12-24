import java.io.*;
import java.util.*;

public class FieldReduction {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int x[]=new int[n];
		int y[]=new int[n];
		int xx[]=new int[n];
		int yy[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
			xx[i]=x[i]; yy[i]=y[i]; 
		}
		Arrays.sort(xx); //sort xx, yy
		Arrays.sort(yy);
		
		int area=Integer.MAX_VALUE;
		for(int i=0;i<4;i++) {
			for(int j=n-4;j<n;j++) {
				for(int k=0;k<4;k++) {
					for(int l=n-4;l<n;l++) { //4 nested loop
						int area1=Integer.MAX_VALUE;
						int cnt=0;
						for(int m=0;m<n;m++) {
							if(inarea(xx[i],xx[j],yy[k],yy[l], x[m],y[m])) {
								area1=Math.min(area1, (xx[j]-xx[i])*(yy[l]-yy[k]));
							}else {
								cnt++;
							}
							if(cnt>3) { //only allow 3 points exclusion
								area1=Integer.MAX_VALUE;
								break;
							}
						}
						area=Math.min(area,  area1);
					}
				}
			}
		}
		//System.out.println(area);
		pw.println(area);
		pw.close();	
	}
	static boolean inarea(int x1, int xh, int y1, int yh, int ox, int oy) {
		if(ox>=x1 && ox<=xh && oy>=y1 && oy<=yh) {
			return true;
		}else {
			return false;
		}
	}
}
	