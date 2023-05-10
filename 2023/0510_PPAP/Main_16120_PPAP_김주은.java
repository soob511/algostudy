import java.io.*;
import java.util.*;

public class Main_BJ_16120_PPAP_김주은 {

	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		
		int p = 0;
		int a = 0;
		
		for(int i=0;i<s.length();i++) {
			
			char c = s.charAt(i);
			
			if(c=='A') {
				if(p<2 || a==1) {
					System.out.println("NP");
					return;
				} else if(p>=2){
					sb.append('A');
					a+=1;
				}
			}else {
				if(p>=2 && a==1) {
					sb.delete(a+p-2, a+p);
					p-=1;
					a-=1;
				} else {
					sb.append('P');
					p+=1;
				}
			}
			
		}
		
		if(a==0 && p==1) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}

}
