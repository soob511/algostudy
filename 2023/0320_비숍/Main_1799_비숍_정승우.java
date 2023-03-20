import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1799_비숍_정승우 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean[][] black;
    static int[] dr = {-1,-1};
    static int[] dc = {1,-1};
    static int whiteMax;
    static int blackMax;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        black = new boolean[N][N];
        StringTokenizer st;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if((i % 2 == 0 && j % 2 == 0) || (i % 2 != 0 && j % 2 != 0)) {
                    black[i][j] = true;
                }
            }

            dfs(-1, 0, true);

            dfs(-1, 0, false);

        }
        System.out.println(blackMax + whiteMax);
    }

    private static void dfs(int idx, int cnt, boolean isBlack) {

        for(int i=idx+1; i<N * N; i++) {
            int r = i/N;
            int c = i%N;

            if(black[r][c] == isBlack && map[r][c]!=0 && check(r,c)) {
                visited[r][c] = true;
                dfs(i, cnt+1, isBlack);
                visited[r][c] = false;
            }

            if(isBlack==true) {
                blackMax = Math.max(blackMax, cnt);
            } else {
                whiteMax = Math.max(whiteMax, cnt);
            }

        }

    }

    private static boolean check(int r, int c) {
        for(int d=0; d<2; d++) {
            int nr = r;
            int nc = c;

            while(true) {
                if(nr<N && nc<N && 0<=nr && 0<=nc) {
                    if(visited[nr][nc]) {
                        return false;
                    }

                    nr+= dr[d];
                    nc+= dc[d];
                } else {
                    break;
                }
            }
        }
        return true;
    }
}
