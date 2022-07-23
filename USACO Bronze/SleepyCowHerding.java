import java.io.*;
import java.util.*;
public class SleepyCowHerding {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("herding.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a[]=new int[3];
		for(int i=0;i<3;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		int ans=a[2]-a[1];
		int ans1=a[1]-a[0];
		int count=0;
		int count1=Math.max(ans, ans1);	
		count1-=1;
		if(ans==2||ans1==2) {
			count=1;
		}else if(ans!=2&&ans1!=2) {
			count=2;
		}
		if(ans==1&&ans1==1) {
			count=0;
			count1=0;
		}		
		//System.out.println(count);
		//System.out.println(count1);
		pw.println(count);
		pw.println(count1);
		pw.close();
	}
}
/*5 6 10
  2
  3*/
/*8 20 21
  2
 11*/
/*4 100 200
  2
  99*/