import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865_정승우 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];
        int[] w = new int[N+1];
        int[] v = new int[N+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=K; j++) {
                //이전의 값을 저장
                dp[i][j] = dp[i-1][j];
                //담을수 있는 무게에서 자신의 무게를 빼서 남는 무게가 있다면
                if(j - w[i]>=0) {
                    //이전에 구한 가치와 자신의 무게를 뺐을때 담을수 있는 가치와 자신의 가치를 더해서 더 큰값으로 dp[i[j] 값을 초기화
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]);
                }
            }
        }


        System.out.println(dp[N][K]);
    }

}
