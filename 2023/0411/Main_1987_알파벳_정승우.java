import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳_정승우 {
    static int r,c;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static boolean[] check = new boolean[26];
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];


        for(int i=0; i<r; i++){
            String str = br.readLine();
            for(int j=0; j<c; j++) {
                map[i][j] = str.charAt(j)-'A';
            }
        }

        dfs(0,0, 0);
        System.out.println(res);




    }

    private static void dfs(int x, int y, int cnt) {
        if(check[map[x][y]]) {
            res = Math.max(res, cnt);
            return;
        } else {
            check[map[x][y]] = true;
            for(int d=0; d<4; d++) {
                int nr = x+dr[d];
                int nc = y+dc[d];
                if(0<=nr&&0<=nc&&nr<r&&nc<c) {
                    dfs(nr, nc, cnt+1);
                }
            }

            check[map[x][y]] = false;
        }
    }
}
