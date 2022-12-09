import java.util.Scanner;

public class Main_BJ_12904_A와B_김주은 {
	
	static String S,T;
	static int sl,tl;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		String T = sc.next();
		
		int sl = S.length();
		int tl = T.length();
		
		for(int t=tl;t>sl;t--) {
			if(T.charAt(t-1)=='A') {
				T = T.substring(0, t-1);
			} else if(T.charAt(t-1)=='B') {
				T = T.substring(0, t-1);
				String reverse_T = "";
				for(int i=T.length()-1;i>=0;i--) {
					reverse_T += T.charAt(i);
				}
				T = reverse_T;
			}
		}

		if(T.equals(S)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	
	}

}
