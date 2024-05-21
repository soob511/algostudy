import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_12852_1로만들기2_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+2];
        int[] arr = new int[N+2];

        dp[1] = 0;
        arr[1] = -1;

        for(int i=2; i<=N; i++) {
            dp[i] = dp[i-1]+1;
            arr[i] = i-1;

            if(i%2==0 && dp[i] > dp[i/2]+1) {
                dp[i] = dp[i/2]+1;
                arr[i] = i/2;
            }

            if(i%3==0 && dp[i] > dp[i/3]+1) {
                dp[i] = dp[i/3]+1;
                arr[i] = i/3;
            }
        }

        int num = dp[N];
        int idx = N;
        System.out.println(num);

        for(int i=0; i<=num; i++) {
            System.out.print(idx+" ");
            idx = arr[idx];
        }
    }
}
