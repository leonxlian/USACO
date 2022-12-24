import java.io.*;
import java.util.*;
public class YearOfTheCow {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int jumps=Integer.parseInt(st.nextToken());
		int a[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		ArrayList<Integer> floor=new ArrayList<Integer>();
		HashSet<Integer> hs=new HashSet<Integer>();
		for(int i=n-1;i>=0;i--) {
			floor.add((a[i]+11)/12);
			hs.add((a[i]+11)/12);
		}
		int count=hs.size();//number of intervals need to go over
		ArrayList<Integer>dif=new ArrayList<Integer>();
		floor.add(0);
		Collections.sort(floor);
		Collections.reverse(floor);
		for(int i=0;i<floor.size()-1;i++) {
			int dec=floor.get(i)-floor.get(i+1);//add all the differences, to be able to sort
			if(dec!=0&&dec!=1) {
				dif.add(dec);
			}
		}
		Collections.sort(dif);
		jumps-=1;//one teleport to go back
		while(jumps>0&&!dif.isEmpty()) { //remove the jumps that have the greatest differences
			dif.remove(dif.size()-1);
			jumps--;
		}
		int ans=0;
		for(int i=0;i<dif.size();i++) {
			ans+=dif.get(i)-1;//add all the skips that cannot be teleported
		}
		System.out.println((count+ans)*12);
	}
}
