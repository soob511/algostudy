import java.io.*;
import java.util.*;

public class BOJ_16234_이길상 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // first line
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);
        int R = Integer.parseInt(line[2]);


        int[][] land = new int[N][N];

        // input land info
        for (int r = 0; r < N; r++) {
            line = br.readLine().split(" ");
            for (int c = 0; c < N; c++) {
                land[r][c] = Integer.parseInt(line[c]);
            }
        }

        // migration
        int day = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        while(true) {
            int[][] union = new int[N][N];
            int union_no = 0;
            int gate_opened = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if(union[r][c] == 0){
                        union_no++;
    
                        Queue<int[]> queue = new LinkedList<>();
                        List<int[]> list = new ArrayList<>();
    
                        int sum = 0;
    
                        queue.add(new int[]{r, c});
                        while(!queue.isEmpty()){
                            int[] e = queue.poll();
                            union[e[0]][e[1]] = union_no;
    
                            list.add(new int[]{e[0],e[1]});
                            sum += land[e[0]][e[1]];
    
                            for (int i = 0; i < 4; i++) {
                                int x = e[0] + dx[i];
                                int y = e[1] + dy[i];
    
                                if(x<0 || x>=N || y<0 || y>=N) continue;
                                if(union[x][y] > 0) continue;
                                
                                int gap = Math.abs(land[e[0]][e[1]] - land[x][y]);
                                if(gap >= L && gap <= R){
                                    queue.add(new int[]{x, y});
                                    gate_opened++;
                                }
                            }
                        }
    
                        int avg = sum/list.size();
                        for (int[] e : list) {
                            land[e[0]][e[1]] = avg;
                        }
                    }
                }
            }

            if(gate_opened>0) day++;
            else break;
        }
        System.out.println(day);
    }
}
