import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13565_침투_정승우 {
    static int n,m;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m];

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                map[i][j] = str.charAt(j)-'0';
            }
        }

        for(int i=0; i<1; i++) {
            for(int j=0; j<m; j++) {
                if(!check[i][j]) {
                    dfs(i,j);
                }
            }
        }

        for(int i=n-1; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(check[i][j]==true) {
                    ans = 1;
                }
            }
        }

        if(ans==1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }



    }

    private static void dfs(int r, int c) {

        check[r][c] = true;

        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(0<=nr&&0<=nc&&nr<n&&nc<m&&map[nr][nc]==0&&check[nr][nc]==false) {
                dfs(nr, nc);
            }
        }
    }
}
