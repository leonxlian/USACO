import java.io.*;
import java.util.*;
public class SocialDistancing2 {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("socdist2.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("socdist2.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int cowIndicies[]=new int[n];
		int sick[]=new int[n];
		int copy[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			cowIndicies[i]=Integer.parseInt(st.nextToken());
			sick[i]=Integer.parseInt(st.nextToken());
			copy[i]=cowIndicies[i];
		}
		Arrays.sort(copy);
		int difference=0;
		int mindif=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {//loop through all lines
			if(sick[i]==0) {//if it is healthy
				for(int j=0;j<n;j++) {//loop through lines
						if(sick[j]==1) {
							difference=Math.abs(cowIndicies[i]-cowIndicies[j]);
							if(difference!=0) {
							mindif=Math.min(difference, mindif);
							}
						}
				}
			}
		}
		int ans=1;
		mindif-=1;
		for(int i=1;i<n;i++) {
            boolean ok=false;
            for(int j=1;j<n;j++) {
                if(cowIndicies[j]==copy[i]&&sick[j]==1) {
                    ok=true;
                    break;
                }
            }
            if(ok==true) {
                if(copy[i]-copy[i-1]>mindif) {
                    ans++;
                }
            }
        }
		
		System.out.println(ans);
		//pw.println(ans);
		//pw.close();
	}
}
/*
20
49 1
26 0
79 0
57 1
224 0
195 1
10 1
84 0
141 1
27 0
161 1
157 1
103 1
204 1
186 1
130 1
169 1
115 1
217 0
133 1
*/

