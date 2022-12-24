import java.io.*;
import java.util.*;
public class SnowBoots {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int[]s=new int[b];
		int[]d=new int[b];
		for(int i=0;i<b;i++) {
			st=new StringTokenizer(br.readLine());
			s[i]=Integer.parseInt(st.nextToken());
			d[i]=Integer.parseInt(st.nextToken());
		}
		boolean[][]v=new boolean[n][b];
		for(int j=0;j<b;j++) {
			for(int i=0;i<n;i++) {
				if(a[i]>s[j])continue;//tile has more snow
				if(i==0&&j==0) {
					v[i][j]=true;
				}
				for(int k=0;k<i;k++) {
					if(v[k][j]&&k+d[j]>=i) {
						v[i][j]=true;
					}
				}
				for(int k=0;k<j;k++) {
					if(v[i][k]) {
						v[i][j]=true;
					}
				}
				if((i==n-1)&&v[i][j]) {
					//System.out.println(j);
					pw.println(j);
					pw.close();
					return;
				}
			}
		}
	}
}
