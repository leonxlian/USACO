import java.io.*;
import java.util.*;
public class RobotInstructions3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long xGoal = Long.parseLong(st.nextToken());
        long yGoal = Long.parseLong(st.nextToken());
        long x[]=new long[n];
        long y[]=new long[n];
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	x[i]=Long.parseLong(st.nextToken());
        	y[i]=Long.parseLong(st.nextToken());
        }
        Instruction[] left = new Instruction[1 << (n / 2)];//loop half
        Instruction[] right = new Instruction[1 << ((n + 1) / 2)];
        for(int mask=0;mask<(1<<(n/2));mask++){
        	long xx=0;
        	long yy=0;
        	for(int j=0;j<n/2;j++) {
        		if(((mask>>j)&1)==1) {
        			xx+=x[j];
        			yy+=y[j];
        		}
        	}
        	left[mask] = new Instruction(xx, yy, Integer.bitCount(mask));
        }
        Arrays.sort(left);
        for(int mask=0;mask<(1<<((n+1)/2));mask++){
        	long xx=0;
        	long yy=0;
        	for(int j=n/2;j<n;j++) {
        		if(((mask>>(j-(n/2)))&1)==1) {
        			xx+=x[j];
        			yy+=y[j];
        		}
        	}
        	right[mask] = new Instruction(xGoal-xx, yGoal-yy, Integer.bitCount(mask));
        }
        Arrays.sort(right);
        for(int i=0;i<left.length;i++) {
        	System.out.println(left[i].x+" "+left[i].y+" "+left[i].instructions);
        }
        for(int i=0;i<right.length;i++) {
        	System.out.println(right[i].x+" "+right[i].y+" "+right[i].instructions);
        }
        long[] ans=new long[n+1];
        long[] amounts = new long[(n / 2) + 1];
        int j = 0;
        int k = 0;
        for (Instruction choice : right) {//difference between less than equals and equals and less than
            while (j < left.length && left[j].compareTo(choice) <= 0) {
                amounts[left[j].instructions]++;//index if the left is smaller than or equal to right
                j++;//compare y then x
            }
            while (k < left.length && left[k].compareTo(choice) < 0) {
                amounts[left[k].instructions]--;//index if the left is smaller than right
                k++;
            }
            for(int instructions = 0; instructions <= n / 2; instructions++) {//from instructions to 
                ans[instructions + choice.instructions] += amounts[instructions];
            }
        }
        
    }
    static class Instruction implements Comparable<Instruction> {
        final long x;
        final long y;
        final int instructions;
 
        Instruction(long x, long y, int instructions) {
            this.x = x;
            this.y = y;
            this.instructions = instructions;
        }
 
        @Override
        public int compareTo(Instruction other) {
            if (y != other.y) {
                return Long.compare(y, other.y);
            } else {
                return Long.compare(x, other.x);
            }
        }
    }
}