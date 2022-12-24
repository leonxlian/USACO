import java.io.*;
import java.util.*;
public class DanceMooves {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int cows[]=new int[n+1];
        ArrayList<Integer>[] ps=new ArrayList[n+1];
        for(int i=1;i<=n;i++) {
        	cows[i]=i;
        	ps[i]=new ArrayList<>();
        	ps[i].add(i);
        }
        for(long t=1;t<=k;t++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	int c=cows[a];
        	int d=cows[b];
        	cows[a]=d;
        	cows[b]=c;
        	ps[cows[a]].add(a);
        	ps[cows[b]].add(a);
        }
        int ans[]=new int[n+1];
        for(int r=1;r<=n;r++) {
        	if(cows[r]!=0) {
        		ArrayList<Integer> cycle=new ArrayList<>();
        		int j=r;
        		while(cows[j]!=0) {
        			cycle.add(j);
        			j=cows[j];
        			cows[cycle.get(cycle.size())-1]=0;
        		}
        	}
        }
	}
}
