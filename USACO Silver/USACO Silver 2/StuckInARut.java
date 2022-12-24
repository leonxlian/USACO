import java.io.*;
import java.util.*;
public class StuckInARut {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		ArrayList<Integer>east=new ArrayList<Integer>();
		ArrayList<Integer>north=new ArrayList<Integer>();
		int xs[]=new int[n];
		int ys[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			if(str.equals("E")) {
				east.add(i);
			}else {
				north.add(i);
			}
			xs[i]=Integer.parseInt(st.nextToken());
			ys[i]=Integer.parseInt(st.nextToken());
		}
		east.sort(Comparator.comparingInt(j -> ys[j]));
		north.sort(Comparator.comparingInt(j -> xs[j]));
		boolean stopped[]=new boolean[n];
		int amtstopped[]=new int[n];
		for(int j:east) {
			for(int k:north) {
				if(!stopped[j]&&!stopped[k]&&xs[k]>xs[j]&&ys[j]>ys[k]) {
					if(ys[j]-ys[k]>xs[k]-xs[j]) {
						stopped[k]=true;
						amtstopped[j]+=amtstopped[k]+1;
					}else if(ys[j]-ys[k]<xs[k]-xs[j]) {
						stopped[j]=true;
						amtstopped[k]+=amtstopped[j]+1;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(amtstopped[i]);
		}
	}
}
