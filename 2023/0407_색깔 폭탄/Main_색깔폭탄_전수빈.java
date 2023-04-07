package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_색깔폭탄 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int score;

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

        while (true) {
            boolean[][] visit = new boolean[n][n];
            List<int[]>[] list = new ArrayList[n * n];
            for (int i = 0; i < n * n; i++) {
                list[i] = new ArrayList<>();
            }
            //폭탄묶음찾기
            int bomb = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && map[i][j] > 0) {
                        bomb++;
                        boolean[][] visit2 = new boolean[n][n];
                        Queue<int[]> q = new LinkedList<>();
                        q.add(new int[]{i, j});
                        visit[i][j] = true;
                        visit2[i][j] = true;
                        int z = map[i][j];
                        list[bomb].add(new int[]{i, j, z});
                        while (!q.isEmpty()) {
                            int[] p = q.poll();
                            int x = p[0];
                            int y = p[1];
                            for (int dir = 0; dir < 4; dir++) {
                                int nx = x + dx[dir];
                                int ny = y + dy[dir];
                                if (nx < 0 || ny < 0 || nx >= n || ny >= n  || visit2[nx][ny] || map[nx][ny] < 0)
                                    continue;//범위밖,방문했거나 검은돌,빈칸
                                if (map[nx][ny] == 0) {//빨간색
                                    q.add(new int[]{nx, ny});
                                    visit2[nx][ny] = true;
                                    list[bomb].add(new int[]{nx, ny, 0});
                                } else if (map[nx][ny] == z) {//같은색
                                    q.add(new int[]{nx, ny});
                                    visit[nx][ny] = true;
                                    visit2[nx][ny] = true;
                                    list[bomb].add(new int[]{nx, ny, z});
                                }
                            }
                        }
                    }
                }
            }
            //가장큰 폭탄묶음 찾기
            int max = 1;
            int num = 0;
            int red = 0;
            int r = 0;//행
            int c = 0;//열
            for (int i = 0; i < n * n; i++) {
                int count = 0;
                if (list[i].size() > max) {//폭탄이 최대값이면
                    max = list[i].size();
                    num = i;
                    for (int j = 0; j < list[i].size(); j++) {
                        if (list[i].get(j)[2] == 0) {//빨간폭탄수
                            count++;
                        }
                        if (list[i].get(j)[0] > r) {//가장큰행
                            r = list[i].get(j)[0];
                            c = list[i].get(j)[1];
                        } else if (list[i].get(j)[0] == r) {
                            if (c > list[i].get(j)[1]) {//가장 작은 열
                                c = list[i].get(j)[1];
                            }
                        }
                    }
                    red = count;
                } else if (max == list[i].size()) {//폭탄최대수랑 똑같으면
                    for (int j = 0; j < list[i].size(); j++) {
                        if (list[i].get(j)[2] == 0) {//빨간폭탄수세기
                            count++;
                        }
                    }
                    if (red > count) {//빨간폭탄이 적은걸로바꿔줌
                        num = i;
                        red = count;
                        for (int j = 0; j < list[i].size(); j++) {
                            if (list[i].get(j)[0] > r) {
                                r = list[i].get(j)[0];
                                c = list[i].get(j)[1];
                            } else if (list[i].get(j)[0] == r) {
                                if (c > list[i].get(j)[1]) {
                                    c = list[i].get(j)[1];
                                }
                            }
                        }
                    } else if (red == count) {//빨간폭탄갯수가같다면
                        for (int j = 0; j < list[i].size(); j++) {
                            if (list[i].get(j)[0] > r) {
                                num = i;
                                r = list[i].get(j)[0];
                                c = list[i].get(j)[1];
                            } else if (list[i].get(j)[0] == r) {
                                if (c > list[i].get(j)[1]) {
                                    num = i;
                                    c = list[i].get(j)[1];
                                }
                            }
                        }
                    }

                }
            }
            if (max == 1) {//폭탄묶음 존재하지 않음
                break;
            }
            //폭탄 터트리기
            for (int i = 0; i < list[num].size(); i++) {
                int x = list[num].get(i)[0];
                int y = list[num].get(i)[1];
                map[x][y] = -2;
            }
            score += list[num].size() * list[num].size();
            down();//중력
            //회전
            int[][] temp = new int[n][n];
            int y = n;
            for (int i = 0; i < n; i++) {
                int x = 0;
                y--;
                for (int j = 0; j < n; j++) {
                    temp[i][j] = map[x][y];
                    x++;
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = temp[i][j];
                }
            }
            down();//중력
        }
        System.out.println(score);
    }

    private static void down() {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] >= 0) {//폭탄들만
                    while (true) {
                        int nx = i + dx[1];
                        int ny = j + dy[1];
                        if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] != -2) {//범위밖이거나 빈공간이 아니면
                            break;
                        }
                        map[nx][ny] = map[i][j];
                        map[i][j] = -2;
                        i = nx;
                        j = ny;
                    }
                }
            }
        }
    }
}
