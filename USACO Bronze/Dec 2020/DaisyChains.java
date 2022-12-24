import java.io.*;
import java.util.*;
public class DaisyChains {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {			
			a[i]=Integer.parseInt(st.nextToken());
		}
		int count=0;
		for(int i=0;i<n;i++) {	//loop through all i values
			for(int j=0;j<n;j++) {//loop through all j values
				double sum=0;
				double numbers=0;
				if(j>i) {				
					if(j-i==0) {
						numbers=1;
					}else {
						for(int c=i;c<=j;c++) {
							sum+=a[c];
						}
					numbers=j-i+1;
					}				
					double average=sum/numbers;			
					for(int c=i;c<=j;c++) {
						if(a[c]==average) {
							count++;
							break;
						}
					}
				}
			}
		}
		System.out.println(count+=n);
	}
}
