import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16236_아기상어_정승우 {
    static int n;
    static int[][] map;
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int[] cur = null;
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    cur = new int[]{i,j};
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0;
        int move = 0;

        while (true) {
            PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[n][n];

            que.add(new int[]{cur[0], cur[1], 0});
            visit[cur[0]][cur[1]] = true;

            boolean ck = false;

            while (!que.isEmpty()) {
                cur = que.poll();

                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) {
                    map[cur[0]][cur[1]] = 0;
                    eat++;
                    move += cur[2];
                    ck = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || visit[nr][nc] || map[nr][nc] > size)
                        continue;

                    que.add(new int[]{nr, nc, cur[2] + 1});
                    visit[nr][nc] = true;
                }
            }

            if (!ck)
                break;

            if (size == eat) {
                size++;
                eat = 0;
            }
        }


        System.out.println(move);
    }
}
