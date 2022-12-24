import java.io.*;
import java.util.*;

public class FuelEconomy {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("fuel.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("fuel.out")));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        state[]a=new state[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken());
        	int y=Integer.parseInt(st.nextToken());
        	a[i]=new state(x,y);
        }
        Arrays.sort(a);
        int[]s = new int[n];// stack
        int[]b = new int[n];//control array
        int t1=0; //t1 is the pointing to top of stack
        for(int i=n-1;i>=0;i--) {
        	while(t1>0 && a[s[t1-1]].c>=a[i].c)
        		t1--;
        	b[i]=(t1==0)?-1:s[t1-1];
        	s[t1]=i;
        	t1++;
        }
        c-=a[0].p;
        long ret=0;
        for(int i=0;i<n;i++) {
        	if(c<0) {
        		//pw.println(-1);
        		return;
        	}
        	int t=Math.min(m, (b[i]==-1? d: a[b[i]].p)-a[i].p);
        	if(t>c) {
        		ret+=(long)(t-c)*(long)a[i].c;
        		c=t;
        	}
        	c-=(i==n-1? d: a[i+1].p)-a[i].p;
        	}
        if(c<0) {
        	System.out.println(-1);
        	//pw.println(-1);
        }else {
        	System.out.println(ret);
        	//pw.println(ret);
        }
        //pw.close();
	}
	static class state implements Comparable<state>{
		int p, c;
		public state(int p, int c) {
			this.p=p;this.c=c;
		}
		public int compareTo(state o) {
			return p-o.p;
		}
	}
}
