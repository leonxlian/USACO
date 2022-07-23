import java.io.*;
import java.util.*;
public class ComfortableCows {
	static int b[][];
	static int n;
	static int []dx=new int[] {-1,0,1,0};
	static int []dy=new int[] {0,1,0,-1};
	static int ans;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		n=Integer.parseInt(st.nextToken());
		b=new int[4002][4002];
		ans=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			x+=1000;
			y+=1000;//increase value by 1k
			dfs(x, y);
			System.out.println(ans);
		}
	}
	static void dfs(int x, int y){
		ArrayDeque<Integer>xx=new ArrayDeque<>();
		ArrayDeque<Integer>yy=new ArrayDeque<>();
		if(b[x][y]==2) { //if already filled with cow, need to subtract ans
			ans--;
		}
		b[x][y]=1;
		xx.add(x); //add first cow
		yy.add(y);
		for(int c=0;c<4;c++) {
			if((x+dx[c]<=2001)&&(y+dy[c]<=2001)) { //add neighbor of first cow
				if(b[x+dx[c]][y+dy[c]]!=0) {//if visited
					xx.add(x+dx[c]);
					yy.add(y+dy[c]);
				}
			}
		}
		while(!xx.isEmpty()) {
			int curx=xx.poll();//get curx, cury from queue
			int cury=yy.poll();
			ArrayDeque<Integer>neix=new ArrayDeque<>();
			ArrayDeque<Integer>neiy=new ArrayDeque<>();
			int lastX=0;
			int lastY=0;
			for(int c=0;c<4;c++) {
				int nextX=curx+dx[c];
				int nextY=cury+dy[c];
				if((x+dx[c]<=4001)&&(y+dy[c]<=4001)) {
					if(b[nextX][nextY]!=0) {
						neix.add(nextX);//add all neighbors for a queue
						neiy.add(nextY);
					}else {
						lastX=nextX; //keep track of the last index in case need to add a cow
						lastY=nextY;
					}
				}
			}
			if(neix.size()==3) {//if there are only 3 neighbors
				ans++; //index answer
				b[lastX][lastY]=2; //add a cow to complete the fourth neighbor
				xx.add(lastX);//add that cow, with the neighbors of that cow, because it can affect other cows' comfortability
				yy.add(lastY);
				for(int c=0;c<4;c++) {
					int nextX=lastX+dx[c];
					int nextY=lastY+dy[c];
					if(nextX<=4001&&nextY<=4001) {//within bounds
						if(b[nextX][nextY]!=0) {//as long as visited before
							xx.add(nextX);
							yy.add(nextY);
						}
					}
				}
			}
		}
	}
}

