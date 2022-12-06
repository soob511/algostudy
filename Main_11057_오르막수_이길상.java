import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // DP[i][j] -> 길이 i이고 j로 끝나는 오르막 수 
        int[][] DP = new int[N+1][10];

        for(int i = 0; i<10; i++){
            DP[1][i] = 1;
        }

        // 모든 오르막수는 자신보다 길이가 1 짧고 끝 수가 자신 이하인 오르막수 만큼의 개수를 가진다.
        for(int i = 2; i<=N; i++){
            for(int j = 0; j<10; j++){
                for(int k = 0; k<=j; k++){
                    DP[i][j] += DP[i-1][k];
                    DP[i][j] %= 10007;
                }
            }
        }

        // 길이가 N인 모든 오르막 수 더하기
        int answer = 0;
        for(int i = 0; i<10; i++){
            answer += DP[N][i];
            answer %= 10007;
        }
        System.out.println(answer);
    }
}
