import java.io.*;
import java.util.*;
public class Stampede {
	public static void main(String[] args)throws IOException{
		//BufferedReader br = new BufferedReader(new FileReader("stampede.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("stampede.out")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		ArrayList<Pair>al=new ArrayList<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			a*=-c;
			al.add(new Pair(a-c,b));//start
			al.add(new Pair(a,-b));//end
		}
		Collections.sort(al);
		/*for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i).x+" "+al.get(i).y);
		}*/
		HashSet<Integer>ans=new HashSet<>();
		HashSet<Integer>active=new HashSet<>();
		for (int i = 0; i < al.size(); ) {
		    /* Add/remove any intervals that begin/end at time events[i].first. */
		    int j;
		    for (j = i; j < al.size() && al.get(i).x == al.get(j).x; j++) {
		    	int y = al.get(j).y;
		    	if (y > 0) {
		    		active.add(y);
		    	}else{
		    		active.remove(-y);
		      	}
		    }
		    /* Add the first interval we can see to our list of seen intervals. */
		    ArrayList<Integer>temp=new ArrayList<>(active);
		    if (!active.isEmpty()) {
		    	ans.add(temp.get(0));
		    }
		    i=j;
		}
		
		System.out.println(ans.size());
		//pw.println(ans.size());
		//pw.close();
	}
	static class Pair implements Comparable<Pair>{
		int x, y;
		public Pair(int x, int y) {
			this.x=x;this.y=y;
		}
		public int compareTo(Pair o) {
			if(x==o.x) {
				return y-o.y;
			}else {
				return x-o.x;
			}
		}
	}
}
