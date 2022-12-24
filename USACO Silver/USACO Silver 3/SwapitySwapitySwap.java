import java.io.*;
import java.util.*;
public class SwapitySwapitySwap {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("swap.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        //PrintWriter out = new PrintWriter(System.out);
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int a[]=new int[n+1];
        boolean v[]=new boolean[n+1];
        for(int i=1;i<=n;i++) {
        	a[i]=i;
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int l=Integer.parseInt(st.nextToken());
        	int r=Integer.parseInt(st.nextToken());
        	for(int j=0;j<(r-l+1)/2;j++) {
        		int temp=a[l+j];
        		a[l+j]=a[r-j];
        		a[r-j]=temp;
        	}
        }
        for(int i=1;i<=n;i++) {
        	if(!v[i]) {
        		v[i]=true;
        		int start=a[i];
        		ArrayList<Integer>cycle=new ArrayList<Integer>();
        		cycle.add(i);
        		while(start!=i) {
        			v[start]=true;
        			cycle.add(start);
        			start=a[start];
        		}
        		int mod=k%cycle.size();
        		for(int j=0;j<cycle.size();j++) {
        			a[cycle.get(j)]=cycle.get((j+mod)%cycle.size());
        		}
        	}
        }
        for(int i=1;i<=n;i++) {
        	//out.println(a[i]);
        	pw.println(a[i]);
        }
        //changed after one cycle
        //out.close();
        pw.close();
	}
}
