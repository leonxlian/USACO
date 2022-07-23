import java.io.*;
import java.util.*;
public class ShellGame3{
static int N;
static int[] A, B, G;

    static int correctGuesses(int startShell) {
        int res = 0;
        int curShell = startShell;
        for(int i = 0; i < N; i++) {
            if(A[i] == curShell) curShell = B[i];
            else if(B[i] == curShell) curShell = A[i];
            if(curShell == G[i]) res++;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("shell.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
        N = Integer.parseInt(br.readLine());
        A = new int[N]; B = new int[N]; G = new int[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            G[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for(int i = 0; i < 3; i++) {
            ans = Math.max(ans, correctGuesses(i));
        }
        pw.println(ans);
        pw.close();
    }
}
