import java.util.*;
import java.io.*;
public class test {
   public static void main(String[] args)throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      //PrintWriter out = new PrintWriter(System.out);
      int n=Integer.parseInt(st.nextToken());
      int k=Integer.parseInt(st.nextToken());
      int a[]=new int[n];
      for(int i=0;i<n;i++) {
    	  st=new StringTokenizer(br.readLine());
    	  a[i]=Integer.parseInt(st.nextToken());
      }
      Arrays.sort(a);
      int j=0;
      int ans=0;
      for(int i=0;i<n;i++) {
    	  while(a[j]-a[i]<=k&&j<n-1) {
    		  j++;
    	  }
    	  ans=Math.max(j-i, ans);
      }
      if(a[n-1]-a[0]<=k) {
    	  ans=n;
      }
      //out.println(ans);
      //out.close();
      pw.println(ans);
      pw.close();
   }
}



