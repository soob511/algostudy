import java.util.Scanner;

public class Main_BJ_17427_약수의합2_김주은 {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		long ans = 0;
		for(long i=1;i<=N;i++) {
			ans += i*(N/i);
		}
		
		System.out.println(ans);
	}

}
