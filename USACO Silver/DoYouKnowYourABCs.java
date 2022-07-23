import java.io.*;
import java.util.*;
public class DoYouKnowYourABCs{
    public static void main(String[] args) throws IOException {
    	PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        while(t-->0) {
        	st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int ans = 0;
            HashSet<Integer> hs = new HashSet<>();
            for (int i=0;i<arr.length;i++) {
                hs.add(arr[i]);
                for (int j=0;j<arr.length;j++) {
                    if (arr[i] < arr[j]) {
                        hs.add(arr[j] - arr[i]);
                    }
                }
            }
            for(int a:hs) {
            	for(int b:hs) {
            		for(int c:hs) {
            			if(a<=b&&c>=b) {
            				ArrayList<Integer> num=new ArrayList<Integer>();
            				num.add(a);num.add(b);num.add(c);
            				num.add(a+b);num.add(b+c);num.add(a+c);
            				num.add(a+b+c);
            				boolean ok=true;
            				for(int i=0;i<arr.length;i++) {
            					if(!num.contains(arr[i])) {
            						ok=false;
            					}
            				}
            				if(ok) {
            					ans++;
            				}
            			}
            		}
            	}
            }
            System.out.println(ans);
        }
    }
}