import java.io.*;
import java.util.*;
public class LeftOut {
	static int n;
	static boolean[][]b;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("leftout.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("leftout.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		b=new boolean[n][n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			for(int j=0;j<n;j++) {
				char ch=s.charAt(j);
				if(ch=='L') {
					b[i][j]=true;
				}else {
					b[i][j]=false;
				}
			}
		}
		for(int i=1;i<n;i++) {
			b[i][0]=b[i][0]^b[0][0];
			for(int j=1;j<n;j++) {
				b[i][j]=b[i][j] ^ b[0][j] ^ b[i][0];
			}
		}
		if(count(1, 1, n-1, n-1, false)==0) {
			//System.out.println("1 1");
			pw.println("1 1");
			pw.close();
			return;
		}
		if(count(1, 1, n-1, n-1, true)==n-1) {
			for(int j=1;j<n;j++) {
				if(count(1, j, n-1, j, true)==n-1){
					//System.out.println("1 "+(j+1));
					pw.println("1 "+(j+1));
					pw.close();
					return;
				}
			}
			for(int i=1;i<n;i++) {
				if(count(i, 1, i, n-1, true)==n-1) {
					//System.out.println(""+(i+1)+" 1");
					pw.println(""+(i+1)+" 1");
					pw.close();
					return;
				}
			}
			//System.out.println(-1);
			pw.println("-1");
			pw.close();
			return;
		}
		if(count(1, 1, n-1, n-1, true)!=1) {
			//System.out.println("-1");
			pw.println("-1");
			pw.close();
			return;
		}
		for(int i=1;i<n;i++) {
			for(int j=1;j<n;j++) {
				if(b[i][j]) {
					System.out.println(""+(i+1)+" "+(j+1));
					pw.println(""+(i+1)+" "+(j+1));
				}
			}
		}
		pw.close();
	}
	public static int count(int i1, int j1, int i2, int j2, boolean ok) {
		int ans=0;
		for(int i=i1;i<=i2;i++) {
			for(int j=j1;j<=j2;j++) {
				if(b[i][j]==ok) {
					ans++;
				}
			}
		}
		return ans;
	}
}
