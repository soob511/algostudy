import java.util.Scanner;

public class Main_BJ_1309_동물원 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] dp = new int[N];
		
		dp[0]=3;
		if(N>=2) {
			dp[1]=7;
		}
		
		for(int i=2;i<N;i++) {
			dp[i]=(dp[i-2]*3+(dp[i-1]-dp[i-2])*2)%9901;
		}
		
		System.out.println(dp[N-1]%9901);
	}

}
