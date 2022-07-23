import java.io.*;
import java.util.*;
public class LongestStrike{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
        Scanner sc=new Scanner();
        out=new PrintWriter(System.out);
        int t=sc.nextInt();
        while(t-->0) {
        	int n=sc.nextInt();
        	int k=sc.nextInt();
        	int a[]=new int[n];
        	HashMap<Integer, Integer>hm=new HashMap<>();
        	for(int i=0;i<n;i++) {
        		a[i]=sc.nextInt();
        		hm.put(a[i], hm.getOrDefault(a[i], 0)+1);
        	}
        	ArrayList<Integer>al=new ArrayList<>();
        	for(int key:hm.keySet()) {
        		if(hm.get(key)>=k) {
        			al.add(key);
        		}
        	}
        	if(al.size()==0) {
        		out.println(-1);
        		continue;
        	}
        	Collections.sort(al);
        	long l = al.get(0) , r = l;
			long L = al.get(0) , R = l;
        	for(int i=1;i<al.size();i++) {
        		if(r==al.get(i)-1) {
        			r++;
        		}else {
        			if(R-L<r-l) {
        				R=r;
        				L=l;
        			}
        			l=al.get(i);
        			r=l;
        		}
        	}
        	if(R-L<r-l) {
				R=r;
				L=l;
			}
        	out.println(L+" "+R);
        }
        out.close();
	}
	public static class Scanner {
	    BufferedReader br;
	    StringTokenizer st;
	
	    public Scanner() {
	        br = new BufferedReader(new InputStreamReader(System.in));
	    }

	    String next() {
	        while (st == null || !st.hasMoreElements()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }
	
	    int nextInt() {
	        return Integer.parseInt(next());
	    }
	
	    long nextLong() {
	        return Long.parseLong(next());
	    }
	
	    double nextDouble() {
	        return Double.parseDouble(next());
	    }
	
	    String nextLine(){
	        String str = "";
	        try {
	            str = br.readLine();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return str;
	    }
	}
}
