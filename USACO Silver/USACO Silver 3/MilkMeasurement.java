import java.io.*;
import java.util.*;

public class MilkMeasurement {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int g=Integer.parseInt(st.nextToken());
		Entry[] e=new Entry[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int day=Integer.parseInt(st.nextToken());
			int cow=Integer.parseInt(st.nextToken());
			int milk=Integer.parseInt(st.nextToken());
			e[i]=(new Entry(day, cow, milk));
		}
		Arrays.sort(e);
		HashMap<Integer, Integer>cow=new HashMap<>(); //id, val
		HashSet<Integer>max=new HashSet<>();
		for(int i=0;i<n;i++) {
			cow.put(e[i].cow, g);
		}
		for(int i=0;i<n;i++) {
			max.add(e[i].cow);
		}
		int maxVal=g;
		int ans=0;
		for(int i=0;i<n;i++) {
			cow.put(e[i].cow, cow.get(e[i].cow)+e[i].milk);
			if(cow.get(e[i].cow)>maxVal) {
				if(max.size()==1&&max.contains(e[i].cow)) {
					maxVal=cow.get(e[i].cow);
					continue;
				}else{
					ans++;
					max.clear();
					maxVal=cow.get(e[i].cow);
					max.add(e[i].cow);
				}
			}else if(cow.get(e[i].cow)<maxVal) {
				if(max.contains(e[i].cow)) {
					if(max.size()>1) {
						max.remove(e[i].cow);
						ans++;
					}else if(max.size()==1){
						max.clear();
						int nextMax=0;
						for(int k:cow.keySet()) {
							nextMax=Math.max(nextMax, cow.get(k));
						}
						for(int k:cow.keySet()) {
							if(cow.get(k)==nextMax) {
								max.add(k);
							}
						}
						maxVal=nextMax;
						ans++;
						if(max.contains(e[i].cow)&&max.size()==1){
							ans--;
						}
					}
				}else if(!max.contains(e[i].cow)) {
					continue;
				}
			}else if(cow.get(e[i].cow)==maxVal) {
				ans++;
				max.add(e[i].cow);
			}
		}
		if(cow.size()==1) {
			ans=1;
		}
		System.out.println(ans);
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
			return this.day.compareTo(o.day);
		}
	}
}
