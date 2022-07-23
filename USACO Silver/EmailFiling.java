import java.io.*;
import java.util.*;
public class EmailFiling {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int t=Integer.parseInt(st.nextToken());
		while(t-->0) {
			st=new StringTokenizer(br.readLine());
			int m=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			int topf=1;
			int topm=0;
			ArrayList<Integer>mail=new ArrayList<Integer>();
			int[] occurence=new int[m+1];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++) {
				int x=Integer.parseInt(st.nextToken());
				mail.add(x);
				occurence[x]++;
			}
			boolean change=false;
			while(!mail.isEmpty()) {
				change=false;
				for(int i=topm;i<mail.size()&&i<topm+k;i++) {
					if(mail.get(i)>=topf&&mail.get(i)<topf+k) {//if it's between the two folders
						change=true;
						int val=mail.get(i);
						mail.remove(i);
						occurence[val]--;
						i--;
					}
				}
				if(!mail.contains(topf)) {
					change=true;
					topf++;
				}
				if(topm>mail.size()-k) {//if the top mail is in the last range
					change=true;
					topm=k<mail.size()?mail.size()-k:0;//make top m start of last range
				}
				if(!change) {
					if(topm<mail.size()-k) {//if within last range
						topm++;
					}else {
						break;
					}
				}
			}
			System.out.println(mail.size()==0?"YES":"NO");
		}
	}
}
