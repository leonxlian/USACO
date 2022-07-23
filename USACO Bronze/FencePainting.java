import java.io.*;
import java.util.*;
public class FencePainting {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("paint.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        int max=0;
        int min=0;
        int paint=0;
        if(c>a) {
        int temp=a;
        int temp1=c;
        a=temp1;
        c=temp;
        int temp2=b;
        int temp3=d;
        b=temp3;
        d=temp2;
        }
        if(d>a) {
        	max=Math.max(a, Math.max(b, Math.max(c, d)));
        	min=Math.min(a, Math.min(b, Math.min(c, d)));
        	paint=max-min;
        }else if(d<a) {
        	paint=d-c+b-a;
        }else if(d==a||c==b) {
        	max=Math.max(a, Math.max(b, Math.max(c, d)));
        	min=Math.min(a, Math.min(b, Math.min(c, d)));
        	paint=max-min;
        }
        System.out.println(paint);
        //pw.println(paint);
        //pw.close();
	}
}
