import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2096_내려가기_정승우 {
    static int n;
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][3];
        int[][] max = new int[n][3];
        int[][] min = new int[n][3];

        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        max[0][0] = min[0][0] = map[0][0];
        max[0][1] = min[0][1] = map[0][1];
        max[0][2] = min[0][2] = map[0][2];

        for(int i=1; i<n; i++) {
            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + map[i][0];
            max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + map[i][1];
            max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + map[i][2];

            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + map[i][0];
            min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + map[i][1];
            min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + map[i][2];

        }

        int ma = Math.max(Math.max(max[n-1][0], max[n-1][1]), max[n-1][2]);
        int mi = Math.min(Math.min(min[n-1][0], min[n-1][1]), min[n-1][2]);

        System.out.println(ma + " " + mi);

    }
}
