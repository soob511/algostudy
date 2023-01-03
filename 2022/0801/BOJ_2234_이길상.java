import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] visited, info;
    static Map<Integer,Integer> room_space = new HashMap<>();

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    static int room_no = 0;
    static int room_max = 0;
    static int room_max2 = 0;

    static void bfs(int n, int m){
        room_no++; // 방 개수 증가
        
        int count = 0; // 방 넓이 카운트
        boolean[] room_near = new boolean[room_no];// 인접한 다른 방 체크

        // bfs 큐
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, m});

        //bfs
        visited[n][m] = room_no;
        while(!queue.isEmpty()){
            int[] e = queue.poll();
            int x = e[0], y = e[1];

            count++;

            for (int i = 0; i < 4; i++) {
                int bit = 1<<i;
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

                if ((info[x][y]&bit) == 0){
                    // 벽이 없고 미방문한 곳일 때
                    if (visited[nx][ny]==0) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = room_no;
                    }
                } 
                // 벽 너머가 방문한 다른 방인경우
                else if (visited[nx][ny]>0 && visited[nx][ny]!=room_no)
                    room_near[visited[nx][ny]] = true;
            }
        }

        // 가장 넓은 방의 넓이 갱신
        room_max = Math.max(room_max, count);

        // 가장 넓은 넓이 합 갱신
        for (int i = 1; i < room_no; i++) {
            if(room_near[i]){
                room_max2 = Math.max(room_max2, count + room_space.get(i));
            }
        }
        
        room_space.put(room_no, count);
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

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if(visited[n][m]==0)
                    bfs(n, m);
            }
        }

        System.out.println(room_no);
        System.out.println(room_max);
        System.out.println(room_max2);
    }
}
