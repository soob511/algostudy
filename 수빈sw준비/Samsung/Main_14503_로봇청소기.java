package Samsung;

import java.io.*;
import java.util.*;

public class Main_14503_로봇청소기 {
    static int n,m;
    static int[][] map;
    static int r,c,d;
    static int[] dr = {-1,0,1,0}; //북 동 남 서
    static int[] dc = {0,1,0,-1};
    static int count=1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dfs(r,c,d);
        System.out.println(count);
        for(int[] b:map) System.out.println(Arrays.toString(b));
        System.out.println();

    }

    private static void dfs(int r, int c, int d) {
        map[r][c] = -1;

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >=0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 0) {
                count++;
                dfs(nr, nc, d);
                return;
            }

        }

        int b = (d + 2) % 4;
        int br = r + dr[b];
        int bc = c + dc[b];

        if (br >= 0 && bc >= 0 && br < n && bc < m && map[br][bc] != 1) {
            dfs(br, bc, d);
        }
    }
}
