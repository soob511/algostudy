import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class BOJ_12865_정승우 {

    static Integer[][] dp;
    static int[] W; // 무게
    static int[] V; // 가치

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];

        dp = new Integer[N][K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapsack(N - 1, K));

    }

    static int knapsack(int i, int k) {
        
        if (i < 0)
            return 0;

        // 탐색하지 않은 곳
        if (dp[i][k] == null) {

            // 현재 물건을 추가로 못담는 경우
            if(W[i] > k) {
                dp[i][k] = knapsack(i - 1, k);
            }
            // 현재 물건을 담을 수 있는 경우
            else {
                // 이전 i값과 비교하여 큰 값을 저장
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - W[i]) + V[i]);
            }
        }
        return dp[i][k];
    }


}
