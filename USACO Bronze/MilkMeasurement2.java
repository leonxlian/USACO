import java.io.*;
import java.util.*;
public class MilkMeasurement2 {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		String b[]=new String[n];
		int c[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=st.nextToken();
			c[i]=Integer.parseInt(st.nextToken());
		}
		int bc=7;//bessie count
		int ec=7;//elsie count
		int mc=7;//mildred count
		boolean bf=true;
		boolean ef=true;
		boolean mf=true;
		int ans=0;
		for(int i=1;i<100;i++) {//day
			for(int j=0;j<n;j++) {
				if(a[j]==i) {
					if(b[j].equals("Bessie")) { 
						bc+=c[j];
					}
					if(b[j].equals("Elsie")) {
						ec+=c[j];
					}
					if(b[j].equals("Mildred")) {
						mc+=c[j];		
					}
				}
					int max=Math.max(mc, Math.max(ec, bc));
					boolean bf1=(bc==max);//final result 
					boolean ef1=(ec==max);//final result
					boolean mf1=(mc==max);//final result
					if(bf !=bf1 || ef != ef1 || mf != mf1) {
						ans++;
						bf=bf1; 
						ef=ef1; 
						mf=mf1;
					}
			}
		}
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
}
