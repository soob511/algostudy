import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] visited, info;

    static int room_no = 0;
    static int room_max = 0;
    static int room_max2 = 0;

    static int bfs(int n, int m){
        room_no++; // 방 개수 증가
        
        int count = 0; // 방 넓이 카운트

        int room_near = 0; // 인접한 방의 최대 넓이

        // bfs 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, m});

        //bfs
        visited[n][m] = room_no;
        while(!queue.isEmpty()){
            int[] e = queue.poll();
            int x = e[0], y = e[1];

            count++;

            int wall = info[x][y];
            if ((wall&1) == 0){
                // 벽이 없고 미방문한 곳일 때
                if (visited[x][y-1]==0) {
                    queue.add(new int[]{x, y-1});
                    visited[x][y=1] = room_no;
                }
            } 
            // 벽 너머가 미방문한 다른 방인경우
            else if (y-1>=0 && visited[x][y-1]==0 && visited[x][y-1]!=room_no)
                room_near = Math.max(room_near, bfs(x, y-1));

            if ((wall&2) == 0){
                if (visited[x-1][y]==0) {
                    queue.add(new int[]{x-1, y});
                    visited[x-1][y] = room_no;
                }
            }
            else if (x-1>=0 && visited[x-1][y]==0 && visited[x-1][y]!=room_no)
                room_near = Math.max(room_near, bfs(x-1, y));

            if ((wall&4) == 0){
                if(visited[x][y+1]==0) {
                    queue.add(new int[]{x, y+1});
                    visited[x][y+1] = room_no;
                }
            }
            else if (y+1<M && visited[x][y+1]==0 && visited[x][y+1]!=room_no)
                room_near = Math.max(room_near, bfs(x, y+1));
            
            if ((wall&8) == 0){
                if(visited[x+1][y]==0) {
                    queue.add(new int[]{x+1, y});
                    visited[x+1][y] = room_no;
                }
            }
            else if (x+1<N && visited[x+1][y]==0 && visited[x+1][y]!=room_no)
                room_near = Math.max(room_near, bfs(x+1, y));
        }

        room_max = Math.max(room_max, count); // 가장 넓은 방의 넓이 갱신
        room_max2 = Math.max(room_max2, count + room_near);
        return count;
    }

    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);

        visited = new int[N][M]; // 방문 확인
        info = new int[N][M]; // 벽 정보

        // 벽 정보 입력
        for (int n = 0; n < N; n++) {
            line = br.readLine().split(" ");
            for (int m = 0; m < M; m++) {
                info[n][m] = Integer.parseInt(line[m]);
            }
        }

        bfs(0, 0);

        System.out.println(room_no);
        System.out.println(room_max);
        System.out.println(room_max2);
    }
}
