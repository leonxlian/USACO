import java.io.*;
import java.util.*;
public class WDTCCTR3 {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n]; //arrive time
		int b[]=new int[n]; //time it takes
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
		}
		int ftime=0; //finish time
		for(int i=0;i<1000000;i++) {//loop through every possible number
			for(int j=0;j<n;j++) {//loop every line
			if(a[j]==i) {
				if(a[j]>ftime) {//if time doesn't go past
				ftime=a[j]+b[j];
				}else if(a[j]<ftime) {//if the time goes past
				ftime=ftime+b[j];	
				}				
				}
			}
		}
		//System.out.println(ftime);
		pw.println(ftime);
		pw.close();
	}
}
