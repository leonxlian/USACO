import java.io.*;
import java.util.*;
public class BovineShuffle {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int a[]=new int[n];  //[2 1 0 2] from [0 1 2 3]
		int b[]=new int[n];  // b[1 1 2 0]
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken())-1;
			b[a[i]]++;
		}
		int ret=n;
		LinkedList<Integer> q=new LinkedList<Integer>();
		for(int i=0;i<n;i++){
			if(b[i]==0) {
				q.add(i); //found empty spot
				ret--;
			}
		}
		while(!q.isEmpty()) {
			int cur=q.removeFirst();
			b[a[cur]]--; //apply shuffle
			if(b[a[cur]]==0) {//check if position will be removed after shuffle
				q.add(a[cur]);
				ret--;
			}
		}
		//System.out.println(ret);
		pw.println(ret);
		pw.close();
	}
}
