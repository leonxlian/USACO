import java.io.*;
import java.util.*;
public class SnowBoots {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("snowboots.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		int s[]=new int[n];//snow
		int d[]=new int[n];//distance
		for(int i=0;i<b;i++) {
			st=new StringTokenizer(br.readLine());
			s[i]=Integer.parseInt(st.nextToken());
			d[i]=Integer.parseInt(st.nextToken());
		}
		boolean v[][]=new boolean[n][b]; //tile boot
		v[0][0]=true;
		boolean ok=false;
		for(int j=0;j<b;j++) {//loop through boots
			for(int i=0;i<n;i++) {
				if(a[i]>s[j]) { //tile has more snow;
					continue;
				}
				for(int c=0;c<i;c++) {//loop all tiles until current tile
					if(v[c][j]&&c+d[j]>=i) { //check if the tiles before with the current boot are visited
						v[i][j]=true; //check if this one is reachable from the previous ones 
					}
				}
				for(int c=0;c<j;c++) {
					if(v[i][c]) { //if previous boots can visit, then this one can
						v[i][j]=true;
					}
				}
				if(i==n-1&&v[i][j]) { //when the last is visited, print out the number of boots needed to pass
					System.out.println(j);
					pw.println(j);
					ok=true;
					break;
				}
			}
			if(ok) {
				break;
			}
		}
		pw.close();
	}
}
