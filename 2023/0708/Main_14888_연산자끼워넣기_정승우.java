import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기_정승우 {
    static int n;
    static int[] number;
    static int[] four = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        number = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) {
            four[i] = Integer.parseInt(st.nextToken());
        }
        //넘겨야할 인자 0 = cnt 주어진 숫자를 다 쓴 경우
        //res 는 저장되는 값 넘긴것
        dfs(number[0],1);
        System.out.println(max);
        System.out.println(min);

    }

    private static void dfs(int res, int idx) {
        if(idx==number.length) {
            if(min>res) min = res;
            if(max<res) max = res;
            return;
        }

        for(int i=0; i<4; i++) {
            if(four[i]>0) {
                four[i]--;

                switch (i) {
                    case 0:
                        dfs(res+number[idx], idx+1);
                        break;
                    case 1:
                        dfs(res-number[idx], idx+1);
                        break;
                    case 2:
                        dfs(res*number[idx], idx+1);
                        break;
                    case 3:
                        dfs(res/number[idx], idx+1);
                        break;
                }
                four[i]++;
            }
        }



    }
}
