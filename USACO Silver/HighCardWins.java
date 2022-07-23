import java.io.*;
import java.util.*;
public class HighCardWins {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("highcard.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		//PrintWriter out = new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		boolean b[]=new boolean[n*2+1];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			b[Integer.parseInt(st.nextToken())]=true;
		}
		ArrayList<Integer>al=new ArrayList<>();
		ArrayList<Integer>al1=new ArrayList<>();
		for(int i=1;i<=2*n;i++) {
			if(b[i]) {
				al.add(i);
			}else {
				al1.add(i);
			}
		}
		int i=0;
		int j=0;
		int ans=0;
		while(i<n&&j<n) {
			if(al.get(i)>=al1.get(j)) {
				j++;
			}else {
				i++;
				j++;
				ans++;
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
