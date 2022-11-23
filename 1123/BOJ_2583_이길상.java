import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int M, N, K;
    static boolean[][] field;
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄 입력
		String[] line = br.readLine().split(" ");
        M = Integer.parseInt(line[0]);
        N = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        // 전체 영역 배열
        field = new boolean[N][M];

        // 직사각형 부분 True로 바꾸기

        for (int k = 0; k < K; k++) {
            line = br.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            int X = Integer.parseInt(line[2]);
            int Y = Integer.parseInt(line[3]);

            for (int n = x; n < X; n++) {
                for (int m = y; m < Y; m++) {
                    field[n][m] = true;
                }
            }
        }

        // dfs or bfs
        List<Integer> list = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (field[n][m]) continue;
                // list.add(dfs(n, m));
                list.add(bfs(n, m));
            }
        }
        list.sort(null);
        
        System.out.println(list.size());
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
	}

    static int dfs(int x, int y){
        field[x][y] = true;
        int area = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx<0 || ny<0 || nx==N || ny==M) continue;
            if (field[nx][ny]) continue;

            area += dfs(nx,ny);
        }
        
        return area;
    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        field[x][y] = true;

        int area = 0;
        while(!queue.isEmpty()){
            int[] e = queue.poll();
            area+=1;
            for (int i = 0; i < 4; i++) {
                int nx = e[0] + dx[i];
                int ny = e[1] + dy[i];
                
                if (nx<0 || ny<0 || nx==N || ny==M) continue;
                if (field[nx][ny]) continue;
                field[nx][ny] = true;
    
                queue.add(new int[]{nx, ny});
            }
        }

        return area;
    }

}
