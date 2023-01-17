import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926_그림_정승우 {
    static int n,m;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int cnt;

    static int res = Integer.MIN_VALUE;

    static Queue<Pos> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];
        int count = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==1&&check[i][j]==false) {
                    cnt = 1;
                    queue.add(new Pos(i,j));
                    check[i][j] = true;
                    bfs();
                    count++;
                    //카운트가 총 그림 개수여야함
                    if(res<cnt) {
                        res = cnt;
                    }
                }
            }
        }
        System.out.println(count);
        System.out.println(res);
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int r = p.r;
            int c = p.c;

            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=0&&nc>=0&&nr<n&&nc<m&&!check[nr][nc]) {

                    check[nr][nc] = true;
                    cnt++;
                    bfs();
                }
            }
        }
    }

    public static class Pos{
        int r,c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
