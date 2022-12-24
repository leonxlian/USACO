import java.io.*;
import java.util.*;
public class CircularBarn {
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		PrintWriter out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int cows[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			cows[i]=Integer.parseInt(st.nextToken());
		}
		int ans=Integer.MAX_VALUE;
		for (int i=0; i<n; i++) {
			int copy[]=new int[n];
			//shift and copy
			for(int j=0;j<n;j++) {
				copy[j]=cows[(i+j)%n];
			}
			// See if this rotation is possible.
			int total = 0;
			boolean flag = true;
			for (int j=n-1; j>=0; j--) {
				total += copy[j];
				if (total > n-j) {
					flag = false;
						break;
				}
			}
			if(!flag) {
				continue;
			}
			int energy=0;
			int last=n-1;
			while (last >= 0 && copy[last] != 0) 
				last--;
			for(int j=last-1; j>=0; j--) {//go backwards
				while (copy[j]>0) {//if it has room to donate
					if (last == -1 || last < j) {
						break;
					}
					copy[j]--;//cow j to last
					copy[last]++;
					energy+=(last-j)*(last-j);
					// Update last.
					while (last >= 0 && copy[last] != 0)
						last--;
				}
			}
			ans=Math.min(ans, energy);
		}
		out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
}
/*1 0 0 2 0 0 1 2 2 2*/
