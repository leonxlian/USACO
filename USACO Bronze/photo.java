import java.io.*;
import java.util.*;
public class photo {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("photo.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int []a=new int[1000];
		int []b=new int[1000];
		int count=0;
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
			if(a[i]>b[i]) {
				int temp=a[i];
				a[i]=b[i];
				b[i]=temp;
			}			
		}
		int l=1;
		int r=0;
		do {
			r=n;
			for(int i=0;i<k;i++) {
				if(l<a[i]&&r>=b[i])
					r=b[i]-1;
				count++;
				l=r+1;
			}
		}while(l<=n);
		pw.println(count);
		pw.close();
		//System.out.println(count);
	}
}
