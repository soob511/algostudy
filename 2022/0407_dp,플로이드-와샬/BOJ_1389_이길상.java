import java.io.*;
import java.util.*;

public class BOJ_1389_이길상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        // 인접 행렬 초기화
        int[][] adj = new int[N][N];
        for (int n = 0; n < N; n++) {
            Arrays.fill(adj[n], 100000000);
        }

        // 간선 입력
        for (int m = 0; m < M; m++) {
            line = br.readLine().split(" ");
            int i = Integer.parseInt(line[0]) - 1;
            int j = Integer.parseInt(line[1]) - 1;
            adj[i][j] = adj[j][i] = 1;
        }

        // 플로이드 와샬
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(adj[i][j] > adj[i][k] + adj[k][j]){
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }

        // 최소값과 그 인덱스
        int num = -1;
        int min = 100000000;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if(i != j) sum+=adj[i][j];
            }
            if(sum < min){
                min = sum;
                num = i;
            }
        }

        // 출력
        System.out.println(num + 1);
        
    }
}
