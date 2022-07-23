import java.io.*;
import java.util.*;
public class ContestTiming {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("ctiming.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("ctiming.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String x="))";
		String y="((";
		char[]a=st.nextToken().toCharArray();
		int count=0;
		int count1=0;
		System.out.println(a[1]);
		for(int i=1;i<=50000;i++) {
		if(a[i-1]=='(') {
			if(a[i]=='(') {
				count++;
			}
		} else if(a[i-1]==')') {
			if (a[i]==')') {
				count1++;
			}
		} else {
			continue;
		}
		}
		System.out.println(count1);
		//pw.println();
		//pw.close();
    }
}
