import java.io.*;
import java.util.*;

public class BOJ_14569_이길상 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input N
        int N = Integer.parseInt(br.readLine());

        // input schedule
        long[] lecture = new long[N];
        for (int n = 0; n < N; n++) {
            String[] line = br.readLine().split(" ");
            int k = Integer.parseInt(line[0]);
            for (int i = 1; i <= k; i++) {
                lecture[n] += (1L << Integer.parseInt(line[i]));
            }
        }

        // input M
        int M = Integer.parseInt(br.readLine());

        // input schedule
        long[] student = new long[M];
        for (int m = 0; m < M; m++) {
            String[] line = br.readLine().split(" ");
            int p = Integer.parseInt(line[0]);
            for (int i = 1; i <= p; i++) {
                student[m] += (1L << Integer.parseInt(line[i]));
            }
        }

        // calculate
        for (long s : student) {
            int count = 0;
            for (long l : lecture) {
                if((s|l) == s) count++;
            }
            System.out.println(count);
        }
          
    }
}
