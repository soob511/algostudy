import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1996_지뢰찾기_정승우 {
    static int N;
    static int map[][];
    static int res[][];
    static int[] dr= {-1,-1,-1,0,0,1,1,1};
    static int[] dc= {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        res = new int[N][N];
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for(int j=0; j<N; j++) {
                if(str.charAt(j)=='.') {
                    map[i][j] = 0;
                } else {
                    map[i][j] = str.charAt(j)-'0';
                }
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(1<=map[i][j]&&map[i][j]<=9) {
                    find(i,j);
                }
            }
        }

        for(int[] c : res) {
            for (int i : c) {
                if (i>=100) System.out.print('*');
                else if (i>=10) System.out.print('M');
                else System.out.print(i);
            }
            System.out.println();
        }
    }
    private static void find(int i, int j) {

        for(int d=0; d<8; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if(0<=nr&&nr<N&&0<=nc&&nc<N) {

                res[nr][nc] += map[i][j];
            }
        }
        res[i][j] = 100;
    }
}