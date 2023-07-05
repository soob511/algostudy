package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_14503_로봇청소기 {
    static int[] dr = {-1, 0, 1, 0}; //북,동,남,서
    static int[] dc = {0, 1, 0, -1};
    static int n, m, r, c, d;
    static int[][] map;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken()) ;
        c = Integer.parseInt(st.nextToken()) ;
        d = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clean(r, c, d);
        System.out.println(count);

    }


    private static void clean(int r, int c, int d) {
        //현재 칸의 주변 4$칸 중 청소되지 않은 빈 칸이 있는 경우,
        //반시계 방향으로 90도 회전한다.
        //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
        //1번으로 돌아간다.
        map[r][c] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 0) {
                count++;
                clean(nr, nc, d);
                return;
            }

        }
        //현재 칸의 주변4칸 중 청소되지 않은 빈 칸이 없는 경우,
        //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
        //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
        int b = (d + 2) % 4;
        int br = r + dr[b];
        int bc = c + dc[b];

        if (br >= 0 && bc >= 0 && br < n && bc < m && map[br][bc] != 1) {
            clean(br, bc, d);
        }
    }

}
