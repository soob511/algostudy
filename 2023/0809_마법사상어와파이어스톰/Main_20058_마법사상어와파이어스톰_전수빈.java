package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_20058_마법사상어와파이어스톰 {
    static int N, Q, M;
    static int[][] map, map2;
    static int num;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = (int) Math.pow(2, N);
        map = new int[M][M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (Q-- > 0) {
            int L = Integer.parseInt(st.nextToken());
            num = (int) Math.pow(2, L);
            map2 = new int[M][M];

            //회전
            for (int i = 0; i < M; i += num) {
                for (int j = 0; j < M; j += num) {
                    rotate(i, j);
                }
            }
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    map[i][j] = map2[i][j];
                }
            }

            //얼음의 양 줄어듬
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    int count = 0;
                    if(map[i][j]>0){
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if (nx < 0 || ny < 0 || nx >= M || ny >= M || map2[nx][ny] == 0) continue;
                            count++;
                        }
                        if (count < 3) {
                            map[i][j] -= 1;
                        }
                    }
                }
            }
        }
        //남아있는 얼음의 합
        int sum = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);

        //가장큰 덩어디가 차지하는 칸의 갯수
        int max = 0;
        boolean[][] visit = new boolean[M][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0 && !visit[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                    int count = 1;
                    while (!q.isEmpty()) {
                        int[] p = q.poll();
                        int x = p[0];
                        int y = p[1];
                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];
                            if (nx < 0 || ny < 0 || nx >= M || ny >= M || map[nx][ny] == 0 || visit[nx][ny]) continue;
                            q.add(new int[]{nx, ny});
                            visit[nx][ny] = true;
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(max);

    }

    private static void rotate(int s, int e) {
        for (int i = 0; i <num; i++) {
            for (int j = 0; j <num; j++) {
                map2[s+i][e+j] = map[s+num-j-1][e+i];
            }
        }
    }
}
