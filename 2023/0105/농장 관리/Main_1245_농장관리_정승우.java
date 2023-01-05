import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1245_농장관리_정승우 {
    static int N,M, res;
    static boolean top;
    static int[][] map;
    static int[] dr= {-1,-1,-1,0,0,1,1,1};
    static int[] dc= {-1,0,1,-1,1,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++) {
            for(int j=0;j<M; j++) {
                if(!visited[i][j]) {
                    DFS(i,j);
                    if(top) {
                        top = true;
                        res++;
                    }
                }
            }
        }
        System.out.println(res);

    }

    private static void DFS(int i, int j) {
        visited[i][j] = true;
        for(int d=0; d<8; d++) {
            int nr = i+dr[d];
            int nc = j+dc[d];
            if(nr>=0 && nc>=0 && nr<N && nc<M) {
                if(map[i][j]<map[nr][nc]) {
                    top = false;
                }
                if(!visited[nr][nc]&&map[nr][nc]==map[i][j]) {
                    DFS(nr,nc);
                }
            }
        }
    }
}
