import java.io.*;
import java.util.*;
public class MazeTicTacToe{
	public static PrintWriter out;
	static int pow3[]=new int[10];
	//static int ans=0;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static char grid[][][];
	static boolean visited[][][];
	static HashSet<Integer> hs=new HashSet<>();
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		pow3[0] = 1;
		for (int i=1; i<=9; i++) {
			pow3[i] = pow3[i-1]*3;
		}
		int startx=0;
		int starty=0;
		int n=Integer.parseInt(st.nextToken());
		grid=new char[n][n][3];
		visited=new boolean[n][n][19683];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String str=st.nextToken();
			for(int j=0;j<3*n;j+=3) {
				grid[i][j/3][0]=str.charAt(j);
				grid[i][j/3][1]=str.charAt(j+1);
				grid[i][j/3][2]=str.charAt(j+2);
				if(grid[i][j/3][0]=='B') {
					startx=i;
					starty=j/3;
				}
			}
		}
		dfs(startx, starty, 0);
		out.println(hs.size());
		out.close();
	}
	static void dfs(int x, int y, int b) {
		if(visited[x][y][b]) {
			return;
		}
		visited[x][y][b]=true;
		if(grid[x][y][0]=='M'||grid[x][y][0]=='O') {
			int r=grid[x][y][1]-'1'; 
			int c=grid[x][y][2]-'1'; 
			int idx = r*3+c;
			int current_char = (b / pow3[idx]) % 3;
			if (current_char == 0) {
				int new_char = grid[x][y][0]=='M' ? 1 : 2;
				b = (b % pow3[idx]) + new_char * pow3[idx] + (b - b % pow3[idx+1]);
				if (!visited[x][y][b] && isWin(b)) { 
					hs.add(b);
					return;
				}
				visited[x][y][b]=true;
			}
		}
		for(int c=0;c<4;c++) {
			int nextX=x+dx[c];
			int nextY=y+dy[c];
			if(grid[nextX][nextY][0]!='#') {
				dfs(nextX, nextY, b);
			}
		}
	}
	static boolean isWin(int b) {
		int cells[][]=new int[3][3];
		for (int i=0; i<3; i++)
			for (int j=0; j<3; j++) {
				cells[i][j] = b%3;
				b /= 3;
		    }
		for (int r=0; r<3; r++) {
			if (cells[r][0] == 1 && cells[r][1] == 2 && cells[r][2] == 2) return true;
		    if (cells[r][0] == 2 && cells[r][1] == 2 && cells[r][2] == 1) return true;
		}
		for (int c=0; c<3; c++) {
		    if (cells[0][c] == 1 && cells[1][c] == 2 && cells[2][c] == 2) return true;
		    if (cells[0][c] == 2 && cells[1][c] == 2 && cells[2][c] == 1) return true;
		}
		if (cells[0][0] == 1 && cells[1][1] == 2 && cells[2][2] == 2) return true;
		if (cells[0][0] == 2 && cells[1][1] == 2 && cells[2][2] == 1) return true;
		if (cells[2][0] == 1 && cells[1][1] == 2 && cells[0][2] == 2) return true;
		if (cells[2][0] == 2 && cells[1][1] == 2 && cells[0][2] == 1) return true;
		return false;
	}
}
