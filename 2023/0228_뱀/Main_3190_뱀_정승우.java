import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_3190_뱀_정승우 {
    static int N;
    static int K;
    static int r, c;
    static int L;
    static int[][] map;
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };
    static List<int[]> snake;
    static Map<Integer, String> dir = new HashMap<>();
    static int y= 1, x=1;
    static int nowDir = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        snake = new LinkedList<int[]>();
        snake.add(new int[] { 1, 1 });

        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map[r][c] = 1;
        }

        L = Integer.parseInt(br.readLine());
//        Map<Integer, String> dir = new HashMap<>();

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            dir.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        int time = dfs();
        System.out.println(time);
    }

    private static int dfs() {
        int time = 0;
        while(true) {
            time++;
            int nr = x + dr[nowDir];
            int nc = y + dc[nowDir];

            if(nr < 1 || nc < 1 || nr >= N + 1 || nc >= N + 1) {
                break;
            }

            for (int i = 0; i < snake.size(); i++) {

                if(nr == snake.get(i)[1] && nc == snake.get(i)[0]) {
                    return time;
                }
            }

            if(map[nc][nr] == 1) {
                map[nc][nr] = 0;
                snake.add(new int[] {nc, nr});
            }else {
                snake.add(new int[] {nc, nr});
                snake.remove(0);
            }

            x = nr;
            y = nc;

            if(dir.containsKey(time)) {
                if(dir.get(time).equals("D")) {
                    nowDir++;
                    if(nowDir == 4) {
                        nowDir = 0;
                    }
                }

                else if(dir.get(time).equals("L")) {
                    nowDir--;
                    if(nowDir == -1) {
                        nowDir = 3;
                    }
                }
            }
        }
        return time;
    }
}
