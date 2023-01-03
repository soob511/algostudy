import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int n = 0; n < N; n++) {
            pq.add(Long.parseLong(br.readLine()));
        }

        while (pq.size() > 1){
            long sum = pq.poll() + pq.poll();
            answer += sum;
            pq.add(sum);

        }

        System.out.println(answer);
    }
}
