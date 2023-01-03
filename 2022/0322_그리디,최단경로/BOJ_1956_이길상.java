package day0322;
import java.io.*;
import java.util.Arrays;

public class BOJ_1956_이길상 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int INF = 1000000000;
        
        // 정점과 간선의 개수
        String[] line = br.readLine().split(" ");
        int V = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        
        // 그래프 정보
        int[][] vertex = new int[V][V];
        for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				vertex[i][j] = INF;
			}
		}
        
        for (int e = 0; e < E; e++) {
        	line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);
            
            vertex[a-1][b-1] = c;
		}
        
        // 최단거리 갱신
        for (int k = 0; k < V; k++) {
        	for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					// i에서 v를 거쳐 j로 갈때
					vertex[i][j] = Math.min(vertex[i][j], vertex[i][k] + vertex[k][j]);				
				}
			}
		}
        
        // 사이클 확인
        int cycle = INF;
        for (int i = 0; i < V; i++) {
        	cycle = Math.min(cycle, vertex[i][i]);
		}  
        
        // 출력
        if(cycle == INF) System.out.println(-1);
        else System.out.println(cycle);
        
    }

}
