import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2210_숫자판점프_정승우 {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static String[][] map = new String[5][5];
    static boolean[][] check = new boolean[5][5];
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<5; j++) {
                map[i][j] = st.nextToken();
            }
        }
        
        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                dfs(i,j,0, map[i][j]);
            }
        }
        System.out.println(list.size());
    }

    private static void dfs(int i, int j, int cnt, String tmp) {
        if (cnt == 5) {
            if(!list.contains(tmp)) {
                list.add(tmp);
            }
            return;
        }
        for(int d=0; d<4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if(0<=nr&&0<=nc&&nr<5&&nc<5) {
                dfs(nr,nc,cnt+1,tmp+ map[nr][nc]);
            }
        }
    }
}
