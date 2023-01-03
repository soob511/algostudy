import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14890_정승우 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] map1 = new int[N][N];
        int[][] map2 = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                int value = Integer.parseInt(st.nextToken());
                //가로 세로 한번에 받으려고
                map1[i][j] = value;
                map2[j][i] = value;
            }
        }

        for(int[] a : map1) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println("--------------------------------");
        for(int[] a : map2) {
            System.out.println(Arrays.toString(a));
        }

        for(int i=0; i<N; i++) {

        }

    }
}
