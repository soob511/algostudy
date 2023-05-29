import java.util.Scanner;

public class Main_BJ_1747_소수앤팰린드롬_김주은 {

	public static void main(String[] args) throws Exception{
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N==1) {
			N+=1;
		}
		
		while(true) {
			if(isPrime(N) && isPalendrome(N)) {
				System.out.println(N);
				return;
			}
			++N;
		}
	}

	private static boolean isPalendrome(int n) {
		String s = ""+n;
		int len = s.length();
		int half_len = len/2;
		
		for(int i=0;i<=half_len;i++) {
			if(s.charAt(i)!=s.charAt(len-1-i)) {
				return false;
			}
		}
		return true;
		
	}

	private static boolean isPrime(int n) {
		for(int i=2;i*i<=n;i++) {
			if(n%i==0) {
				return false;
			}
		}
		return true;
	}
	
}
