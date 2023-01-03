import java.io.*;
import java.util.*;

public class BOJ_7562_이길상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            /* 입력 */

            // 체스판 한변의 길이
            int I = Integer.parseInt(br.readLine());
            // 초기위치
            String[] line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]), y = Integer.parseInt(line[1]);
            // 목표
            line = br.readLine().split(" ");
            int P = Integer.parseInt(line[0]), Q = Integer.parseInt(line[1]);
            

            /* 데이터 초기화 */

            // BFS Queue
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{x,y,0});
            // check array
            boolean[][] visited = new boolean[I][I];
            visited[x][y] = true;
            // delta
            int[] dx = {2,1,2,1,-2,-1,-2,-1};
            int[] dy = {1,2,-1,-2,1,2,-1,-2};


            /* 탐색 */
            while(!queue.isEmpty()){
                int[] o = queue.poll();
                int n = o[2];

                // 목표 지점 도착
                if(o[0]==P && o[1]==Q){
                    System.out.println(n);
                    break;
                }

                // 이동 가능 지점 탐색
                for (int i = 0; i < 8; i++) {    
                    int p = o[0]+dx[i];
                    int q = o[1]+dy[i];

                    if(p>=0 && q>=0 && p<I && q<I && !visited[p][q]){
                        visited[p][q] = true;
                        queue.add(new int[]{p,q,n+1});
                    }

                }
            }
        }
        
    }
}