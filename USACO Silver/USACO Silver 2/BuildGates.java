import java.io.*;
import java.util.*;
public class BuildGates {
	static int dx[]={1,-1,0,0};
	static int dy[]={0,0,1,-1};
	static int n;
	static boolean b[][];
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("gates.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gates.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		String str=st.nextToken();
		int cx=1000;
		int cy=1000;
		b=new boolean[2000][2000];
		b[cx][cy]=true;
		for(int i=0;i<n;i++) {
			char c=str.charAt(i);
			int x=0;
			int y=0;
			if(c=='N')y=1;
			if(c=='S')y=-1;
			if(c=='E')x=1;
			if(c=='W')x=-1;
			for(int j=0;j<2;j++) {
				cx+=x;
				cy+=y;
				b[cx][cy]=true;
			}
		}
		int ans=-1;
		for(int i=0;i<b.length;i++) {
            for(int j=0;j<b[i].length;j++) {
            	if(b[i][j]==true) {
            		continue; 
            	}
            	ans++;
            	ArrayDeque<Integer>queX=new ArrayDeque<>();
            	ArrayDeque<Integer>queY=new ArrayDeque<>();
            	queX.add(i);
            	queY.add(j);
            	b[i][j]=true;
            	while(!queX.isEmpty()) {
            		int curX=queX.poll();
            		int curY=queY.poll();
            		for(int c=0;c<4;c++) {
            			int nextX=curX+dx[c];
            			int nextY=curY+dy[c];
            			if(nextX<0||nextY<0||nextX>=b.length||nextY>=b[i].length) {
            				continue;
            			}else if(!b[nextX][nextY]) {
            				b[nextX][nextY]=true;
            				queX.addLast(nextX);
            				queY.addLast(nextY);
            			}
            		}
            	}
            }
        }
		//System.out.println(ans);
		pw.println(ans);
		pw.close();
	}
}

