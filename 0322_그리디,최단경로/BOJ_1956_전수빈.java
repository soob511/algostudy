package Dijkstra;

import java.util.*;

public class Main_1956_운동 {
	private static int V; // V개의 마을
    private static int E; // E개의 도로
    private static int[][] distance; // 도로의 최소거리
    private static int INF = 10000 * 400 + 1;
    private static int result = 10000 * 400 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        distance = new int[V + 1][V + 1];
        
        //초기화
        for (int i = 1; i <= V; i++) {
            Arrays.fill(distance[i], INF);
        }
        for (int i = 0; i < E; i++) {
            int start = sc.nextInt(); // a번 마을
            int end = sc.nextInt(); // b번 마을
            int dist = sc.nextInt();
            distance[start][end] = dist; 
            
        }
        
        //플로이드 와샬
        for (int k = 1; k <= V; k++) {//거쳐가는 노드
            for (int i = 1; i <= V; i++) {//출발노드
                for (int j = 1; j <= V; j++) {//도착노드
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
        
        // 사이클 중 최솟값을 구한다.
        for (int i = 1; i <= V; i++) {
            result = Math.min(distance[i][i], result);
        }
        if (result == INF) {//경로가 없다는 뜻
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

 
}
