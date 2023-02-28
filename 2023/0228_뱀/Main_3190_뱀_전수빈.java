package implement;

import java.io.*;
import java.util.*;

public class Main_3190_뱀 {
    static int n, k, L;
    static int[][] map;
    static int[] d;
    static int[] dx = {0, 1, 0, -1};//우,하,좌,상
    static int[] dy = {1, 0, -1, 0};
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //맵크기
        map = new int[n][n];
        k = Integer.parseInt(br.readLine()); //사과갯수
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = 2;//사과
        }
        L = Integer.parseInt(br.readLine());//회전수
        d = new int[10001];
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            if (C.equals("D")) {//오른쪽
                d[X] = 2;
            } else {
                d[X] = 1; //왼쪽
            }
        }
        int time = 0;
        int dir = 0;
        int x = 0;
        int y = 0;
        list.add(new int[]{x, y});
        while (true) {
            time++;
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (check(nx, ny))break;
            if (map[nx][ny] == 2) {//사과먹으면
                map[nx][ny] = 0;
                list.add(new int[]{nx, ny});
            } else {
                list.add(new int[]{nx, ny});
                list.remove(0);
            }
            x = nx;
            y = ny;
            if (d[time] != 0) {
                if (d[time] == 1) {//왼쪽으로 회전
                    if (dir == 0) {
                        dir = 3;
                    } else {
                        dir--;
                    }
                } else if (d[time] == 2) {//오른쪽으로 회전
                    if (dir == 3) {
                        dir = 0;
                    } else {
                        dir++;
                    }
                }
            }

        }
        System.out.println(time);

    }

    private static boolean check(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= n || ny >= n) {//벽에 부딪히면
            return true;
        }
        for (int i = 0; i < list.size(); i++) {//몸통에 부딪히면
            if (nx == list.get(i)[0] && ny == list.get(i)[1]) {
                return true;
            }
        }
        return false;
    }
}
