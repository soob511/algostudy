import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1388_정승우 {
    static int N;
    static int M;
    static char[][] arr;
    static boolean[][] check;
    static int score = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        check = new boolean[N][M];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j=0; j<M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for(char[] c : arr) {
            System.out.println(Arrays.toString(c));
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(check[i][j]==false) {
                    DFS(i,j);
                }
            }
        }
        System.out.println(score);
    }

    private static void DFS(int i, int j) {

        if(j==M-1||i==N-1) {
            score+=1;
        }
        if(arr[i][j]=='-') {
            if(j+1<M && check[i][j]==false && arr[i][j+1]=='-') {
                check[i][j] = true;

                DFS(i,j+1);
            }
        } else {
            if(i+1<N && check[i][j]==false && arr[i+1][j]=='|') {
                check[i][j] = true;
                DFS(i+1, j);
            }
        }
    }
}
