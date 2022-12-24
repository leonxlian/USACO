import java.io.*;
import java.util.*;
public class ConnectingTwoBarns {
    static int components[];
    static int num;
    static ArrayList<ArrayList<Integer>>connections;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int t=Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            st=new StringTokenizer(br.readLine());
            connections=new ArrayList<ArrayList<Integer>>();
            int n=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());
            for(int j=0;j<n;j++) {
                connections.add(new ArrayList<Integer>());
            }
            components=new int[n];
            num=0;
            for(int j=0;j<m;j++) {
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken())-1;
                int y=Integer.parseInt(st.nextToken())-1;
                connections.get(x).add(y);
                connections.get(y).add(x);
            }
            for(int j=0;j<n;j++) {
                if(components[j]!=0) {
                    continue;
                }
                num++;
                dfs(j);
            }
            if(components[0]==components[n-1]) {
                System.out.println(0);
                continue;
            }
            for(int j=0;j<components.length;j++) {
                components[j]--;
            }
            ArrayList<ArrayList<Integer>>aa=new ArrayList<ArrayList<Integer>>();
            for(int j=0;j<n;j++) {
                aa.add(new ArrayList<Integer>());
            }
            for(int j=0;j<n;j++) {
                aa.get(components[j]).add(j);//connect component to the point
            }//point j is in component j
            int first=0;
            int second=0;
            int firstcost[]=new int[n];
            int secondcost[]=new int[n];
            Arrays.fill(firstcost, Integer.MAX_VALUE);
            Arrays.fill(secondcost, Integer.MAX_VALUE);
            for(int j=0;j<n;j++) {//loop all points
                while(first<aa.get(components[0]).size()) {
                    firstcost[components[j]]=Math.min(firstcost[components[j]], Math.abs(j-aa.get(components[0]).get(first)));
                    if(aa.get(components[0]).get(first)<j) {
                        first++;
                    }else {
                        break;
                    }
                }
                if(first>0) {
                    first--;
                }
                while(second<aa.get(components[n-1]).size()) {
                    secondcost[components[j]]=Math.min(secondcost[components[j]], Math.abs(j-aa.get(components[n-1]).get(second)));
                    if(aa.get(components[n-1]).get(second)<j) {
                        second++;
                    }else {
                        break;
                    }
                }
                if(second>0) {
                    second--;
                }
            }
            long ans=Long.MAX_VALUE;
            for(int j=0;j<n;j++) {
                ans=Math.min(ans, (long)secondcost[j]*secondcost[j]+(long)firstcost[j]*firstcost[j]);
            }
            System.out.println(ans);
        }
    }
    static void dfs(int cur) {
        if(components[cur]!=0) {
            return;
        }
        components[cur]=num;
        for(int next:connections.get(cur)) {
            dfs(next);
        }
    }
}