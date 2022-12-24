import java.io.*;
import java.util.*;
public class RobotInstructions2 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        StringTokenizer tokenizer = new StringTokenizer(in.readLine());
        long xGoal = Long.parseLong(tokenizer.nextToken());
        long yGoal = Long.parseLong(tokenizer.nextToken());
        long[] instructionsX = new long[n];
        long[] instructionsY = new long[n];
        for (int j = 0; j < n; j++) {
            tokenizer = new StringTokenizer(in.readLine());
            instructionsX[j] = Long.parseLong(tokenizer.nextToken());
            instructionsY[j] = Long.parseLong(tokenizer.nextToken());
        }
        InstructionChoice[] choicesLeft = new InstructionChoice[1 << (n / 2)];//loop half
        for (int mask = 0; mask < 1 << (n / 2); mask++) {
            long x = 0;
            long y = 0;
            for (int j = 0; j < n / 2; j++) {
                if ((mask & (1 << j)) != 0) {
                    x += instructionsX[j];
                    y += instructionsY[j];
                }
            }
            choicesLeft[mask] = new InstructionChoice(x, y, Integer.bitCount(mask));
        }
        Arrays.sort(choicesLeft);
        InstructionChoice[] choicesRight = new InstructionChoice[1 << ((n + 1) / 2)];
        for (int mask = 0; mask < 1 << ((n + 1) / 2); mask++) {
            long x = 0;
            long y = 0;
            for (int j = n / 2; j < n; j++) {
                if ((mask & (1 << (j - (n / 2)))) != 0) {
                    x += instructionsX[j];
                    y += instructionsY[j];
                }
            }
            choicesRight[mask] = new InstructionChoice(xGoal - x, yGoal - y, Integer.bitCount(mask));
        }
        Arrays.sort(choicesRight);
        for(int i=0;i<choicesLeft.length;i++) {
        	System.out.println(choicesLeft[i].x+" "+choicesLeft[i].y+" "+choicesLeft[i].instructions);
        }
        for(int i=0;i<choicesRight.length;i++) {
        	System.out.println(choicesRight[i].x+" "+choicesRight[i].y+" "+choicesRight[i].instructions);
        }
        long[] answer = new long[n + 1];
        long[] amounts = new long[(n / 2) + 1];
        int j = 0;
        int k = 0;
        for (InstructionChoice choice : choicesRight) {//difference between less than equals and equals and less than
            while (j < choicesLeft.length && choicesLeft[j].compareTo(choice) <= 0) {
                amounts[choicesLeft[j].instructions]++;//index if the left is smaller than or equal to right
                j++;//compare y then x
            }
            while (k < choicesLeft.length && choicesLeft[k].compareTo(choice) < 0) {
                amounts[choicesLeft[k].instructions]--;//index if the left is smaller than right
                k++;
            }
            for (int instructions = 0; instructions <= n / 2; instructions++) {//from instructions to 
                answer[instructions + choice.instructions] += amounts[instructions];
            }
        }
        StringBuilder out = new StringBuilder();
        for (int instructionsUsed = 1; instructionsUsed <= n; instructionsUsed++) {
            out.append(answer[instructionsUsed]).append('\n');
        }
        System.out.print(out);
    }
    static class InstructionChoice implements Comparable<InstructionChoice> {
        final long x;
        final long y;
        final int instructions;
 
        InstructionChoice(long x, long y, int instructions) {
            this.x = x;
            this.y = y;
            this.instructions = instructions;
        }
 
        @Override
        public int compareTo(InstructionChoice other) {
            if (y != other.y) {
                return Long.compare(y, other.y);
            } else {
                return Long.compare(x, other.x);
            }
        }
    }
}