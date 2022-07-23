import java.io.*;
import java.util.*;
public class Teleportation {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int x=Integer.parseInt(st.nextToken());
		int y=Integer.parseInt(st.nextToken());
		int distance=Math.abs(a-b);
		if(distance>Math.abs(a-x)+Math.abs(b-y)) {
			distance=Math.abs(a-x)+Math.abs(b-y);
		}else if(distance>Math.abs(a-y)+Math.abs(b-x)) {
			distance=Math.abs(a-y)+Math.abs(b-x);
		}
		//System.out.println(distance);
		pw.println(distance);
		pw.close();
	}
}

