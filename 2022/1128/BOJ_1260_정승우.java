import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260_정승우 {

    static boolean[] check;
    static int[][] arr;
    static int N, V, M;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        check = new boolean[N+1];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arr[a][b] = arr[b][a] = 1;

        }

        dfs(V);
        check = new boolean[N+1];
        System.out.println();
        bfs(V);


    }

    private static void dfs(int V) {
        check[V] = true;
        System.out.print(V);
        for(int i=0; i<= N; i++) {
            if(arr[V][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }

    private static void bfs(int V) {
        q.add(V);
        check[V] = true;

        while(!q.isEmpty()) {
            V = q.poll();
            System.out.print(V);

            for(int i=1; i<=N; i++) {
                if(arr[V][i] == 1 && !check[i]) {
                    q.add(i);
                    check[i] =true;
                }
            }
        }
    }


}
