import java.io.*;
import java.util.*;
public class TheBucketList {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new  FileReader("mixmilk.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int []s=new int[100];
		int []t=new int[100];
		int []b=new int[100];
		int buckets=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			s[i]=Integer.parseInt(st.nextToken());
			t[i]=Integer.parseInt(st.nextToken());
			b[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<1000;i++) {
			
		}
		System.out.println(buckets);
		//pw.println(buckets);
		//pw.close();
		}
	
	}
