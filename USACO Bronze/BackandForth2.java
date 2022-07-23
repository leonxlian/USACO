import java.io.*;
import java.util.*;
public class BackandForth2 {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		ArrayList<Integer> a=new ArrayList<Integer>();//first barn
		ArrayList<Integer> b=new ArrayList<Integer>();//second barn
		for(int i=0;i<10;i++) {
			a.add(Integer.parseInt(st.nextToken()));
		}
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<10;i++) {
			b.add(Integer.parseInt(st.nextToken()));
		}
		int firstbarn=1000;
		int secondbarn=1000;
		for(int i=0;i<10;i++) {
			
		}
	}
}
