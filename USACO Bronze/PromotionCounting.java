import java.io.*;
import java.util.*;
public class PromotionCounting {
	public static void main(String[] args)throws IOException{
	BufferedReader br = new BufferedReader(new FileReader("promote.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
	//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int bbefore=Integer.parseInt(st.nextToken());
	int bafter=Integer.parseInt(st.nextToken());
	st=new StringTokenizer(br.readLine());
	int sbefore=Integer.parseInt(st.nextToken());
	int safter=Integer.parseInt(st.nextToken());
	st=new StringTokenizer(br.readLine());
	int gbefore=Integer.parseInt(st.nextToken());
	int gafter=Integer.parseInt(st.nextToken());
	st=new StringTokenizer(br.readLine());
	int pbefore=Integer.parseInt(st.nextToken());
	int pafter=Integer.parseInt(st.nextToken());
	int ppromotion=pafter-pbefore;
	int gpromotion=gafter-gbefore+pafter-pbefore;
	int spromotion=safter-sbefore+gafter-gbefore+pafter-pbefore;
	//System.out.println(spromotion);
	//System.out.println(gpromotion);
	//System.out.println(ppromotion);
	pw.println(spromotion);
	pw.println(gpromotion);
	pw.println(ppromotion);
	pw.close();
	}
}
