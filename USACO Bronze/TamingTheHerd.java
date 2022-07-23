import java.io.*;
import java.util.*;
public class TamingTheHerd {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("taming.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("taming.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int min=0;
		int max=0;	
		boolean ok=true;
		// Reconstruct known values here.
				int[] b = new int[n];
				Arrays.fill(b, -1);
				for (int i=n-1; i>=0; i--) {
					if (a[i] >= 0) {
						for (int j=i,k=a[i]; k>=0; j--,k--) {
							if (b[j] != -1 && b[j] != k)
								ok = false;
							b[j] = k;
						}
					}
				}

				// See if anything is inconsistent.
				for (int i=0; i<n; i++) {
					if (i == 0 && a[i] > 0) ok = false;
					if (a[i] >= 0 && a[i] != b[i])
						ok = false;
				}
				b[0]=0;
		for(int i=0;i<n;i++) {
			if(b[i]==0) {
				min++;
				max++;
			}
			if(b[i]==-1) {
				max++;
			}
		}
		if(ok=false) {
			//System.out.println(-1);
			pw.println(-1);
			pw.close();
			br.close();
		}else if(ok=true) {
		//System.out.println(min+" "+max);
		pw.println(min+" "+max);
		}
		pw.close();
	}
}
