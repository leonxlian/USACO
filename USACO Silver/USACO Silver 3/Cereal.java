import java.util.*;
import java.io.*;
public class Cereal {
   public static void main(String[] args)throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("cereal.in"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cereal.out")));
      //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      //PrintWriter out = new PrintWriter(System.out);
      int n=Integer.parseInt(st.nextToken());
      int m=Integer.parseInt(st.nextToken());
      int f[]=new int[n];
      int s[]=new int[n];
      int o[]=new int[n+1];
      for(int i=0;i<n;i++) {
    	  st=new StringTokenizer(br.readLine());
    	  f[i]=Integer.parseInt(st.nextToken());
    	  s[i]=Integer.parseInt(st.nextToken());
      }
      int count=0;
      int ans[]=new int[n];
      for(int i=n-1;i>=0;i--) {
    	  int j=i;
    	  int pos=f[i];
    	  while(true) {//keep looping until this kicking out cycle ends
    		  if(o[pos]==0) {//no cow occupies this position
    			  o[pos]=j;
    			  count++;
    			  break;
    		  }else if(o[pos]<j){//check if the new cow has higher priority
    			  break;
    		  }else {
    			  int k=o[pos];//get the current cow in the position
    			  o[pos]=j;//if new cow has higher priority, kick out the cow
    			  if(pos==s[k]) {//if the current kickout cow is at it's second favorite cereal
    				  break;//end of this cycle
    			  }
    			  j=k;//set the new cow to be the one kicked out
    			  pos=s[k];//if the current cow being kicked is not at it's second favorite cereal
    		  }//set the checking to it's second fav cereal
    	  }
    	  ans[i]=count;
      }
      for(int i=0;i<n;i++) {
    	  //out.println(ans[i]);
    	  pw.println(ans[i]);
      }
      //out.close();
      pw.close();
   }
}
