import java.io.*;
import java.util.*;
public class VacationPlanning {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("vacation.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("vacation.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        int [][]a=new int[201][201];
        for(int i=0;i<201;i++) {
        	Arrays.fill(a[i], 0);
        }
        for(int i=0;i<n;i++) {
        	for(int j=0;j<n;j++) {
        		if(i!=j) {
        			a[i][j]=100000000; //infinity between two farms
        		}
        	}
        }
        for(int i=0;i<m;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken())-1;
        	int y=Integer.parseInt(st.nextToken())-1;
        	int c=Integer.parseInt(st.nextToken());
        	a[x][y]=c;
        }
        for(int x=0;x<n;x++) { //if mid x better for dist, floyd warshall
        	for(int i=0;i<n;i++) {
        		for(int j=0;j<n;j++) {
        			a[i][j]=Math.min(a[i][j],a[i][x]+a[x][j]);
        		}
        	}
        }
        int count=0;
        long sum=0;
        for(int i=0;i<q;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken())-1;
        	int y=Integer.parseInt(st.nextToken())-1;
        	int cost=100000000;
        	for(int j=0;j<k;j++) {
        		cost=Math.min(cost, a[x][j]+a[j][y]);
        	}
        	if(cost!=100000000) {
        		count++;
        		sum+=cost;
        	}
        }
        System.out.println(count);
        ////System.out.println(sum);
        pw.println(count);
        pw.println(sum);
        pw.close();
	}
}
