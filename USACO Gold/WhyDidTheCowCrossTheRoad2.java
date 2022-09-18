import java.io.*;
import java.util.*;
public class WhyDidTheCowCrossTheRoad2 {
	public static PrintWriter out;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("talent.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("talent.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    out = new PrintWriter(System.out);
	    int n=Integer.parseInt(st.nextToken());
	    
	    out.close();
	    pw.close();
	}
}
