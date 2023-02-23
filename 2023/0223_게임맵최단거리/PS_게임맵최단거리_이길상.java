import java.io.*;
import java.util.*;

class Solution {
    
    static class Node {
        int x, y, d;
        
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n, m, answer, min;
    
    public int solution(int[][] maps) {
        //answer = 0;
        
        n = maps.length;    // n행
        m = maps[0].length; // m열   
        visited = new boolean[n][m];
        
        min = Integer.MAX_VALUE;
        bfs(maps, 0, 0);
        
        if(visited[n-1][m-1]) {
            answer = min;
        } else {
            answer = -1;
        }
        
        return answer;
    }
    
    public static void bfs(int[][] maps, int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1));
        visited[x][y] = true;
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if(cur.x==n-1 && cur.y==m-1) {
                min = Math.min(min, cur.d);
            }
            
            for(int i=0; i<4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m 
                  && !visited[nx][ny] && maps[nx][ny]==1) {
                    q.add(new Node(nx, ny, cur.d + 1));
                    visited[nx][ny] = true;
                    //answer++;
                } 
            }
        }
    }

}
