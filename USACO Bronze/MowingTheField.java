import java.io.*;
import java.util.*;
public class MowingTheField {
	public static void main(String[] args) throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader("cowqueue.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		String a[]=new String[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=st.nextToken();
			b[i]=Integer.parseInt(st.nextToken());
		}
		int sum=0;
		for(int i=0;i<n;i++) {
			sum+=b[i];
		}
		char x1[]=new char[sum];
		char y1[]=new char[sum];
		int x=0;
		int y=0;
		int index=0;
		int ans=0;
		int ans1=0;
		for(int i=0;i<n;i++) {
			if(a[i]=="N") {
				for(int j=0;j<b[i];j++) {
					y++;
					for(int q=0;q<sum;q++) {
						if(x==x1[q]&&y==y1[q]) {
							
						}
					}
					index++;					
				}
			}else if(a[i]=="E") {
				for(int j=0;j<b[i];j++) {
					x++;
					index++;
				}
			}else if(a[i]=="S") {
				for(int j=0;j<b[i];j++) {
					y--;
					index++;
				}
			}else if(a[i]=="W") {
				for(int j=0;j<b[i];j++) {
					x--;
					index++;
				}
			}
		}	
	}
}
