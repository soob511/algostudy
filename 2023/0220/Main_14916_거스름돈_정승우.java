import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_14916_거스름돈_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[2] = dp[5] = 1;
        dp[4] = 2;

        for(int i=6; i<=n; i++) {
            dp[i] = Math.min(dp[i-2],dp[i-5]) + 1;
        }

        System.out.println(dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}
