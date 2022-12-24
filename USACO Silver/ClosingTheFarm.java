import java.io.*;
import java.util.*;
public class ClosingTheFarm {
	static int n;
	static int m;
	static ArrayList<Integer>v;
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("moocast.out")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        int a[]=new int[n];
        int b[]=new int[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	a[i]=Integer.parseInt(st.nextToken());
        	b[i]=Integer.parseInt(st.nextToken());
        }
	}
	
}