package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_20057_마법사상어와토네이도 {
    static int n;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] dc = {1, 1, 2, 2};
    static int[][] sdx = {{-1, 1, -2, 2, -1, 1, -1, 1, 0}, {-1, -1, 0, 0, 0, 0, 1, 1, 2},  //1,1,2,2,7,7,10,10,5%
            {-1, 1, -2, 2, -1, 1, -1, 1, 0}, {1, 1, 0, 0, 0, 0, -1, -1, -2}};
    static int[][] sdy = {{1, 1, 0, 0, 0, 0, -1, -1, -2}, {-1, 1, -2, 2, -1, 1, -1, 1, 0},
            {-1, -1, 0, 0, 0, 0, 1, 1, 2}, {-1, 1, -2, 2, -1, 1, -1, 1, 0}};
    static int[] ratio = {1, 1, 2, 2, 7, 7, 10, 10, 5};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = move(n / 2, n / 2);
        System.out.println(answer);
    }

    private static int move(int a, int b) {
        int out = 0;
        int x = a;
        int y = b;
        while (true) {
            //모래이동
            for (int d = 0; d < 4; d++) {
                for (int c = 0; c< dc[d]; c++) {

                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                        return out;
                    }
                    //비율대로 모래 뿌리기
                    int sand = map[nx][ny];
                    map[nx][ny] = 0;
                    int sum = 0;

                    for (int j = 0; j < 9; j++) {
                        int sx = nx + sdx[d][j];
                        int sy = ny + sdy[d][j];
                        int spread = (sand * ratio[j]) /100;

                        if (sx < 0 || sy < 0 || sx >= n || sy >= n) {
                            out += spread;
                        } else {
                            map[sx][sy] += spread;
                        }
                        sum += spread;
                    }

                    //알파
                    int ax = nx + dx[d];
                    int ay = ny + dy[d];
                    int alpha = sand - sum;
                    if (ax < 0 || ay < 0 || ax >= n || ay >= n) {
                        out += alpha;
                    } else {
                        map[ax][ay] += alpha;
                    }
                    x = nx;
                    y = ny;
                }
            }
            for (int i = 0; i < 4; i++) {
                dc[i] += 2;
            }
        }
    }
}
