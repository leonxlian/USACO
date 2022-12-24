import java.io.*;
import java.util.*;
public class YearOfTheCow2 {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		ArrayList<Integer> al=new ArrayList<>();
		HashSet<Integer>hs=new HashSet<Integer>();
		for(int i=0;i<n;i++) {
			al.add((a[i]+11)/12);
			hs.add((a[i]+11)/12);
		}
		int count=hs.size();//total intervals
		al.add(0);
		Collections.sort(al);
		Collections.reverse(al);
		ArrayList<Integer> diff=new ArrayList<>();
		for(int i=0;i<al.size()-1;i++) {
			if(al.get(i)-al.get(i+1)!=0&&al.get(i)-al.get(i+1)!=1) {
				diff.add(al.get(i)-al.get(i+1));
			}
		}
		Collections.sort(diff);
		m-=1;
		while(m>0&&!diff.isEmpty()) {
			diff.remove(diff.size()-1);
			m--;
		}
		int ans=0;//get the inbetween intervals
		for(int i=0;i<diff.size();i++) {
			ans+=diff.get(i)-1;//add all the skips that cannot be teleported
		}
		System.out.println((count+ans)*12);
	}
}
