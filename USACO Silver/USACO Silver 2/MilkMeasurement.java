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
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			e[i]=new Entry(a, b, c);
		}
		Arrays.sort(e);
		HashMap<Integer, Integer> cow=new HashMap<>();
		HashSet<Integer> max=new HashSet<>(); //store max indices
		for(int i=0;i<n;i++) {
			cow.put(e[i].cow, g);
		}
		for(int i=0;i<n;i++) {
			max.add(e[i].cow);
		}
		int ans=0;
		int maxValue=g;
		for(int i=0;i<n;i++) {
			cow.put(e[i].cow, cow.get(e[i].cow)+e[i].milk);
			if(cow.get(e[i].cow)>maxValue) {
				boolean flag=true;
				if(max.contains(e[i].cow)&&max.size()==1) {
					flag=true;
				}else {
					flag=false;
				}
				max.clear();
				max.add(e[i].cow);
				ans++;
				maxValue=cow.get(e[i].cow);
				if(max.size()==1) {
					if(max.contains(e[i].cow)&&flag==true) {
						ans--;
					}
				}
			}else if(cow.get(e[i].cow)<maxValue) {
				if(max.contains(e[i].cow)) {
					if(max.size()>1) {
						max.remove(e[i].cow);
						ans++;
					}else if(max.size()==1) {
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
