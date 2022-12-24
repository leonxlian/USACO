import java.io.*;
import java.util.*;
public class ConvolutedIntervals {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int freqa[]=new int[m+1];
		int freqb[]=new int[m+1];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			freqa[x]++;
			freqb[y]++;
		}
		int freqSum[]=new int[2*m+2];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=m;j++) {
				freqSum[i+j]+=freqa[i]*freqa[j];
				freqSum[i+j+1]-=freqb[i]*freqb[j];
			}
		}
		for(int i=0;i<=2*m;i++) {
			System.out.println(freqSum[i]);
		}
	}
}
