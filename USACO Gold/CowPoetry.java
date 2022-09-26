import java.io.*;
import java.util.*;
public class CowPoetry {
	public static PrintWriter out;
	static ArrayList<ArrayList<Integer>>al;
	static int max=5001;
	static int n, m, k;
	static int mod=(int) (1e9+7);
	static long dp[];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("poetry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("poetry.out")));
	    //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n=Integer.parseInt(st.nextToken());
	    m=Integer.parseInt(st.nextToken());
	    k=Integer.parseInt(st.nextToken());
	    al=new ArrayList<>();
	    for(int i=0;i<5001;i++) {
	    	al.add(new ArrayList<Integer>());
	    }
	    ArrayList<Integer>words=new ArrayList<>();
	    for(int i=0;i<n;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int x=Integer.parseInt(st.nextToken());
	    	int y=Integer.parseInt(st.nextToken())-1;
	    	al.get(y).add(x);
	    	words.add(x);
	    }
	    HashMap<Integer, Integer>hm=new HashMap<>();
	    for(int i=0;i<m;i++) {
	    	st=new StringTokenizer(br.readLine());
	    	int ch=st.nextToken().charAt(0)-'A';
	    	hm.put(ch, hm.getOrDefault(ch, 0)+1);
	    }
	    ArrayList<Long>aa=new ArrayList<>();
	    dp=new long[k];
	    dp[0]=1;
	    for(int i=0;i<k;i++) {
	    	for(int word:words) {
	    		if(dp[i]!=0&&i+word<k) {
	    			dp[i+word]+=dp[i];
	    			dp[i+word]%=mod;
	    		}
	    	}
	    }
	    for(int i=0;i<5001;i++) {
	    	long num=calculate(i);
	    	if(num>0) {
	    		aa.add(num);
	    	}
	    }
	    // 31 32 41     31 31 41    32 31 41  32 32 41
	    // 31 41 31     32 41  31    41 31    41 32
	    long ans=1;
	    for(int key:hm.keySet()) {
	    	long temp=0;
	    	for(long i:aa) {
	    		temp+=power(i, hm.get(key), mod);
	    		temp%=mod;
	    	}
	    	ans*=temp;
	    	ans%=mod;
	    }
	    out.println(ans);
	    pw.println(ans);
	    pw.close();
	    //out.close();
	}
	static long calculate(int scheme) {
		if(al.get(scheme).size()==0) {
			return 0;
		}
		long ret=0;
		for(int words:al.get(scheme)) {
			ret+=dp[k-words];
			ret%=mod;
		}
		return ret;
	}
	public static long power(long a, long b, int mod) {
		long res=1;
		while(b!=0) {
			if(b%2==1) {
				res=(res*a)%mod;
			}
			a=(a*a)%mod;
			b/=2;
		}
		return res;
	}
}
