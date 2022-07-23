import java.io.*;
import java.util.*;
public class ShellGame2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("shell.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		int b[]=new int[n];
		int c[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
			c[i]=Integer.parseInt(st.nextToken());
			
		}
		int shells[]=new int[3];
		shells[0]=1;
		shells[1]=2;
		shells[2]=3;
		int count1=0;
		int count2=0;
		int count3=0;
		for(int i=0;i<n;i++) {
				int temp=shells[a[i]-1];
				int temp1=shells[b[i]-1];
				shells[a[i]-1]=temp1;
				shells[b[i]-1]=temp;			
			if(c[i]==1) {
				if(shells[0]==1) {
					count1++;
				}else if(shells[0]==2) {
					count2++;
				}else if(shells[0]==3) {
					count3++;
				}
			}else if(c[i]==2) {
				if(shells[1]==1) {
					count1++;
				}else if(shells[1]==2) {
					count2++;
				}else if(shells[1]==3) {
					count3++;
				}
			}else if(c[i]==3) {
				if(shells[2]==1) {
					count1++;
				}else if(shells[2]==2) {
					count2++;
				}else if(shells[2]==3) {
					count3++;
					}
				}			
		}
		int ans=Math.max(count1, Math.max(count2, count3));
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}

