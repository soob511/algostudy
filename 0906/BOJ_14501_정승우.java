

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14501_정승우 {
    private static int n, answer = 0;
    private static int[] T, P;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        T = new int[n];
        P = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int idx, int value) {
        //
        if (idx >= n) {
            answer = Math.max(answer, value);
            return;
        }

        // 오늘 상담 하는 경우
        if (idx + T[idx] <= n) {
            dfs(idx + T[idx], value + P[idx]);
        }
        else {
            dfs(idx + T[idx], value); // n을 넘어가면 value 합치지 않음
        }

        dfs(idx + 1, value); // 오늘 상담하지 않는 경우
    }

}
