import java.io.*;
import java.util.*;
public class Teleportation {
	static TreeMap<Integer, Integer>map;
	public static void main(String[] args)throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long t=0;
        map=new TreeMap<Integer, Integer>();
        for(int i=0;i<n;i++) {
        	st=new StringTokenizer(br.readLine());
        	int a=Integer.parseInt(st.nextToken());
        	int b=Integer.parseInt(st.nextToken());
        	t+=Math.abs(a-b);
        	if(Math.abs(a)>Math.abs(a-b)) { //no need to take train, no need to go to 0
        		continue;
        	}
        	//do adjustment using slope
        	update(b, 2);
        	if((a<b&& a<0&&b>0)||(a>=b  && a>=0 && b<0)){
        		update(0, -1);
        		update(b*2, -1);
        	}else {
        		update((b-a)*2,-1);
        		update(a*2, -1);
        	}
        }
        long ret=t, cnt=0, adjust=Long.MIN_VALUE;
        for(Integer y:map.keySet()) {
        	int delta=map.get(y);
        	t+=cnt*(y-adjust);
        	adjust=y;
        	cnt+=delta;
        	ret=Math.min(ret, t);
        }
        System.out.println(ret);
        //pw.println(ret);
        //pw.close();
	}
	static void update(int key, int delta) {//update delta by taking train
		int val0=0;
		if(map.containsKey(key)) {
			val0=map.get(key);
		}
		val0+=delta;
		map.put(key, val0);
	}
}
