import java.io.*;
import java.util.*;
public class CircularBarn {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		int b[]=new int[n];
		int moves1=0;
		for(int j=0;j<n;j++) {
			int moves=0;
			int c=1;
			for(int i=1;i<n;i++) {
				int count=a[i]*c;
				moves+=count;
				c++;
			}
			for(int i=0;i<n;i++) {//shift
				if(i<n-1) {
					b[i]=a[i+1];
				} else if(i==(n-1)) {
					b[n-1]=a[0];
				}
			}
			for(int q=0;q<n;q++) {//convert into a array
				a[q]=b[q];
			}
			if(j==0) {
				moves1=moves;
			}else{
			moves1=Math.min(moves, moves1);			
			}
		}
			//System.out.println(moves1);
			pw.println(moves1);
			pw.close();
	}
}


