import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 지도
        boolean [][] field = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().replace(" ", "").toCharArray();
            for (int j = 0; j < N; j++) {
                field[i][j] = (line[j] == '1');
            }
        }

        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        // 육지 탐색용 t/f 배열
        boolean [][] check = new boolean[N][N];
        // 결과 저장 변수
        int answer = N*2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 섬 발견 방문 체크
                if(check[i][j]) continue;
                check[i][j] = true;

                // 육지 발견
                if(field[i][j]){
                    // 지도 전체 탐색용 t/f 배열
                    boolean [][] search = new boolean[N][N];
                    search[i][j] = true;
                    // 육지 체크용 큐
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    // 바다 확장 큐
                    Queue<int[]> queue2 = new LinkedList<>();

                    // 첫 육지 탐색
                    while(!queue.isEmpty()){
                        int[]e = queue.poll();
                        int x = e[0], y = e[1];

                        // 바다일 경우
                        if(!field[x][y]){
                            queue2.add(new int[]{x, y, 0});
                            continue;
                        }
                        // 바다로 나가기 전
                        else
                            check[i][j] = true;

                        for (int d = 0; d < 4; d++) {
                            int nx = x+dx[d];
                            int ny = y+dy[d];

                            // 범위 검사
                            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                            // 방문 검사
                            if(search[nx][ny]) continue;
                            search[nx][ny] = true;

                            queue.add(new int[]{nx, ny});
                        }
                    }

                    // 바다로 확장
                    while(!queue2.isEmpty()){
                        int[]e = queue2.poll();
                        int x = e[0], y = e[1], k = e[2];

                        // 바다일 경우
                        if(!field[x][y]) k++;
                        // 두번째 육지일 경우
                        else {
                            answer = Math.min(answer, k);
                            continue;
                        }

                        for (int d = 0; d < 4; d++) {
                            int nx = x+dx[d];
                            int ny = y+dy[d];

                            // 범위 검사
                            if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
                            // 방문 검사
                            if(search[nx][ny]) continue;
                            search[nx][ny] = true;

                            queue2.add(new int[]{nx, ny, k});
                        }
                    }
                }
            }
        }

        System.out.println(answer);
       
    }
}
