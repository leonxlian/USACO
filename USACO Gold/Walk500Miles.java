import java.io.*;
import java.util.*;
public class Walk500Miles {
	public static void main(String[] args)throws IOException {
	      BufferedReader br = new BufferedReader(new FileReader("walk.in"));
	      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("walk.out")));
	      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      PrintWriter out = new PrintWriter(System.out);
	      StringTokenizer st = new StringTokenizer(br.readLine());
	      int n=Integer.parseInt(st.nextToken());
	      int k=Integer.parseInt(st.nextToken());
	      //out.println(2019201997-84*(k-1)-48*n);
	      //out.close();
	      pw.println(2019201997-84*(k-1)-48*n);
	      pw.close();
	}
}
