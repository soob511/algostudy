import java.io.*;
import java.util.*;

public class BOJ_1504_이길상 {

    static int[] dkstra(int[][] adj, int start){
        int N = adj.length;

        // 각 정점 도달 최저비용
        int[] cost = new int[N];
        Arrays.fill(cost, 200000000);
        cost[start] = 0;

        // 방문 기록
        boolean[] visited = new boolean[N];

        // 우선순위 큐
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)-> cost[a]-cost[b]);
        queue.add(start);

        while(!queue.isEmpty()){
            int v = queue.poll();
            visited[v] = true;

            for (int i = 0; i < N; i++) {
                //간선이 존재할 경우
                if(adj[v][i]>0 && !visited[i]){
                    if(cost[i] == 0 || cost[i] > cost[v] + adj[v][i]){
                        cost[i] = cost[v] + adj[v][i];
                        queue.add(i);
                    }
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 첫 줄 입력
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);

        // 인접행렬
        int[][] adj = new int[N][N];
        // 간선 입력
        for (int e = 0; e < E; e++) {
            line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]) - 1;
            int b = Integer.parseInt(line[1]) - 1;
            int c = Integer.parseInt(line[2]);

            adj[a][b] = c;
            adj[b][a] = c;
        }

        // 경유지점 2개
        line = br.readLine().split(" ");
        int v1 = Integer.parseInt(line[0]) - 1;
        int v2 = Integer.parseInt(line[1]) - 1;

        // 1번에서 시작하는 다익스트라
        int[] start_at_one = dkstra(adj, 0);
        
        // v1에서 시작하는 다익스트라
        int[] start_at_v1 = dkstra(adj, v1);

        // v2에서 시작하는 다익스트라
        int[] start_at_v2 = dkstra(adj, v2);

        int route1 = start_at_one[v1] + start_at_v1[v2] + start_at_v2[N-1];
        int route2 = start_at_one[v2] + start_at_v2[v1] + start_at_v1[N-1];

        if(route1>=200000000 && route2>=200000000) System.out.println(-1);
        else System.out.println(Math.min(route1, route2));
    }
}