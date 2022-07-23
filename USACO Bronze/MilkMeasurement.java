import java.io.*;
import java.util.*;
public class MilkMeasurement {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());		
		int[] a = new int[n]; String[] c = new String[n]; int[] b = new int[n];
		for(int i = 0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			c[i] = st.nextToken();
			b[i] = Integer.parseInt(st.nextToken());
		}
		int bc=7, ec=7, mc=7;
		boolean bf=true,ef=true,mf=true;
		int answer=0;
		for(int day=1;day<100;day++) {
			for(int i=0;i<n;i++)
				if(a[i]==day) {
					if(c[i].equals("Bessie")) bc+=b[i];
					if(c[i].equals("Elsie")) ec+=b[i];
					if(c[i].equals("Mildred")) mc+=b[i];					
				}
			int max=Math.max(bc,  Math.max(mc, ec));
			boolean bf1=(bc==max); boolean ef1=(ec==max); boolean mf1=(mc==max);
			if(bf !=bf1 || ef != ef1 || mf != mf1)
				answer++;
			bf=bf1; ef=ef1; mf=mf1;
		}
		//System.out.println(answer);
		pw.println(answer);
		pw.close();
	}
}
