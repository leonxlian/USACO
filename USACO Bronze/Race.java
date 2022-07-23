import java.io.*;
import java.util.*;
public class Race {
	public static void main(String[] args) throws IOException{
		//BufferedReader br=new BufferedReader(new FileReader("race.in"));
		//PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("race.out")));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int k=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		for(int i = 0; i < n; i++) {
			st=new StringTokenizer(br.readLine());
            int finishSpeed = Integer.parseInt(st.nextToken());
            int ans = 0;
            int speed = 1;
            int travelDistance = 0;
            while (true) {
                ans++;
                travelDistance += speed;
                if(travelDistance >= k) {
                    break;
                }
                if(speed >= finishSpeed) {
                    travelDistance += speed;
                    ans++;
                    if(travelDistance >= k) {
                        break;
                    }
                }
                speed++;
            }
            System.out.println(ans);
            //pw.println(ans);
        }
        //pw.close();
    }
}
