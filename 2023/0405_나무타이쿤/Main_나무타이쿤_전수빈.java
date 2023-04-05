package Samsung;

import java.util.*;
import java.io.*;

public class Main_나무타이쿤 {
    static int n, m;
    static int[][] map;
    static int d, p;
    static boolean[][] visit;
    static boolean[][] special;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visit = new boolean[n][n];
        visit[n - 1][0] = true;
        visit[n - 2][0] = true;
        visit[n - 1][1] = true;
        visit[n - 2][1] = true;

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken()) - 1;//이동방향
            p = Integer.parseInt(st.nextToken());//이동칸수
            //특수영양제 이동
            special = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(visit[i][j]){
                        int nx = (i + dx[d] * p + n * p) % n;
                        int ny = (j + dy[d] * p + n * p) % n;
                        special[nx][ny] = true;
                        map[nx][ny] += 1;
                    }
                }
            }
            //증가
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (special[i][j]) {
                        int cnt = 0;
                        for (int k = 1; k <= 7; k += 2) { //1357 대각선
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (map[nx][ny] >= 1) cnt++;
                        }
                        map[i][j] += cnt;
                    }
                }
            }
            //리브로수 자르고 특수영양제 올리기
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!special[i][j] && map[i][j] >= 2) {
                        map[i][j] -= 2;
                        visit[i][j] = true;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        System.out.println(sum);
    }


}




