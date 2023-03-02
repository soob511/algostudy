package implement;

import java.io.*;
import java.util.*;

public class Main_11559_puyopuyo {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map = new char[12][6];
    static List<int[]> list = new LinkedList<>();
    static int count;
    static int result;
    static boolean[][] visit = new boolean[12][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        while (true) {
            boolean check = true;
            visit = new boolean[12][6];
            //              for(char[] b: map) System.out.println(Arrays.toString(b));System.out.println();
            for (int i = 11; i >= 0; i--) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        list = new LinkedList<>();
                        count = bfs(i, j, map[i][j]);
                        if (count >= 4) {
                            check = false;
                            for (int k = 0; k < list.size(); k++) {
                                map[list.get(k)[0]][list.get(k)[1]] = '.';
                            }
                        }
                    }
                }
            }
            if (check) break;
            move();
            result++;
        }
        System.out.println(result);

    }

    private static void move() {
        for (int i = 11; i >= 0; i--) {
            for (int j = 0; j < 6; j++) {
                if (map[i][j] != '.') {
                    int x = i;
                    while (true) {
                        int nx = x + 1;
                        if (nx >= 12 || map[nx][j] != '.') break;
                        if (map[nx][j] == '.') {
                            map[nx][j] = map[x][j];
                            map[x][j] = '.';
                            x = nx;
                        }
                    }
                }
            }
        }
    }

    private static int bfs(int a, int b, char c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b});
        list.add(new int[]{a, b});
        visit[a][b] = true;
        count = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;
                if (map[nx][ny] == c && !visit[nx][ny]) {
                    list.add(new int[]{nx, ny});
                    visit[nx][ny] = true;
                    q.add(new int[]{nx, ny});

                }
            }
            count++;
        }
        return count;
    }
}
