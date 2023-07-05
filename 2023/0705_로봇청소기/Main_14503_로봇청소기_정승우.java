import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main_14503_로봇청소기_정승우 {
    static int n,m,r,c,d;
    static int[][] map;
    static boolean[][] visit;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visit = new boolean[n][m];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        move(r,c,d);
        System.out.println(cnt);
    }

    private static void move(int r,int c,int d) {

        //1.현재 칸이 아직 청소되지 않은 경우 청소를 한다
        if(map[r][c]==0&&!visit[r][c]) {
            cnt++;
            visit[r][c]=true;
        }

        //청소 유무 확인
        boolean check = false;

        for(int i=0; i<4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
             if(0<=nr&&0<=nc&&nr<n&&nc<m&&map[nr][nc]==0&&!visit[nr][nc]) {
                 check = true;
             }
        }
        //2. 청소되지 않은 빈칸이 없는경우
        if(!check) {
            int behind = (d+2) % 4;

            int nr = r+dr[behind];
            int nc = c+dc[behind];
            //2-1 후진할 수 있는 경우
            if(0<=nr&&0<=nc&&nr<n&&nc<m&&map[nr][nc]==0) {
                move(nr, nc, d);
            }
        } else {
            //3. 청소되지 않은 빈 칸이 있는 경우
            //3-1 반시계방향으로 회전

            //3-2 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인경우 1칸 전진
            for(int i=0; i<4; i++) {
                d = (d+3) % 4;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (0 <= nr && 0 <= nc && nr < n && nc < m && map[nr][nc] == 0 && !visit[nr][nc]) {
                    move(nr, nc, d);
                    return;
                }

            }
        }
    }
}
