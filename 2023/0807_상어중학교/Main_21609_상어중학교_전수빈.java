package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_21609_상어중학교 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Block> pq;
    static boolean[][] visited;

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
        int score = 0;
        while (true) {
            pq = new PriorityQueue<>();
            visited = new boolean[n][n];
            //1.블록찾기
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] >= 1&&!visited[i][j]) {//색깔블럭
                        for (int x = 0; x < n; x++) {
                            for (int y = 0; y < n; y++) {
                                if(map[x][y]==0){
                                    visited[x][y] = false;
                                }
                            }
                        }
                        bfs(i, j, map[i][j]);
                    }
                }
            }
            if (pq.isEmpty()) break;//블록없으면 break;
            Block block = pq.poll();

            //2. 블록제거
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visit = new boolean[n][n];
            q.add(new int[]{block.bx, block.by, map[block.bx][block.by]});
            //System.out.println(block.bx + " " + block.by+" "+map[block.bx][block.by]);
            map[block.bx][block.by] = -2;
            while (!q.isEmpty()) {
                int[] p = q.poll();
                int x = p[0];
                int y = p[1];
                int c = p[2];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n || visit[nx][ny] || map[nx][ny] < 0 )
                        continue;//범위벗어나고,방문하지않고,벽돌빼고,빈칸빼고
                    if (map[nx][ny] == 0 || map[nx][ny] == c) {
                        q.add(new int[]{nx, ny, c});
                        visit[nx][ny] = true;
                        map[nx][ny] = -2;
                    }
                }
            }

            score += Math.pow(block.size, 2);//점수획득
            //3.중력
            for (int x = n - 1; x >= 0; x--) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] >= 0) {//검은색벽돌 아니면
                        while (true) {
                            int nx = x + 1;
                            if (nx >= n || map[nx][y] != -2) break;
                            else if (map[nx][y] == -2) {
                                map[nx][y] = map[x][y];
                                map[x][y] = -2;
                                x = nx;
                            }
                        }
                    }
                }
            }

            //4.반시계방향
            int[][] map2 = new int[n][n];
            int num = 0;
            for (int j = n - 1; j >= 0; j--) {
                for (int i = 0; i < n; i++) {
                    map2[num][i] = map[i][j];
                }
                num++;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = map2[i][j];
                }
            }

            //5.중력
            for (int x = n - 1; x >= 0; x--) {
                for (int y = 0; y < n; y++) {
                    if (map[x][y] >= 0) {//검은색벽돌 아니면

                        while (true) {
                            int nx = x + 1;
                            if (nx >= n || map[nx][y] != -2) break;
                            else if (map[nx][y] == -2) {
                                map[nx][y] = map[x][y];
                                map[x][y] = -2;
                                x = nx;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(score);

    }

    private static void bfs(int a, int b, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a, b, color});
        visited[a][b] = true;
        int size = 1;
        int rainbow = 0;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];
            int c = p[2];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || visited[nx][ny] || map[nx][ny] < 0)
                    continue;//범위벗어나고,방문한곳,벽돌빼고,빈칸빼고
                if (map[nx][ny] == 0 || map[nx][ny] == c) {
                    if (map[nx][ny] == 0) rainbow++;
                    q.add(new int[]{nx, ny, c});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }
        if (size >= 2) {
            pq.add(new Block(a, b, size, rainbow));
        }
    }

    private static class Block implements Comparable<Block> {
        int bx;
        int by;
        int size;
        int rainbow;

        public Block(int bx, int by, int size, int rainbow) {
            this.bx = bx;
            this.by = by;
            this.size = size;
            this.rainbow = rainbow;
        }

        @Override
        public int compareTo(Block o) {
            if (o.size == this.size) {//블록크기가 같으면
                if (o.rainbow == this.rainbow) {//무지개블록 크기가같으면
                    if (o.bx == this.bx) {//행의번호가 같으면
                        return o.by - this.by;
                    } else return o.bx - this.bx;
                } else return o.rainbow - this.rainbow;
            } else return o.size - this.size;
        }
    }
}
