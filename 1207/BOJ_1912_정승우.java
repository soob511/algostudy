import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1912_정승우 {
    static int n;
    static int dp[], cost[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        cost = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = cost[1];
        for(int i=2; i<=n; i++) {
            dp[i] = Math.max(dp[i-1]+cost[i], cost[i]);
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            if(dp[i] > max) {
                max = dp[i];
            }
        }

        System.out.println(max);
    }
}
