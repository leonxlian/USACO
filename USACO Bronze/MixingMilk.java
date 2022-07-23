import java.io.*;
import java.util.*;
public class MixingMilk {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int c1=Integer.parseInt(st.nextToken());
		int m1=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int c2=Integer.parseInt(st.nextToken());
		int m2=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int c3=Integer.parseInt(st.nextToken());
		int m3=Integer.parseInt(st.nextToken());
		for(int i=1;i<=100;i++) {
			if(i%3==1) {
				if(m1+m2<=c2) {
					m2+=m1;
					m1=0;
				} else if(m1+m2>c2){
					int x=m1+m2;
					m2=c2;
					m1=x-m2;
				}
			} else if(i%3==2) {
				if(m2+m3<=c3) {
					m3+=m2;
					m2=0;
				} else if(m2+m3>c3){					
					int x=m2+m3;
					m3=c3;
					m2=x-m3;					
				}
			} else if(i%3==0) {
				if(m3+m1<=c1) {
					m1+=m3;
					m3=0;
				} else if(m3+m1>c1){					
					int x=m3+m1;
					m1=c1;
					m3=x-m1;
				}
			}
		}
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(m3);
		//pw.println(m1);
		//pw.println(m2);
		//pw.println(m3);
		//pw.close();
	}
}
