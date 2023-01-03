import java.io.*;
import java.util.*;

public class BOJ_2468_이길상 {

    static void fill_area(boolean[][] info, int i, int j){
        if(i<0 || j<0 || i>=info.length || j>=info.length || info[i][j]) return;

        info[i][j] = true;

        fill_area(info, i-1, j);
        fill_area(info, i+1, j);
        fill_area(info, i, j-1);
        fill_area(info, i, j+1);        
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 지역 너비 입력
        int N = Integer.parseInt(br.readLine());

        // 지역 정보
        int[][] area = new int[N][N];
        int max_h = 2, min_h = 100;
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(line[j]);

                max_h = Math.max(max_h, area[i][j]);
                min_h = Math.min(min_h, area[i][j]);
            }
        }
        
        // 높이별로 계산
        int answer = 0;
        for (int k = min_h; k < max_h; k++) {
            // 물에 잠긴 영역 표시
            boolean[][] info = new boolean[N][N];       
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(area[i][j] <= k) info[i][j] = true;
                }
            }

            // 안전영역 개수 세기
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!info[i][j]){
                        count++;
                        fill_area(info, i, j);
                    }
                }
            }

            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}