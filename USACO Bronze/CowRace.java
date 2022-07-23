import java.io.*;
import java.util.*;
public class CowRace {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cowrace.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowrace.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int []bspeed=new int[1000];
		int []espeed=new int[1000];
		int []btime=new int[1000];
		int []etime=new int[1000];
		int []b=new int[1000];
		int []e=new int[1000];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			bspeed[i]=Integer.parseInt(st.nextToken());
			btime[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			espeed[i]=Integer.parseInt(st.nextToken());
			etime[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<n;i++) {
		for(int j=0;j<btime[i];j++) {
			b[i]=bspeed[i];
		}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<etime[i];j++) {
				e[i]=espeed[i];
			}
	}
		int ans=0;
		boolean j;
		for(int i=0;i<1000;i++) {
			if(b[i]>e[i]) {
				if(j=true){
					ans++;
					j=false;
				}
				j=false;
			}else if(b[i]<e[i]) {
				if(j=false) {
					ans++;
					j=true;
				}
				j=true;
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
}
}
