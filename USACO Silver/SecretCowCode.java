import java.io.*;
import java.util.*;
public class SecretCowCode {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("cowcode.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String str=st.nextToken();
		long index=Long.parseLong(st.nextToken());
		//System.out.println(recursive(str, index-1));
		pw.println(recursive(str, index-1));
		pw.close();
	}
	public static char recursive(String str, long index) {
		if(index<str.length()) { //once the index is finally less than the string length 
			return str.charAt((int) index);
		}
		long length=str.length();
		for(int i=0;i<Integer.MAX_VALUE;i++) { //multiply until length of the string reaches index
			if(length*2>index) {
				break;
			}
			length*=2;
		}
		if(length==index) { //return last character
			return recursive(str, index-1);
		}
		return recursive(str, index-length-1); //reduce the string
	}
}
