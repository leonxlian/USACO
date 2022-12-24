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
		Entry e[]=new Entry[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int day=Integer.parseInt(st.nextToken());
			int cow=Integer.parseInt(st.nextToken());
			int milk=Integer.parseInt(st.nextToken());
			e[i]=new Entry(day, cow, milk);
		}
		Arrays.sort(e);
		HashMap<Integer, Integer> cow=new HashMap<>();// cow id, milk value
		HashSet<Integer> max=new HashSet<>(); //cow id for poster on the board
		for(int i=0;i<n;i++) {
			cow.put(e[i].cow, g);
		}
		for(int i=0;i<cow.size();i++) {//set from cow id 1 to highest cow id 
			max.add(e[i].cow);
		}
		//loop through all of measurements
		int maxValue=g;
		int ans=0;
		for(int i=0;i<n;i++) {
			cow.put(e[i].cow, cow.get(e[i].cow)+e[i].milk);
			if(cow.get(e[i].cow)>maxValue){//if the cow is higher than the current
				boolean ok=true;
				if(max.contains(e[i].cow)&&max.size()==1) {
					ok=true;
				}else {
					ok=false;
				}
				max.clear();			
				max.add(e[i].cow);
				ans++;
				maxValue=cow.get(e[i].cow);
				if(max.size()==1) {
					if(max.contains(e[i].cow)&&ok==true) {
						ans--;
					}			
				}
			}else if(cow.get(e[i].cow)<maxValue) {//if cow is less than current
				if(max.contains(e[i].cow)) {//if it's on the board already
					if(max.size()>1) {//if it's on the board and there are more than one poster
						max.remove(e[i].cow);
						ans++;
					}else if(max.size()==1) {//if it's on the board and there are no more
						max.remove(e[i].cow);
						int nextmax=Integer.MIN_VALUE;
						for(int j : cow.keySet()) {
							  nextmax = Math.max(nextmax, cow.get(j));
						}
						for(int j:cow.keySet()) {
							if(cow.get(j)==nextmax) {
							max.add(j);
							}
						}
						maxValue=nextmax;
						if(!max.contains(e[i].cow)||max.size()!=1) {
							ans++;
						}
						
					}
				}else if(!max.contains(e[i].cow)){//if it's not on the board
					continue;
				}
			}else if(cow.get(e[i].cow)==maxValue) {//if it's equal
				max.add(e[i].cow);
				ans++;
			}
		}
		if(cow.size()==1) {
			ans=1;
		}
		//System.out.println(ans);
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
