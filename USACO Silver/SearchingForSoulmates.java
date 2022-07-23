import java.io.*;
import java.util.*;
public class SearchingForSoulmates {
	static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int t=Integer.parseInt(st.nextToken());
		while(t-->0) {
			st=new StringTokenizer(br.readLine());
			Long a=Long.parseLong(st.nextToken());
			Long b=Long.parseLong(st.nextToken());
			long count=0;
			while(a!=b) {
				if(a>b) {
					if(a%2==0) {
						a/=2;
						count++;
					}else {
						a+=1;
						count++;
					}
				}else {
					if(b%2==1) {
						b-=1;
						count++;
					}else if(b-a<=4){
						count+=b-a;
						a=b;
					}else {
						b/=2;
						count++;
					}
				}
			}
			out.println(count);
		}
		out.close();
	}
}
