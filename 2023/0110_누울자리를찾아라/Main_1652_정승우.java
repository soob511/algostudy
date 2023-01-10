import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1652_누울자리를찾아라_정승우 {
    static int r,c =0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        char[][] map = new char[101][101];

        for(int i=0; i<N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
            map[i][N] = 'X';
            map[N][i] = 'X';
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N-1; j++) {

                if (map[i][j] == '.' && map[i][j+1]=='.' && map[i][j+2]=='X') {
                    r++;
                }
                if(map[j][i] == '.' && map[j+1][i] == '.' && map[j+2][i] == 'X') {
                    c++;
                }
            }
        }
        System.out.println(r + " " + c);


    }
}
