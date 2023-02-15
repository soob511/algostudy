import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1931_회의실배정_정승우 {

    static class time {
        int a;
        int b;

        time(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "time{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<time> list = new ArrayList<>();
        int result = 0;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new time(a,b));
        }

        int a_cnt = 1;
        int b_cnt = 0;
        while(a_cnt<n) {
            int b = list.get(b_cnt).b;
            int a = list.get(a_cnt).a;
            if(a<b) {
                a_cnt++;
                continue;
            } else {
                b_cnt = a_cnt;
                a_cnt = b_cnt+1;
                result++;
            }
        }
        System.out.println(result);



    }
}
