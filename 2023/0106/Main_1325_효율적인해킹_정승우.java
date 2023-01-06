import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1325_효율적인해킹_정승우 {
    static boolean[] visited;
    static int count;
    static int max = Integer.MIN_VALUE;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int map[][] = new int[N+1][N+1];

        for(int i=0; i<=N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list.get(B).add(A);
        }
        int[] res = new int[N+1];
        for(int i=1; i<=N; i++) {
            visited = new boolean[N+1];
            count = 0;
            BFS(i);
            res[i] = count;
            max = Math.max(count, max);
        }
        for(int i=1; i<=N; i++) {
            if(res[i]==max) {
                sb.append(i+" ");
            }
        }
        System.out.println(sb);

    }

    public static void BFS(int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited[i] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for(int j : list.get(v)) {
                if(!visited[j]) {
                    q.add(j);
                    visited[j] = true;
                    count++;
                }
            }
        }
    }
}
