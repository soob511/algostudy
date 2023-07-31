package 삼성하반기준비;

import java.io.*;
import java.util.*;

public class Main_21608_상어초등학교 {
    static int n;
    static int[][] map, arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        arr = new int[n * n + 1][4];

        for (int i = 1; i < n * n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                arr[num][j] = Integer.parseInt(st.nextToken());
            }
            choose(num);
        }

        int answer =0;
        for (int x = 0; x <n; x++) {
            for (int y = 0; y <n; y++) {
                int like = 0;
                for (int d = 0; d <4; d++) {
                    int nx = x+dx[d];
                    int ny = y+dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    for (int s = 0; s <4; s++) {
                        if(map[nx][ny]==arr[map[x][y]][s]){
                            like++;
                        }
                    }
                }
                if(like!=0) {
                    answer += Math.pow(10,like-1);
                }
            }
        }
        System.out.println(answer);

    }

    private static void choose(int num) {
        PriorityQueue<Seat> pq = new PriorityQueue<>();

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                if (map[x][y] != 0) continue;
                int like = 0;
                int empty = 0;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (map[nx][ny] == 0) empty++;
                    else {
                        for (int s = 0; s < 4; s++) {
                            if (map[nx][ny] == arr[num][s]) {
                                like++;
                                break;
                            }
                        }
                    }
                }

                pq.add(new Seat(x,y,like,empty));
            }
        }
        Seat seat = pq.poll();
        map[seat.x][seat.y] = num;
    }

    private static class Seat implements Comparable<Seat> {
        int x, y, like, empty;

        public Seat(int x, int y, int like, int empty) {
            this.x = x;
            this.y = y;
            this.like = like;
            this.empty = empty;

        }

        @Override
        public int compareTo(Seat o) {
            if (o.like == this.like) {
                if (o.empty == this.empty) {
                    if (o.x == this.x) {
                        return this.y - o.y;
                    } else return this.x - o.x;
                } else return o.empty - this.empty;
            } else return o.like - this.like;
        }
    }
}
