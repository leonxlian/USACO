import java.io.*;
import java.util.*;
public class MooTube {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("mootube.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        LinkedList<state>[] e=new LinkedList[n];
        for(int i=0;i<n;i++) {//array of linked list
        	e[i]=new LinkedList<state>();
        }
        for(int i=1;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken())-1;
        	int y=Integer.parseInt(st.nextToken())-1;
        	int w=Integer.parseInt(st.nextToken());
        	e[x].add(new state(y,w));
        	e[y].add(new state(x,w));
        }
        for(int i=0;i<q;i++) {
        	st=new StringTokenizer(br.readLine());
        	int x=Integer.parseInt(st.nextToken());
        	int y=Integer.parseInt(st.nextToken())-1;
        	int ret=0;
        	//BFS
        	LinkedList<Integer>queue=new LinkedList<Integer>();
        	queue.add(y);
        	boolean v[]=new boolean[n];
        	v[y]=true;
        	while(!queue.isEmpty()) {
        		int c=queue.removeFirst();
        		for(state next:e[c]) { //loop all neighbor of node c
        			if(!v[next.d]&&next.w>=x) { //not visited and weight>query threshold
        				v[next.d]=true;
        				queue.add(next.d);
        				ret++;
        			}
        		}
        	}
        	//System.out.println(ret);
            pw.println(ret);
        }
        pw.close();     
	}
	static class state{
		int d, w;
		public state(int d, int w) {
			this.d=d; this.w=w;
		}
	}
}
