import java.io.*;
import java.util.*;
public class CowSignal{
	public static void main(String[] args) throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader("cowsignal.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		String a[]=new String[m];
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=st.nextToken();		
		}	
		for(int i=0;i<m;i++) {	
			String str="";
			for(int j=0;j<n;j++) {
				char b=a[i].charAt(j);				
				for(int q=0;q<k;q++) {
					str=str+b;
				}
			}
			for(int j=0;j<k;j++) {
				System.out.println(str);
				//pw.println(str);
			}
		}	
		//pw.close();
	}
}
