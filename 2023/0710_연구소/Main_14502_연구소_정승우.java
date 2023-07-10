import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_정승우 {
    static int n,m;
    static int[][] map;
    static int[][] virus;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];


        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        build(0);
        System.out.println(max);


    }

    static class Pos {
        int r;
        int c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    private static void build(int cnt) {
        if(cnt==3) {
            bfs();
            return;
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    build(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        virus = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                virus[i][j] = map[i][j];
                if(virus[i][j]==2) q.add(new Pos(i,j));

            }
        }

        while(!q.isEmpty()) {
            Pos p = q.poll();
            int r = p.r;
            int c = p.c;

            for(int d=0; d<4; d++) {
                int nr = r+dr[d];
                int nc = c+dc[d];
                if(0<=nr&&0<=nc&&nr<n&&nc<m&&virus[nr][nc]==0) {
                    virus[nr][nc] = 2;
                    q.add(new Pos(nr,nc));
                }
            }
        }

        int tmp = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(virus[i][j]==0) tmp++;
            }
        }
        if(tmp>max) max = tmp;
    }
}
