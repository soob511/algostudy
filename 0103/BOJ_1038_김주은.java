import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_BJ_1038_감소하는수_김주은 {
	
	static int N;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		if(N<=10) {
			System.out.println(N);
		} else if(N>=1023) {
			System.out.println(-1);
		} else {
			int digit = 1;
			while(digit<=10) {
				for(int i=digit-1;i<10;i++) {
					search(digit,i+"",0);
				}
				digit++;
			}
		}
	}

	private static void search(int digit, String s,int idx) {
		
		if(s.length()==digit) {
			--N;
			if(N<0) {
				System.out.println(s);
				System.exit(0);
			}
			return;
		}
		
		for(int i=0;i<10;i++) {
			if(s.charAt(idx)-'0'>i) {
				search(digit,s+i,idx+1);
			}
		}
	}

}
