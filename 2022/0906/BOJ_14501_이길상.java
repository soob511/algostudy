import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 날짜 입력
        int N = Integer.parseInt(br.readLine());

        // 배열
        int[] dp = new int[N + 1];

        // 상담 정보 입력
        int[][] info = new int[N][2];
        for (int n = 0; n < N; n++) {
            String[] line = br.readLine().split(" ");
            info[n][0] = Integer.parseInt(line[0]);
            info[n][1] = Integer.parseInt(line[1]);
        }

        for (int i = N-1; i >= 0; i--) {
            if (i + info[i][0] > N)
                dp[i] = dp[i+1];
            else
                dp[i] = Math.max(info[i][1] + dp[i + info[i][0]], dp[i+1]);
        }

        System.out.println(dp[0]);
    }
}
