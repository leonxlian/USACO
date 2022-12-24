import java.io.*;
import java.util.*;
public class stuckinarut2 {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		String direction[]=new String[n];
		int x[]=new int[n];
		int y[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			direction[i]=st.nextToken();
			x[i]=Integer.parseInt(st.nextToken());
			y[i]=Integer.parseInt(st.nextToken());
		}
		int filled[][]=new int[10000][10000];
		boolean ok[]=new boolean[n];
		int grass[]=new int[n];
		for(int i=0;i<1000;i++) {//loop through all hours
			for(int j=0;j<n;j++) {
				if(direction[j].equals("N")) {
					y[j]+=1;
				}else if(direction[j].equals("E")) {
					x[j]+=1;
				}
			}
			for(int j=0;j<n;j++){
				if(ok[j]==false) {
					if(j<n-1) {
					if(x[j]==x[j+1]&&y[j]==y[j+1]) {
						grass[j+1]++;
					}
					}
				if(x[j]==10000||y[j]==10000) {
					ok[j]=true;
					grass[j]=-1;
				}else if(filled[x[j]][y[j]]==0) {
					grass[j]++;
					filled[x[j]][y[j]]=1;
				}else if(filled[x[j]][y[j]]==1) {
					ok[j]=true;
				}
				
				}
				
			}
		}
		for(int i=0;i<n;i++) {
			if(grass[i]==-1) {
				System.out.println("Infinity");
			}else {
				System.out.println(grass[i]+=1);
			}
		}
	}
}
