import java.util.*;
import java.io.*;

public class Main {

    static int[][][] DP = new int[21][21][21];;

    // DP 섞어서 함수 w 그대로 구현
    static int w(int a, int b, int c){
        if (a<=0 || b<=0 || c<=0)
            return 1;
        if (a>20 || b>20 || c>20)
            return w(20,20,20);
        if (DP[a][b][c] <= 0){
            if (a<b && b<c)
                DP[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
            else
                DP[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
        
        return DP[a][b][c];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (true){
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int c = Integer.parseInt(line[2]);

            // 종료 코드
            if (a==b && b==c && c==-1) return;

            // 계산, 출력
            System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a,b,c));

        }

        
    }
}
