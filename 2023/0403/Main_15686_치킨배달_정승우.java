import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_치킨배달_정승우 {
    static int n,m;
    static int[][] map;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static ArrayList<int[]> res = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) {
                    house.add(new int[]{i,j});
                }
                if(map[i][j]==2) {
                    chicken.add(new int[]{i,j});
                }
            }
        }

        dfs(0,0);
        System.out.println(ans);
    }

    private static void dfs(int cnt, int idx) {
        if(cnt==m) {
            int sum = 0;
            for(int[] h : house) {
                int min = Integer.MAX_VALUE;
                for(int[] r : res) {
                    int a = Math.abs(h[0] - r[0]) + Math.abs(h[1] - r[1]);
                    min = Math.min(a,min);
                }
                sum += min;
            }
            ans = Math.min(ans, sum);
            return;
        }

        for(int i = idx; i<chicken.size(); i++) {

                res.add(chicken.get(i));
                dfs(cnt+1, idx+1);
                res.remove(res.size()-1);


        }
    }
}
