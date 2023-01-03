import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16928_뱀과사다리게임_정승우 {
    static int N,M,cnt;
    static boolean visited[];
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //사다리 개수
        N = Integer.parseInt(st.nextToken());
        //뱀의 수
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[101];
        map = new HashMap<>();

        for(int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            map.put(key, value);
        }
        bfs();
        System.out.println(cnt);
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;

        while(!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for(int i=0; i<size; i++) {
                int now = q.poll();

                for(int j=1; j<=6; j++) {
                    int move = now + j;
                    if(move==100) return;
                    if(move > 100 || visited[move]) continue;

                    visited[move] = true;
                    if(map.containsKey(move)) {
                        move = map.get(move);
                    }
                    q.add(move);
                }
            }
        }
    }


}
