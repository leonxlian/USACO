import java.io.*;
import java.util.*;
public class RecordKeeping {
	public static void main(String[] args) throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader("records.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("records.in")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		String[]a=new String[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=st.nextToken();
		}
		int num=0;
	}
}
