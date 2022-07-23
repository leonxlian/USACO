import java.io.*;
import java.util.*;
public class TheLostCow {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int distance=0;
		int n=0;
		int m=1;
		boolean j=true;
		int previous=x;
		while(j==true) {
			int current=x;
			if(n%2==0) {
				current+=m;
			} else if(n%2==1) {
				current-=m;
			}
			distance+=Math.abs(current-previous);
			previous=current;			
			if(x<y) {
				if(current>=y) {//true
					distance=distance-Math.abs(current-y);
					j=false;
				} else if(current<y){//false
					j=true;
				}
			}else if(x>y) {
				if(current<=y) {//true
					distance=distance-Math.abs(current-y);
					j=false;
				} else if(current>y){ //false
					j=true;
				}
			}
			m*=2;
			n++;
		}
		//System.out.println(distance);
		pw.println(distance);
		pw.close();
	}
}
