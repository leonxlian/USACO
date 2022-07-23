import java.io.*;
import java.util.*;
public class Meetings {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("meetings.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("meetings.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int l=Integer.parseInt(st.nextToken());
		Cow[] cows=new Cow[n];
		int totalWeight=0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			int d=Integer.parseInt(st.nextToken());
			cows[i]=new Cow(w, x, d);
			totalWeight+=w;
		}
		Arrays.sort(cows);
		ArrayList<Cow>left=new ArrayList<>();
		ArrayList<Cow>right=new ArrayList<>();
		for(int i=0;i<n;i++) {
			if(cows[i].d==-1) {
				left.add(cows[i]);
			}else{
				right.add(cows[i]);
			}
		}
		TimeToBarn[] times = new TimeToBarn[n];
		for(int i = 0; i < right.size(); i++) {
            times[i] = new TimeToBarn(l-right.get(right.size()-1-i).pos, cows[n-1-i].weight);
        }
		for(int i = 0; i < left.size(); i++) {
            times[i+right.size()] = new TimeToBarn(left.get(i).pos, cows[i].weight);
        }
		Arrays.sort(times);
		for(int i=0;i<n;i++) {
			System.out.println(times[i].time+" "+times[i].weight);
		}
		int time = 0;
        int curWeight = 0;
        for(int i = 0; i < n; i++) {
            curWeight += times[i].weight;
            if(curWeight*2 >= totalWeight) {
                time = times[i].time;
                break;
            }
        }
        Queue<Integer> collisionCandidates = new LinkedList<>();
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(cows[i].d == 1) {
                collisionCandidates.add(cows[i].pos);
            } else {
                while(collisionCandidates.size() > 0 && cows[i].pos-collisionCandidates.peek() > 2*time) {
                    collisionCandidates.poll();
                }
                ans += collisionCandidates.size();
            }
        }
        //System.out.println(ans);
        pw.println(ans);
        pw.close();
	}
	static class TimeToBarn implements Comparable<TimeToBarn> {
        int time, weight;
        public TimeToBarn(int time, int weight) {
            this.time = time;
            this.weight = weight;
        }
        public int compareTo(TimeToBarn o) {
            return time-o.time;
        }

    }
	static class Cow implements Comparable<Cow>{
		int weight, pos, d;
		public Cow(int weight, int pos, int d) {
			this.weight=weight;this.pos=pos;this.d=d;
		}
		public int compareTo(Cow o) {
			return pos-o.pos;
		}
	}
}
