import java.io.*;
import java.lang.annotation.Retention;
import java.util.*;

public class BOJ_20058_이길상 {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input N, Q
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int Q = Integer.parseInt(line[1]);

        // 한 변의 길이
        int S = 1<<N;

        //ice
        int[][] A = new int[S][S];
        for (int i = 0; i < S; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < S; j++) {
                A[i][j] = Integer.parseInt(line[j]);
            }
        }

        // input L_i
        line = br.readLine().split(" ");
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(line[i]);

            // 회전
            A = turn(A, S, L);

            // 얼음 양 변화
            A = melt(A, S);
        }

        // 계산
        int[] result = ice(A, S);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static int[][] turn(int[][] A, int S, int L){
        int[][] result = new int[S][S];

        // 격자의 한 변
        L = 1<<L;

        // 격자 나누기
        for (int r = 0; r < S; r+=L) {
            for (int c = 0; c < S; c+=L) {
                
                // 격자 회전
                for (int x = r; x < r + L; x++) {
                    for (int y = c; y < c + L; y++) {
                        result[y + r-c][r+c + L-1 -x] = A[x][y];
                    }
                }

            }
        }

        return result;
    }

    static int[][] melt(int[][] A, int S){
        int[][] result = new int[S][S];
        
        for (int r = 0; r < S; r++) {
            for (int c = 0; c < S; c++) {
                int ice = 0;

                // 주변 얼음 세기
                for (int i = 0; i < 4; i++) {
                    int x = r + dx[i];
                    int y = c + dy[i];

                    if(x<0 || x==S || y<0 || y==S) continue;
                    if(A[x][y] > 0) ice++;
                }

                result[r][c] = A[r][c];
                if(ice < 3 && result[r][c]>0) result[r][c]--;
            }
        }

        return result;
    }

    static int[] ice(int[][] A, int S){
        int sum = 0;
        int block = 0;

        boolean[][] check = new boolean[S][S];

        for (int r = 0; r < S; r++) {
            for (int c = 0; c < S; c++) {
                if(check[r][c]) continue;
                if(A[r][c] == 0) continue;

                int count = 1;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{r,c});
                check[r][c] = true;

                while(!queue.isEmpty()){
                    int[] e = queue.poll();
                    sum+=A[e[0]][e[1]];

                    for (int i = 0; i < 4; i++) {
                        int x = e[0] + dx[i];
                        int y = e[1] + dy[i];
    
                        if(x<0 || x==S || y<0 || y==S) continue;
                        if(check[x][y]) continue;
                        if(A[x][y] == 0) continue;
  
                        queue.add(new int[]{x,y});
                        check[x][y] = true;
                        count++;
                    }
                }

                block = Math.max(count, block);
            }
        }

        return new int[]{sum, block};
    }
}
