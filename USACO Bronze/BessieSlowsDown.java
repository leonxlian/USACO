import java.io.*;
import java.util.*;
public class BessieSlowsDown {
	public static void main(String[] args) throws IOException {
		//Scanner sc=new Scanner(System.in);
		Scanner sc = new Scanner(new File("slowdown.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("slowdown.out")));
        int n=sc.nextInt();
        int ans=0;
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();
        for(int i=0;i<n;i++) {
        	String a=sc.next();
        	int k=sc.nextInt();
        	hmap.put(a,k);
          }
        int a=hmap.get("D");
        int temp=a*1;
        int c=hmap.get("T");
        int temp1=c-a;
        temp1=(c-a);
        int temp2=1000-c;
        temp2=(temp2)*3;
        ans=temp+temp1+temp2;
        System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
}
