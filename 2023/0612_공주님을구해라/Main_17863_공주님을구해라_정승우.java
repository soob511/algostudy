import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17863_공주님을구해라_정승우 {
    static int n,m,t;
    static int map[][];
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static boolean[][] check;
    static Pos gram;
    static int ans = Integer.MAX_VALUE;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2) {
                    gram = new Pos(i,j);
                }
            }
        }

        bfs();
        if(t>=ans) {
            System.out.println(ans);
        } else {
            System.out.println("Fail");
        }


    }

    private static void bfs() {
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(0,0));
        check[0][0] = true;
        int cnt = -1;
        int size = 0;

        while(!q.isEmpty()) {
            cnt++;
            size = q.size();
            for(int i=0; i<size; i++) {
                Pos p = q.poll();

                if(p.r == gram.r && p.c == gram.c) {
                    ans = cnt + n -1 - gram.r + m - 1 - gram.c;
                    continue;
                }

                else if(p.r == n-1 && p.c == m-1) {
                    ans = Math.min(ans, cnt);
                    return;
                }

                for(int d=0; d<4; d++) {
                    int nr = p.r + dr[d];
                    int nc = p.c + dc[d];
                    if(nr>=0&&nc>=0&&nr<n&&nc<m&&!check[nr][nc]&&map[nr][nc]!=1) {
                        q.offer(new Pos(nr,nc));
                        check[nr][nc] = true;
                    }
                }
            }
        }
    }

    static class Pos {
        int r;
        int c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }
}
