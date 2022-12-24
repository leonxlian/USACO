import java.io.*;
import java.util.*;
public class FieldReduction{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int x[]=new int[n];
		int y[]=new int[n];
		int xs[]=new int[n];
		int ys[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
			xs[i]=x[i]; ys[i]=y[i];
		}
		Arrays.sort(xs);
		Arrays.sort(ys);
		int area=Integer.MAX_VALUE;
		for(int i=0;i<4;i++) { //loop smallest x
			for(int j=n-4;j<n;j++) { //largest x
				for(int k=0;k<4;k++) { //loop smallest y
					for(int l=n-4;l<n;l++) {//largest y
						int area1=Integer.MAX_VALUE;
						int count=0;
						for(int m=0;m<n;m++) {//loop points to check in area
							if(inarea(xs[i], ys[k], xs[j], ys[l], x[m], y[m])) {
								area1=Math.min(area1, (ys[l]-ys[k])*(xs[j]-xs[i]));
							}else {
								count++;
							}
							if(count>3) {
								area1=Integer.MAX_VALUE;
								break;
							}
						}
						area=Math.min(area, area1);
					}
				}
			}
		}
		//System.out.println(area);
		pw.println(area);
		pw.close();
	}
	public static boolean inarea(int x1, int y1, int x2, int y2, int pointx, int pointy) {
		if(pointx>=x1&&pointx<=x2&&pointy>=y1&&pointy<=y2) {
			return true;
		}
		return false;
	}
}
