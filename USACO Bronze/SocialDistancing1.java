import java.io.*;
import java.util.*;
public class SocialDistancing1 {
	public static void main(String[] args)throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader("socdist1.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("socdist1.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String s=st.nextToken();
		int mingapans=0;
		int k=99999999;
		int mingap=0;
		boolean j=true;
		for(int i=0;i<n;i++) {
			char a=s.charAt(i);
			if(a=='0') {
				mingap++;
				j=false;
			}else if(a=='1') {
				if(j==true) {
				}else{
					mingapans=Math.min(mingap, k);
					k=mingapans;
					mingap=0;					
				}
			}
		}
		int top1=0;
		int top2=0;
		int k1=0;
		int curr=0;
		j=true;
		for(int i=0;i<n;i++) {
			char c=s.charAt(i);
			if(c=='0') {
				curr++;
				j=false;
			}else if(c=='1') {
				if(j==true) {					
				}else {
					top2=top1;
					top1=Math.max(curr, k1);
					k1=top1;
					curr=0;
				}
			}
		}
		int ans=0;
		int top1distance=top1+1;
		int top2distance=top2+1;
		int mindistance=mingap+1;
		if(top2distance>=3*top1distance) {
			ans=Math.min(top2distance/3, mindistance);
		}else if(top1distance>=3*top2distance){
			ans=Math.min(top1distance, mindistance);
		}else {
			ans=Math.min(mindistance, Math.min(top1distance/2, top2distance/2));
		}
		System.out.println(top2distance);
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
}
