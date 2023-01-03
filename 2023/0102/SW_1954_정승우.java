import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SW_1954_정승우 {
    static int dr[] = {0, 1, 0, -1};
    static int dc[] = {1, 0, -1, 0};
    static int arr[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for (int tc=0; tc<T; tc++) {

            int N = sc.nextInt();
            int dir = 0;
            int r = 0;
            int c = 0;

            for(int i=1; i<=N*N; i++) {

                arr[r][c] = i;
                int nr = r+dr[dir];
                int nc = c+dc[dir];
                if(nr<0 || nr>=N || nc<0 || nc>=N || arr[nr][nc]!=0) {

                    dir = ++dir%4;
                }
                r = r+dr[dir];
                c = c+dc[dir];
            }
            sb.append("#"+tc+"\n");
            for(int [] a : arr) {
                for(int el : a) {
                    sb.append(el+" ");
                }
            }
        }
    }
}
