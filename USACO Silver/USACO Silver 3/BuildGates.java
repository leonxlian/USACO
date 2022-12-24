import java.io.*;
import java.util.*;
public class BuildGates {
	static boolean b[][];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		char[] ch=st.nextToken().toCharArray();
		int cx=1000; 
		int cy=1000;
		b=new boolean[2000][2000];
		b[cx][cy]=true;
		for(int i=0;i<n;i++) {
			int x=0, y=0;
			if(ch[i]=='N')x=1;
			if(ch[i]=='E')y=1;
			if(ch[i]=='S')x=-1;
			if(ch[i]=='W')y=-1;
			for(int j=0;j<2;j++) {
				cx+=x;
				cy+=y;
				b[cx][cy]=true;
			}
		}
		int ans=0;
		int []dx=new int[] {-1,0,1,0};
		int []dy=new int[] {0,1,0,-1};
		for(int i=0;i<b.length;i++) {
			for(int j=0;j<b[i].length;j++) {
				if(b[i][j])continue;
				ans++;
				ArrayDeque<Integer> x=new ArrayDeque<>();
				ArrayDeque<Integer> y=new ArrayDeque<>();
				x.add(i);
				y.add(j);
				while(!x.isEmpty()) {
					int x1=x.poll();
					int y1=y.poll();
					for(int c=0;c<4;c++) {
						int nextX=x1+dx[c];
						int nextY=y1+dy[c];
						if(nextX<b.length&&nextX>=0&&nextY<b[i].length&&nextY>=0) {
							if(!b[nextX][nextY]) {
								b[nextX][nextY]=true;
								x.addLast(nextX);
								y.addLast(nextY);
							}
						}
					}
				}
			}
		}
		//System.out.println(ans-1);
		pw.println(ans-1);
		pw.close();
	}
}
