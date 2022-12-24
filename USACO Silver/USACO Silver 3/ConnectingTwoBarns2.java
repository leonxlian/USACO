import java.io.*;
import java.util.*;
public class ConnectingTwoBarns2 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        while(t-->0) {
        	st=new StringTokenizer(br.readLine());
        	int n=Integer.parseInt(st.nextToken());
        	int m=Integer.parseInt(st.nextToken());
        	DSU dsu=new DSU(n);
        	for(int i=0;i<m;i++) {
	        	st=new StringTokenizer(br.readLine());
	        	int a=Integer.parseInt(st.nextToken())-1;
	        	int b=Integer.parseInt(st.nextToken())-1;
	        	dsu.union(a, b);
        	}
        	long ans=Long.MAX_VALUE;
        	int zerohead=dsu.find(0);
        	int lasthead=dsu.find(n-1);
        	TreeSet<Long>zero=new TreeSet<>();
        	TreeSet<Long>last=new TreeSet<>();
        	for(int i=0;i<n;i++) {
        		int curhead=dsu.find(i);
        		if(curhead==zerohead) {
        			zero.add((long)i);
        		}
        		if(curhead==lasthead) {
        			last.add((long)i);
        		}
        	}
        	Iterator<Long> it=zero.iterator();
            while(it.hasNext()) {
                long next=it.next();
                Long higher=last.ceiling(next);
                Long lower=last.floor(next);
                
                ans=Math.min(ans,distance(higher,next));
                ans=Math.min(ans,distance(lower,next));
            }
            long[] first=new long[n];
            long[] second=new long[n];
            for(int i=0;i<n;i++) {
            	int curhead=dsu.find(i);
            	if(curhead==zerohead||curhead==lasthead) {
            		continue;
            	}
            	Long ans1=Long.MAX_VALUE;
            	Long ans2=Long.MAX_VALUE;
            	
            	ans1=Math.min(ans1, distance(zero.floor((long) i), (long)i));//from the beginning component
            	ans1=Math.min(ans1, distance(zero.ceiling((long) i), (long)i));
            	
            	if(first[curhead]==0) {
            		first[curhead]=Long.MAX_VALUE;
            	}
            	first[curhead]=Math.min(first[curhead], ans1);
            	
            	ans2=Math.min(ans2, distance(last.floor((long) i), (long)i));//from the end component
            	ans2=Math.min(ans2, distance(last.ceiling((long) i), (long)i));
            	
            	if(second[curhead]==0) {
            		second[curhead]=Long.MAX_VALUE;
            	}
            	second[curhead]=Math.min(second[curhead], ans2);
            	ans=Math.min(ans, second[curhead]+first[curhead]);
            }
            System.out.println(ans);
        }
	}
	static long distance(Long i, Long next){
		if(i==null||next==null) {
			return Long.MAX_VALUE;
		}
		return (i-next)*(i-next);
	}
	static class DSU {
		int[] parents;
		int[] rank;
		public DSU(int size) { //constructor
			rank = new int[size];
			parents = new int[size];
			for(int i=0;i<parents.length;i++) {
				parents[i]=i;
			}
		}
		public int find(int x) {
			if(parents[x]==x) {
				return x;
			}
			return parents[x]=find(parents[x]);
		}
		public void union(int x, int y) {
			int rootX=find(x);
			int rootY=find(y);
			if(rootX==rootY) {
				return;
			}
			if(rank[rootX]>rank[rootY]) {
				parents[rootY]=rootX;//rootx stays as parent
			}else {
				parents[rootX]=rootY;
				if(rank[rootX]==rank[rootY]) { //if rank is equal update rank
					rank[rootY]++;
				}
			}
		}
	}
}

