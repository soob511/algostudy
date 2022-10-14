package Samsung;

import java.util.*;
import java.io.*;

public class Main_16236_아기상어 {
    static int n;
    static int[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size;
    static int answer;
    static int eat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        size = 2;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    q.add(new int[]{i, j});
                    map[i][j] = 0;
                }
            }
        }

        bfs();
        System.out.println(answer);

    }

    private static void bfs() {
        int[][] dist = new int[n][n];
        int fishx = Integer.MAX_VALUE;
        int fishy = Integer.MAX_VALUE;
        int fishd = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0];
            int y = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue; //범위 초과 패쓰
                if (map[nx][ny] > size) continue;//자기보다 큰 물고기 패쓰
                if (map[nx][ny] != 0) continue; //지나간자리 패쓰
                dist[nx][ny] = dist[x][y] + 1;
                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    if(fishd>dist[nx][ny]){
                        fishd=dist[nx][ny];
                        fishx = nx;
                        fishy = ny;
                    }else if(fishd==dist[nx][ny]){
                        if(nx==fishx){
                            if(fishy>ny){
                                fishx = nx;
                                fishy = ny;
                            }
                        }else if(nx<fishx){
                            fishx = nx;
                            fishy = ny;
                        }
                    }
                }
                q.add(new int[]{nx, ny});
            }
            if(fishx==Integer.MAX_VALUE||fishy==Integer.MAX_VALUE){
                break;
            }
            answer +=dist[fishx][fishy];
            map[fishx][fishy]=0;

            eat++;


            if(eat==size){
                size++;
                eat =0;
            }

        }

    }
}
