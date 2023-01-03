import java.io.*;
import java.util.*;

public class BOJ_7569_이길상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄 입력
        String[] line = br.readLine().split(" ");
        int M = Integer.parseInt(line[0]);
        int N = Integer.parseInt(line[1]);
        int H = Integer.parseInt(line[2]);

        // 토마토 배열
        int[][][] tomato = new int[H][N][M];
        // 주변 탐색 큐
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> temp;
        // 익지 않은 토마토 개수
        int motamo = 0;

        // 토마토 정보 입력
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                line = br.readLine().split(" ");
                for (int m = 0; m < M; m++) {
                    tomato[h][n][m] = Integer.parseInt(line[m]);
                    if(tomato[h][n][m] == 1) q.add(new int[]{h, n, m});
                    else if(tomato[h][n][m] == 0) motamo++;
                }
            }
        }

        // 계산
        int day = -1;
        int[] dh = {1,-1,0,0,0,0};
        int[] dn = {0,0,1,-1,0,0};
        int[] dm = {0,0,0,0,1,-1};
        while(!q.isEmpty()){
            // 사이클 계산을 위한 큐 분리
            temp = q;
            q = new LinkedList<>();

            // 토마토가 익는 과정
            day++;
            for (int[] p : temp) {
                // 주변 위치 탐색
                for (int i = 0; i < 6; i++) {
                    int h = p[0] + dh[i];
                    int n = p[1] + dn[i];
                    int m = p[2] + dm[i];
                    
                    // 인덱스 검사
                    if(h>=0 && n>=0 && m>=0 && h<H && n<N && m<M){
                        // 익지 않은 토마토일 경우 
                        if(tomato[h][n][m] == 0){
                            tomato[h][n][m] = 1;
                            motamo--;
                            q.add(new int[]{h, n, m});
                        }
                    }
                }
            }
        }

        // 출력
        if(motamo>0)System.out.println(-1);
        else System.out.println(day);
    }
}