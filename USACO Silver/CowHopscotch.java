import java.io.*;
import java.util.*;

public class CowHopscotch {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hopscotch.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hopscotch.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int z=Integer.parseInt(st.nextToken());
        int a[][]=new int[x][y];
        for(int i=0;i<x;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<y;j++) {
        		a[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        int [][]c=new int[x][y];
        c[0][0]=1;
        for(int i1=0;i1<x;i1++) {
        	for(int i2=0;i2<y;i2++) {
        		for(int i3=i1+1;i3<x;i3++) {
        			for(int i4=i2+1;i4<x;i4++) {
        				if(a[i1][i2]!=a[i3][i4]) {
        					c[i3][i4]+=c[i1][i2];
        					c[i3][i4]%=1000000007;
        				}
        			}
        		}
        	}
        }
        //System.out.println(c[x-1][y-1]);
        pw.println(c[x-1][y-1]);
        pw.close();
	}
}
