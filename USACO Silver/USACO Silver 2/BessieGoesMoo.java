import java.io.*;
import java.util.*;

public class BessieGoesMoo {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("bgm.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("bgm.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long a[][]=new long[256][7];//0-255
		int n=Integer.parseInt(st.nextToken());
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			char x=st.nextToken().charAt(0);
			int y=Integer.parseInt(st.nextToken());
			a[x][(y%7+7)%7]++; //can be negative make it positive
		}
		long ans=0;
		for(int B=0;B<7;B++) {
			for(int E=0;E<7;E++) {
				for(int S=0;S<7;S++) {
					for(int I=0;I<7;I++) {
						for(int G=0;G<7;G++) {
							for(int O=0;O<7;O++) {
								for(int M=0;M<7;M++) {
									if((B+E+S+S+I+E)*(G+O+E+S)*(M+O+O)%7==0) {
										ans+=a['B'][B]*a['E'][E]*a['S'][S]*a['I'][I]*a['G'][G]*a['O'][O]*a['M'][M];
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
