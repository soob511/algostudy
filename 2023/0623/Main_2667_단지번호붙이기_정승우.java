import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기_정승우 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int cnt;
    static int depth;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        cnt = 0;
        depth = 0;
        list = new ArrayList<>();

        for(int i=0; i<n; i++) {
            String str =  br.readLine();
            for(int j=0; j<n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j]!=0&&!visited[i][j]) {
                    dfs(i,j);
                    cnt++;
                    list.add(depth);
                    depth = 0;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
        


    }

    private static void dfs(int r, int c) {
        visited[r][c] = true;
        depth++;

        for(int d=0; d<4; d++) {
            int nr = r+dr[d];
            int nc = c+dc[d];
            if(0<=nr&&0<=nc&&nr<n&&nc<n&&visited[nr][nc]==false&&map[nr][nc]==1) {
                visited[nr][nc] = true;
                dfs(nr,nc);
            }
        }


    }
}
