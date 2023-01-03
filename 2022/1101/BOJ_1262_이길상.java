import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int R1 = Integer.parseInt(line[1]);
        int C1 = Integer.parseInt(line[2]);
        int R2 = Integer.parseInt(line[3]);
        int C2 = Integer.parseInt(line[4]);

        int TILE = N*2 - 1;


        for (int r = R1; r <= R2; r++) {
            for (int c = C1; c <= C2; c++) {
                // 타일 내에서의 좌표
                int delta_r = r%TILE;
                int delta_c = c%TILE;

                // 중앙에서의 거리로 변환
                int distance = Math.abs(N-1 - delta_r) + Math.abs(N-1 - delta_c);

                // 거리가 N보다 작으면 알파벳
                if (distance < N){
                    sb.append((char)((int)'a' + distance%26));
                }
                // 아닐 경우 dot
                else{
                    sb.append('.');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
