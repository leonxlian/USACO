import java.io.*;
import java.util.*;
public class BovineGenomics {
	static int s[][];
	static int p[][];
	static int n;	
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		s=new int[n][m];
		p=new int[n][m];
		for(int i=0;i<n;i++) {
			char arr[]=br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(arr[j]=='A')s[i][j]=0;
				if(arr[j]=='C')s[i][j]=1;
				if(arr[j]=='G')s[i][j]=2;
				if(arr[j]=='T')s[i][j]=3;
			}
		}
		for(int i=0;i<n;i++) {
			char arr[]=br.readLine().toCharArray();
			for(int j=0;j<m;j++) {
				if(arr[j]=='A')p[i][j]=0;
				if(arr[j]=='C')p[i][j]=1;
				if(arr[j]=='G')p[i][j]=2;
				if(arr[j]=='T')p[i][j]=3;
			}
		}
		int ans=0;
		for(int i=0;i<m;i++) {
			for(int j=i+1;j<m;j++) {
				for(int k=j+1;k<m;k++) {
					if(check(i,j,k)) {
						ans++;
					}
				}
			}
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
	static boolean check(int ii, int jj, int kk) {
		boolean a[]=new boolean[64];
		boolean ok=true;
		for(int i=0;i<n;i++) {
			int code=s[i][ii]*16+s[i][jj]*4+s[i][kk];
			a[code]=true;
		}
		for(int i=0;i<n;i++) {
			int code=p[i][ii]*16+p[i][jj]*4+p[i][kk];
			if(a[code]==true) {
				ok=false;
			}
		}
		return ok;
	}
}
