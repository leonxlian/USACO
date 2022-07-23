import java.io.*;
import java.util.*;
public class BucketBrigade {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("buckets.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int xb=0;
        int yb=0;
        int xl=0;
        int yl=0;
        int xr=0;
        int yr=0;
        for(int i=0;i<10;i++) {
            char a[]=br.readLine().toCharArray();
            for(int j=0;j<10;j++) {
                if(a[j]=='B') {
                    xb=i;
                    yb=j;
                } else if(a[j]=='L') {
                    xl=i;
                    yl=j;
                } else if (a[j]=='R') {
                    xr=i;
                    yr=j;
                }
            }
        }
        boolean less = false;
        boolean more = false;
        if((xb==xl&&xb==xr)||(yb==yl&&yb==yr)) {
            if(xb > xr || yb > yr || xl > xr || yl > yr) {
                more = true;
            }
            if(xb < xr || yb < yr || xl < xr || yl < yr) {
                less = true;
            }
            if(less && more) {
                //System.out.println(Math.abs(xb-xl)+Math.abs(yb-yl)+1);
            	pw.println(Math.abs(xb-xl)+Math.abs(yb-yl)+1);
            } else {
                //System.out.println(Math.abs(xb-xl)+Math.abs(yb-yl)-1);
            	pw.println(Math.abs(xb-xl)+Math.abs(yb-yl)-1);
            }         
        } else {
            //System.out.println(Math.abs(xb-xl)+Math.abs(yb-yl)-1);
            pw.println(Math.abs(xb-xl)+Math.abs(yb-yl)-1);
        }
        pw.close();
    }
}