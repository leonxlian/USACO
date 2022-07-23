import java.io.*;
import java.util.*;
public class TheGreatRevegetation {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("revegetate.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("revegetate.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int a[]=new int[m];
		int b[]=new int[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
			if(a[i]>b[i]) {
				int temp=a[i];
				a[i]=b[i];
				b[i]=temp;
			}
		}		
		int ans[]=new int[n+1];
		for(int i=1;i<=n;i++) {//field
			int g;
			for(g=1;g<=4;g++) {//grass
				boolean ok=true;
				for(int j=0;j<m;j++) {//restriction
					if((b[j]==i)&&(ans[a[j]]==g)) {
						ok=false;
						break;
					}
				}
				if(ok) {
					break;
				}
			}
			ans[i]=g;
		}
		for(int i=1;i<=n;i++) {
			//System.out.print(ans[i]);			
			pw.print(ans[i]);
		}
		//System.out.println();
		pw.println();
		pw.close();
	}		
}
/*
5 6
4 1
4 2
4 3
2 5
1 2
1 5

5 6
1 4
2 4
3 4
2 5
1 5
*/

