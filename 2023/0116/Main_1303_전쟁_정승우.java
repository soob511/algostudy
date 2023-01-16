import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1303_전쟁_정승우 {
    static int N,M;
    static char[][] map;
    static boolean[][] check;
    static Queue<pos> queue = new LinkedList<>();
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int cnt = 1;
    static int W ,B = 0;
    public static class pos {
        int r;
        int c;

        pos(int r,int c) {
            this.r = r;
            this.c = c;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];
        check = new boolean[M][N];
        for(int i=0; i<M; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(check[i][j]==true) continue;
                cnt = 1;
                check[i][j] = true;
                queue.add(new pos(i,j));
                bfs();
                if(map[i][j]=='W') {
                    W += cnt * cnt;
                } else {
                    B += cnt * cnt;
                }
            }
        }
        System.out.println(W+" "+B);
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            pos p = queue.poll();
            int r = p.r;
            int c = p.c;
            for(int d=0; d<4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if(nr>=0&&nc>=0&&nr<M&&nc<N&&!check[nr][nc]&&map[r][c]==map[nr][nc]) {
                    check[nr][nc] = true;
                    cnt++;
                    queue.add(new pos(nr, nc));
                }
            }
        }
    }
}
