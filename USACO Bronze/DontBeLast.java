import java.io.*;
import java.util.*;
public class DontBeLast {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("notlast.out")));
		//BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		String a[]=new String[n];
		int b[]=new int[n];
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			a[i]=st.nextToken();
			b[i]=Integer.parseInt(st.nextToken());
		}	
		int bc=0;
		int ec=0;
		int ac=0;
		int gc=0;
		int hc=0;
		int mc=0;
		int dc=0;
		for(int i=0;i<n;i++) {
			if(a[i].equals("Annabelle")) {
				ac+=b[i];
		    }else if(a[i].equals("Bessie")) {
		    	bc+=b[i];
		    }else if(a[i].equals("Daisy")){
		    	dc+=b[i];
		    }else if(a[i].equals("Elsie")) {
		    	ec+=b[i];
		    }else if(a[i].equals("Gertie")) {
		    	gc+=b[i];
		    }else if(a[i].equals("Henrietta")) {
		    	hc+=b[i];
		    }else if(a[i].equals("Maggie")) {
		    	mc+=b[i];
		    }					
		}
		int c=0;
		for(int i=0;i<1000000;i++) {
			c=i;
			if(ac==i) {
				break;
		    }else if(bc==i){
		    	break;
		    }else if(dc==i){
		    	break;
		    }else if(ec==i) {
		    	break;
		    }else if(gc==i) {
		    	break;
		    }else if(hc==i) {
		    	break;
		    }else if(mc==i) {
		    	break;
		    }	
		}
		int ans=0;
		String winner="";
		for(int i=c+1;i<1000000;i++) {
			ans=i;
			if(ac==i) {
				break;
		    }else if(bc==i){
		    	break;
		    }else if(dc==i){
		    	break;
		    }else if(ec==i) {
		    	break;
		    }else if(gc==i) {
		    	break;
		    }else if(hc==i) {
		    	break;
		    }else if(mc==i) {
		    	break;
		    }
		}
		int winner1=0;
		if(ac==ans) {
			winner1=ac;
			winner="Annabelle";
	    }else if(bc==ans){
	    	winner1=bc;
	    	winner="Bessie";
	    }else if(dc==ans){
	    	winner1=dc;
	    	winner="Daisy";
	    }else if(ec==ans) {
	    	winner1=ec;
	    	winner="Elsie";
	    }else if(gc==ans) {
	    	winner1=gc;
	    	winner="Gertie";
	    }else if(hc==ans) {
	    	winner1=hc;
	    	winner="Henrietta";
	    }else if(mc==ans) {
	    	winner1=mc;
	    	winner="Maggie";
	    }
	    if((winner1==ac)&&(!winner.equals("Annabelle"))){
	    	winner="Tie";
	    }else if((winner1==bc)&&(!winner.equals("Bessie"))){
	    	winner="Tie";
	    }else if((winner1==dc)&&(!winner.equals("Daisy"))){
	    	winner="Tie";
	    }else if((winner1==ec)&&(!winner.equals("Elsie"))){
	    	winner="Tie";
	    }else if((winner1==gc)&&(!winner.equals("Gertie"))){
	    	winner="Tie";
	    }else if((winner1==hc)&&(!winner.equals("Henrietta"))){
	    	winner="Tie";
	    }else if((winner1==mc)&&(!winner.equals("Maggie"))){
	    	winner="Tie";
	    }else if((ac==bc)&&(ac==dc)&&(ac==ec)&&(ac==gc)&&(ac==hc)&&(ac==mc)) {
	    	winner="Tie";
	    }
		//System.out.println(winner);
		pw.println(winner);
		//System.out.println();
		pw.close();
	}
}
