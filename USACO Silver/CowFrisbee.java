import java.io.*;
import java.util.*;
public class CowFrisbee {
	static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n];
		TreeSet<Integer>ts=new TreeSet<>();
		int[] pos=new int[n];
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken())-1;
			ts.add(i);
			pos[a[i]]=i;
		}
		long ans=0;
		for(int i=0;i<n;i++) {
			int cur=pos[i];//get position, get next cow higher and next cow lower 
			int posl=-1;
			int posr=-1;
			if(cur!=ts.first()) {
				posl=ts.lower(cur);
			}
			if(cur!=ts.last()) {
				posr=ts.higher(cur);
			}
			if(posl!=-1) {
				ans+=cur-posl+1;
			}
			if(posr!=-1) {
				ans+=posr-cur+1;
			}
			ts.remove(cur);
		}
		out.println(ans);
		out.close();
	}
}
