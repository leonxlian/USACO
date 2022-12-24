import java.io.*;
import java.util.*;
public class MilkMeasurement{
	public static PrintWriter out;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		out=new PrintWriter(System.out);
		int n=Integer.parseInt(st.nextToken());
		int g=Integer.parseInt(st.nextToken());
		Entry cow[]=new Entry[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int d=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			cow[i]=new Entry(d, c, m);
		}
		Arrays.sort(cow);
		HashMap<Integer, Integer>tm=new HashMap<>();
		HashSet<Integer>hs=new HashSet<>();
		int max=g;
		for(int i=0;i<n;i++) {
			hs.add(cow[i].cow);
		}
		for(int i=0;i<n;i++) {
			tm.put(cow[i].cow, g);
		}
		int ans=0;
		for(int i=0;i<n;i++) {
			tm.put(cow[i].cow, tm.get(cow[i].cow)+cow[i].milk);
			if(tm.get(cow[i].cow)>max) {
				if(hs.size()==1&&hs.contains(cow[i].cow)) {
					max=tm.get(cow[i].cow);
					continue;
				}else{
					ans++;
					hs.clear();
					max=tm.get(cow[i].cow);
					hs.add(cow[i].cow);
				}
			}else if(tm.get(cow[i].cow)==max) {
				hs.add(cow[i].cow);
				ans++;
			}else {
				if(!hs.contains(cow[i].cow)) {
					continue;
				}
				if(hs.size()==1) {
					hs.clear();
					int temp=0;
					for(int key:tm.keySet()) {
						temp=Math.max(temp, tm.get(key));
					}
					for(int key:tm.keySet()) {
						if(tm.get(key)==temp) {
							hs.add(key);
						}
					}
					ans++;
					if(hs.contains(cow[i].cow)&&hs.size()==1) {
						ans--;
					}
					max=temp;
				}else {
					hs.remove(cow[i].cow);
					ans++;
				}
			}
		}
		if(tm.size()==1) {
			ans=1;
		}
		//out.println(ans);
		//out.close();
		pw.println(ans);
		pw.close();
	}
	static class Entry implements Comparable<Entry>{
		Integer day;
		Integer cow; 
		Integer milk;
		public Entry(int day, int cow, int milk) {
			this.day=day;this.cow=cow;this.milk=milk;
		}
		public int compareTo(Entry o) {
			return day-o.day;
		}
	}
}
