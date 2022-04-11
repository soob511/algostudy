import java.io.*;
import java.util.*;

public class Main_BJ_14502_연구소_이길상 {
    static int N, M, area = 0, max = 0;
    static int[][] map;
    static List<int[]> virus = new ArrayList<>();

    // bfs
    static void safearea(){
        boolean[][] check = new boolean[N][M];
        int wasteland = 0;

        Queue<int[]> queue = new LinkedList<>();
        for (int[] i : virus) queue.add(i);
        
        while(!queue.isEmpty()){
            int[] p = queue.poll();
            int r = p[0], c = p[1];

            if(r<0 || r>=N || c<0 || c>=M) continue;
            if(check[r][c]) continue;
            if(map[r][c] == 1) continue;

            check[r][c] = true;
            if(map[r][c] == 0) wasteland++;

            queue.add(new int[]{r+1, c});
            queue.add(new int[]{r-1, c});
            queue.add(new int[]{r, c+1});
            queue.add(new int[]{r, c-1});
        }

        max = Math.max(max, area - wasteland - 3);
    }

    // backtracking
    static void wall(int i, int count){
        if(count == 3){
            // check current safearea
            safearea();
            return;
        }

        while(i < N*M){
            int r = i/M, c = i%M;
            if(map[r][c] == 0){
                map[r][c] = 1;
                wall(i+1, count+1);
                map[r][c] = 0;
            }
            i++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input N, M
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        // input map info
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);

                // count safearea
                if(map[i][j] == 0) area++;
                // add viruslocation
                if(map[i][j] == 2) virus.add(new int[]{i, j});
            }
        }

        // backtracking
        wall(0, 0);

        System.out.println(max);
    }
}
