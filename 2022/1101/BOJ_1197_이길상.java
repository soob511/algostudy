import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        
        List<int[]>[] graph = new List[V];
        for (int v = 0; v < V; v++) {
            graph[v] = new ArrayList<>();
        }

        for (int e = 0; e < E; e++) {
            line = br.readLine().split(" ");

            int A = Integer.parseInt(line[0])-1;
            int B = Integer.parseInt(line[1])-1;
            int C = Integer.parseInt(line[2]);
            graph[A].add(new int[]{B,C});
            graph[B].add(new int[]{A,C});
        }

        boolean[] check = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        int answer = 0;

        // 0번 정점부터 시작
        check[0] = true;
        for (int[] e : graph[0]) {
            pq.add(e);
        }

        while (!pq.isEmpty()){
            // 현재 추가 가능한 간선 중 가중치가 최소인 것.
            int[] e = pq.poll();

            // 이미 포함한 정점이면 pass
            if (check[e[0]]) continue;

            // 간선 추가 + 정점 포함
            check[e[0]] = true;
            answer += e[1];

            // 포함한 정점에서 추가 가능한 간선들 큐에 넣기
            for (int[] edge : graph[e[0]]) {
                if (check[edge[0]]) continue;
                pq.add(edge);
            }
        }

        System.out.println(answer);
    }
}
