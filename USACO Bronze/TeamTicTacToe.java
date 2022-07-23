import java.io.*;
import java.util.*;
public class TeamTicTacToe {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader("tttt.in"));
		PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("tttt.out")));
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		char a[][]=new char[3][3];
		for(int i=0;i<3;i++) {
			a[i]=br.readLine().toCharArray();
		}
		int icount=0; //individual count
		char iarray[]=new char[8];
		for(int i=0;i<8;i++) {
			iarray[i]='0';
		}
		int j=0;
		for(int i=0;i<3;i++) {
			if((a[i][0]==a[i][1])&&(a[i][0]==a[i][2])){
				iarray[j]=a[i][0];
				}
			j++;
			if((a[0][i]==a[1][i])&&(a[1][i]==a[2][i])) {
				iarray[j]=a[0][i];
			}
			j++;
		}
		if((a[0][0]==a[1][1])&&(a[1][1]==a[2][2])){
			iarray[j]=a[0][0];
		}
		j++;
		if((a[2][0]==a[1][1])&&(a[1][1]==a[0][2])) {
			iarray[j]=a[0][2];
		}
		int aletter[]=new int[26];
		for(int i=0;i<8;i++) {
			for(int k=0;k<26;k++) {
				char c='A';
				c=(char)(c+k);
				if(iarray[i]==c) {
					aletter[k]++;
				}
			}
		}
		for(int i=0;i<26;i++) {
			if(aletter[i]>=1) {
				aletter[i]=1;
			}
		}
		for(int i=0;i<26;i++) {
			if(aletter[i]==1) {
				icount++;
			}
		}
		
		j=0;
		int tcount=0; //team count
		char tarray[]=new char[8];
		for(int i=0;i<8;i++) {
			tarray[i]='0';
		}
		for(int i=0;i<3;i++) {
			if((a[i][0]==a[i][1])&&(a[i][0]!=a[i][2])){
				tarray[j]=a[i][0];
			}else if((a[i][0]==a[i][2])&&(a[i][0]!=a[i][1])){
				tarray[j]=a[i][0];
			}else if((a[i][1]==a[i][2])&&(a[i][1]!=a[i][0])){
				tarray[j]=a[i][1];
			}			
			j++;
			if((a[0][i]==a[1][i])&&(a[1][i]!=a[2][i])) {
				tarray[j]=a[0][i];
			}else if((a[0][i]==a[2][i])&&(a[0][i]!=a[1][i])){
				tarray[j]=a[0][i];
			}else if((a[1][i]==a[2][i])&&(a[1][i]!=a[0][i])){
				tarray[j]=a[1][i];
			}
			j++;
		}
		if((a[0][0]==a[1][1])&&(a[1][1]!=a[2][2])){
			tarray[j]=a[0][0];
		}else if((a[0][0]==a[2][2])&&(a[0][0]!=a[1][1])) {
			tarray[j]=a[0][0];
		}else if((a[1][1]==a[2][2])&&(a[1][1]!=a[0][0])) {
			tarray[j]=a[2][2];
		}
		j++;
		if((a[2][0]==a[1][1])&&(a[1][1]!=a[0][2])){
			tarray[j]=a[1][1];
		}else if((a[0][2]==a[1][1])&&(a[0][2]!=a[2][0])) {
			tarray[j]=a[1][1];
		}else if((a[0][2]==a[2][0])&&(a[0][2]!=a[1][1])) {
			tarray[j]=a[2][0];
		}
		int tletter[]=new int[26];
		for(int i=0;i<8;i++) {
			for(int k=0;k<26;k++) {
				char c='A';
				c=(char)(c+k);
				if(tarray[i]==c) {
					tletter[k]++;
				}
			}
		}
		for(int i=0;i<26;i++) {
			if(tletter[i]>=1) {
				tletter[i]=1;
			}
		}
		for(int i=0;i<26;i++) {
			if(tletter[i]==1) {
				tcount++;
			}
		}
		if((a[0][0]=='A')&&(a[0][2]=='A')) {
			tcount--;
		}
		//System.out.println(icount);
		//System.out.println(tcount);
		pw.println(icount);
		pw.println(tcount);
		pw.close();
	}
}
/*		0 1 2
	  0	C O W    
	  1	X X O
	  2	A B C
*/




