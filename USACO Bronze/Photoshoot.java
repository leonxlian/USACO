import java.io.*;
import java.util.*;
public class Photoshoot {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("photo.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int a[]=new int[n-1];
		for(int i=0;i<n-1;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}	
		for(int i=0;i<=a[0];i++) {//each possible first value
			int[] ans=new int[n];
			boolean ok=true;
			for(int j=0;j<n;j++) {//calculate the values
				if(j==0) {
				ans[0]=i;
				}else {
					ans[j]=a[j-1]-ans[j-1];
				}				
			}
			if(bruteforce(ans)==true) {
				ok=true;
			}else if(bruteforce(ans)==false) {
				ok=false;
			}			
			if(ok==false) {//if array is ok then print
				for(int j=0;j<n;j++) {
					if(j<n-1) {
					System.out.print(ans[j]);
					pw.print(ans[j]);
					System.out.print(" ");
					pw.print(" ");
					}else if(j==n-1) {
					pw.print(ans[j]);
					//System.out.print(ans[j]);
					}
				}
				break;
			}		
		}
		pw.close();
	}
	public static boolean bruteforce(int[] input) {//method
        for (int i = 0; i < input.length; i++) {
        	if(input[i]==0||input[i]<0) {
        		return true;
        	}
            for (int j = i+1; j < input.length; j++) {
                if (input[i]==(input[j]) && i != j) {
                    return true;
                }
            }
        }
        return false;
    }
}
