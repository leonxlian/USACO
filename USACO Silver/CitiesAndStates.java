import java.io.*;
import java.util.*;
public class CitiesAndStates {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("citystate.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[][]=new int[676][676];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String city=st.nextToken();
			String state=st.nextToken();
			a[hash(city)][hash(state)]++;
		}
		long ans=0;
		for(int i=0;i<676;i++) {
			for(int j=i+1;j<676;j++) {
				ans+=(long)(a[i][j]*a[j][i]);
			}
		}
		System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
		static int hash(String s) {
			return s.charAt(0)-'A'+(s.charAt(1)-'A')*26;
		}
	}
