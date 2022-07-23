import java.io.*;
import java.util.*;
public class MadScientist {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());//what he wanted
		String s1=st.nextToken();
		st=new StringTokenizer(br.readLine());//what he sees
		String s2=st.nextToken();
		int ans=0;
		char a[]=s1.toCharArray();
		char b[]=s2.toCharArray();
		for(int i=0;i<n-1;i++){			 
		      if(a[i]!=b[i]&&a[i+1]==b[i+1]) 
		    	  ans++;
		  }
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}	