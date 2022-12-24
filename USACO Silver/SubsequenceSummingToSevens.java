import java.io.*;
import java.util.*;
public class SubsequenceSummingToSevens {
	public static void main(String[] args)throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("div7.in"));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("div7.out")));
			//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] cows = new int[n];
				for (int i=0; i<n; i++) {
					st=new StringTokenizer(br.readLine());
					cows[i] = Integer.parseInt(st.nextToken());
				}
			int[] min = new int[7];
			Arrays.fill(min, n);
			int[] max = new int[7];
			Arrays.fill(max, -1);

			min[0] = 0;
			max[0] = 0;

			int[] mods = new int[n];
			for (int i=1; i<n; i++) {
				mods[i] = (mods[i-1] + cows[i-1])%7;
				min[mods[i]] = Math.min(min[mods[i]], i);
				max[mods[i]] = Math.max(max[mods[i]], i);
			}
			//0+3%7=3
			//min[3]=min(,1);

			// Just look for the biggest gap.
			int res = 0;
			for (int i=0; i<7; i++) {
				res = Math.max(res, max[i]-min[i]);
			}
			//System.out.println(res);
			pw.println(res);
			pw.close();
	}
}
