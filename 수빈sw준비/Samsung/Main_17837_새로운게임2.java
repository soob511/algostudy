package Samsung;

import java.io.*;
import java.util.*;

public class Main_17837_새로운게임2 {
    static int n, k;
    static int[][] map;
    static int[] dx = {0, 0, 0, -1, 1};//우 좌 상 하
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] horse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //체스판 크기
        k = Integer.parseInt(st.nextToken()); //말의 개수

        map = new int[n + 1][n + 1];//맵 1.1 부터 시작
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        horse = new int[k][3];
        for (int i = 0; i < k; i++) { // 말 위치 정보
            st = new StringTokenizer(br.readLine());
            horse[i][0] = Integer.parseInt(st.nextToken());
            horse[i][1] = Integer.parseInt(st.nextToken());
            horse[i][2] = Integer.parseInt(st.nextToken());

        }

        //이동
        move();

    }

    private static void move() {


    }

}


