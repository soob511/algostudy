import java.io.*;
import java.util.Arrays;

public class BOJ_3055_이길상 {
    static char[][] map;
    static int[][] watermap;

    static void flood(int r, int c, int t){
        if(r<0 || c<0 || r>= map.length || c>=map[0].length) return;
        if(t >= watermap[r][c] || map[r][c] == 'X' || map[r][c] == 'D') return;
        
        watermap[r][c] = t;
        flood(r+1, c, t+1);
        flood(r-1, c, t+1);
        flood(r, c+1, t+1);
        flood(r, c-1, t+1);
    }

    static int hedgehog(int r, int c, int t){
        if(r<0 || c<0 || r>= map.length || c>=map[0].length) return 3000;
        if(map[r][c] == 'D') return t;
        if(t >= watermap[r][c] || map[r][c] == 'X') return 3000;
        
        watermap[r][c] = t;
        return Math.min(
            Math.min(hedgehog(r+1, c, t+1),
                    hedgehog(r-1, c, t+1)),
            Math.min(hedgehog(r, c+1, t+1),
                    hedgehog(r, c-1, t+1))
        );
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숲의 크기 입력
        String[] line = br.readLine().split(" ");
        int R = Integer.parseInt(line[0]);
        int C = Integer.parseInt(line[1]);

        // 시작, 도착 위치
        int[] S = new int[2];

        // 지도 입력
        map = new char[R][];
        for (int r = 0; r < R; r++) {
            map[r] = br.readLine().toCharArray();
            for (int c = 0; c < C; c++) {
                if(map[r][c] == 'S'){
                    S[0] = r;
                    S[1] = c;
                }
            }
        }

        // 물이 차는 시간 지도
        watermap = new int[R][C];
        for (int r = 0; r < R; r++) {
            Arrays.fill(watermap[r], 3000);
        }

        // watermap 작성
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(map[r][c] == '*') flood(r, c, 0);
            }
        }

        // 고슴도치 시뮬레이션
        int result = hedgehog(S[0], S[1], 0);

        System.out.println(result>2500 ? "KAKTUS" : result);
    }
}
