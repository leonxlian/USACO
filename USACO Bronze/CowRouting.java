import java.io.*;
import java.util.*;
public class CowRouting {
	public static void main(String[] args) throws IOException {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new FileReader("cowroute.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("cowroute.out")));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String n=new String(st.nextToken());		
		int ans=0;
		//System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
}
