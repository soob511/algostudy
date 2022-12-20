import java.util.Scanner;

public class Main_BJ_11722_가장긴감소하는부분수열_김주은 {

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] dp = new int[N];
		
		int ans=1;
		
		for(int i=0;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[j]>arr[i] && dp[i]<=dp[j]) {
					dp[i]=dp[j]+1;
				}
			}
			
			if(ans<dp[i]) {
				ans = dp[i];
			}
		}
		
		System.out.println(ans);
	}

}
