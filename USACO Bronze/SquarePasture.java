import java.io.*;
import java.util.*;
public class SquarePasture {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new  FileReader("square.in"));
	PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));
	//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	int x1=Integer.parseInt(st.nextToken());
	int y1=Integer.parseInt(st.nextToken());
	int x2=Integer.parseInt(st.nextToken());
	int y2=Integer.parseInt(st.nextToken());
	st=new StringTokenizer(br.readLine());
	int x3=Integer.parseInt(st.nextToken());
	int y3=Integer.parseInt(st.nextToken());
	int x4=Integer.parseInt(st.nextToken());
	int y4=Integer.parseInt(st.nextToken());
	int c=Math.max(x1, Math.max(x2, Math.max(x3, x4)));
	int d=Math.min(x1, Math.min(x2, Math.min(x3, x4)));
	int e=Math.max(y1, Math.max(y2, Math.max(y3, y4)));
	int f=Math.min(y1, Math.min(y2, Math.min(y3, y4)));
	int diff1=Math.abs(d-c);
	int diff2=Math.abs(f-e);
	int side=Math.max(diff1, diff2);
	int ans=side*side;
	//System.out.println(ans);
	pw.println(ans);
	pw.close();
	}
}
