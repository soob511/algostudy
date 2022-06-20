import java.util.*;
import java.io.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        
        // 큐
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            // 방문 확인
            if(visit[i]) continue;
            
            // bfs
            queue.add(i);
            visit[i] = true;
            while(!queue.isEmpty()){
                int e = queue.poll();
                
                for(int j = 0; j < n; j++){
                    // 아직 방문하지 않았고, e와 연결되어 있을 때
                    if(!visit[j] && computers[e][j] == 1){
                        queue.add(j);
                        visit[j] = true;
                    }
                }
            }
            
            // 네트워크 1 증가
            answer++;
        }
        
        return answer;
    }
}
