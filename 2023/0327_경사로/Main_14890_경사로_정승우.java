import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14890_경사로_정승우 {
    static int n,l;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n+1][n+1];


        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for(int i=1; i<=n; i++) {
            if(posible(i,0,0)) {
                cnt++;
            };
            if(posible(0,i,1)) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static boolean posible(int r, int c, int check) {
        int[] road = new int[n+1];
        boolean[] visit = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if (check == 0) {
                road[i] = map[r][i];
            } else {
                road[i] = map[i][c];
            }
        }

        for(int i=1; i<n; i++) {
            if(road[i] == road[i+1]) continue;

            else if(road[i]-1 == road[i+1]) {
                for (int j=i+1; j<i+1+l; j++) {
                    if (j > n) {
                        return false;
                    }
                    if (visit[j]) {
                        return false;
                    }
                    if (road[i+1] != road[j]) {
                        return false;
                    }
                    visit[j] = true;
                }
            }
            else if(road[i]+1 == road[i+1]) {
                for (int j=i; j>i-l; j--) {
                    if (j < 1) {
                        return false;
                    }
                    if (visit[j]) {
                        return false;
                    }
                    if (road[i] != road[j]) {
                        return false;
                    }
                    visit[j] = true;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
