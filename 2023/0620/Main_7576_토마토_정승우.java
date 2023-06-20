import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_정승우 {
    static int n,m;
    static int[][] map;
    static Queue<Pos> queue;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        queue = new LinkedList<>();

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {

                    queue.add(new Pos(i,j,0));
                }
            }
        }

        bfs();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j]==0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(max);

    }

    private static void bfs() {

        while(!queue.isEmpty()) {
            Pos p = queue.poll();
            int r = p.r;
            int c = p.c;
            int cnt = p.cnt;
            max = Math.max(cnt,max);

            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(0<=nr&&0<=nc&&nr<n&&nc<m&&map[nr][nc]==0) {
                    map[nr][nc] = 1;
                    queue.add(new Pos(nr,nc,cnt+1));
                }
            }
        }
    }

    static class Pos {
        int r;
        int c;
        int cnt;

        Pos(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}
