package backtracking;

import java.io.*;
import java.util.*;

public class Main_1799_비숍 {
    static int n;
    static int[][] map;
    static boolean[][] chess, visit;
    static int[] dx = {-1,-1};
    static int[] dy = {-1,1};
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        chess = new boolean[n][n];
        visit = new boolean[n][n];
        count = new int[2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i % 2 == 0 && j % 2 == 0 || i % 2 == 1 && j % 2 == 1) { //블랙,화이트 구분
                    chess[i][j] = true;
                }
            }
        }
        dfs(0, true, 0); //블랙칸
        dfs(0, false, 0);//흰색칸
        System.out.println(count[0]+count[1]);

    }

    private static void dfs(int start, boolean black, int cnt) {
        for (int i = start; i < n * n; i++) {
            int x = i / n;
            int y = i % n;
            if (map[x][y] == 0 || chess[x][y] != black || !check(x, y)) continue;
            visit[x][y] = true;
            dfs(i + 1, black, cnt + 1);
            visit[x][y] = false;
        }
        count[black ? 0 : 1] = Math.max(count[black ? 0 : 1], cnt);
    }

    private static boolean check(int x, int y) {//위에서부터 놓기때문에 위쪽만 탐색
        for (int i = 0; i < 2; i++) {
          int nx = x;
          int ny = y;
          while (true){
              if(nx<0||ny<0||nx>=n||ny>=n)break;
              if(visit[nx][ny]){
                  return false;
              }
              nx+=dx[i];
              ny+=dy[i];
          }
        }
        return true;
    }
}
