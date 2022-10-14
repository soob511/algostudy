package Samsung;

import java.util.*;
import java.io.*;

public class Main_21610_마법사상어와비바라기 {
    static int n, m;
    static int[][] map;
    static int d, s;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};// 좌 좌상 상 우상 우 우하 하 좌하
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static Queue<int[]> q = new LinkedList<>();
    static boolean[][] visit;

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


        q.add(new int[]{n - 1, 0});
        q.add(new int[]{n - 1, 1});
        q.add(new int[]{n - 2, 0});
        q.add(new int[]{n - 2, 1});

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            visit = new boolean[n][n];
            go();//이동
            rain();//비내리기
            water();//대각선
            cloud();//구름생성
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }
        for (int[] b : map) System.out.println(Arrays.toString(b));
        System.out.println();
        System.out.println(sum);

    }

    private static void cloud() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && map[i][j] >= 2) {
                    q.add(new int[]{i, j});
                    map[i][j] = map[i][j] - 2;
                }
            }
        }
    }
    private static void water() {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int count = 0;
            for (int j = 1; j <=4; j++) {//1357
                    int nx = x + dx[j*2-1];
                    int ny = y + dy[j*2-1];
                    if (nx >=0 && ny >=0 && nx < n && ny < n && map[nx][ny] != 0) {
                        count++;
                    }
            }
            map[x][y] = map[x][y] + count;

        }

    }

    private static void rain() {
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            map[x][y] = map[x][y] + 1;
            visit[x][y] = true;
            q.add(new int[]{x, y});
        }

    }

    private static void go() {
        int size = q.size();
        while (size-- > 0) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for (int j = 0; j < s; j++) {//횟수만큼
                x = x + dx[d - 1];
                y = y + dy[d - 1];
                if (x < 0) {
                    x +=n;
                } else if (x >= n) {
                    x -=n;
                }
                if (y < 0) {
                    y +=n;
                }else if (y >= n) {
                    y -=n;
                }
            }
            q.add(new int[]{x, y});
        }


    }


}



