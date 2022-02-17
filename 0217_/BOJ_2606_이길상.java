package day0215;
import java.util.*;

// 바이러스
public class BOJ_2606_이길상 {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 컴퓨터의 수
        int N = sc.nextInt();
        
        // 연결 상태 배열
        boolean[][] status = new boolean[N+1][N+1];
        // 감염 상태 배열
        boolean[] virus = new boolean[N+1];
        
        // 연결 수
        int M = sc.nextInt();
        
        while(M-->0) {
        	// 연결 정보
        	int x = sc.nextInt(), y = sc.nextInt();
        	
        	// 연결 상태 기록
        	status[x][y] = true;
            status[y][x] = true;
        }
        
        // 바이러스 컴퓨터 수
        int count = 0;
        // BFS용 큐
        Queue<Integer> bfs = new LinkedList<>();
        bfs.add(1);
        
        // BFS
        while(!bfs.isEmpty()) {
        	int com = bfs.poll();
        	
        	if(!virus[com]) {
        		// 감염 처리
            	count++;
            	virus[com] = true;
            	
            	// 연결된 컴퓨터 탐색
            	for (int i = 1; i <= N; i++) {
            		if(status[com][i]) bfs.add(i);
    			}
        	}	
        }
        
        System.out.println(count - 1);
    }

}
