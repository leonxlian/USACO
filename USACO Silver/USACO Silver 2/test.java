import java.io.*;
import java.util.*;
public class test {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("berries.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("berries.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int b[]=new int[n];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			b[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(b);
		ArrayList<Integer> a=new ArrayList<Integer>();
		int ans=0;
		for(int i=1;i<=b[n-1];i++) {
			for(int j=0;j<n;j++) {
				int temp=b[j];
				while(temp>0) {
					if(temp<=i) {
						a.add(temp);
						break;
					}else if(temp>i) {
						a.add(i);
						temp-=i;
					}
				}
			}
			Collections.sort(a, Collections.reverseOrder());
			int temp1=0;
			for(int j=k/2;j<k&&j<a.size();j++) {
				temp1+=a.get(j);
			}
			ans=Math.max(temp1, ans);
			a.clear();
		}
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}
