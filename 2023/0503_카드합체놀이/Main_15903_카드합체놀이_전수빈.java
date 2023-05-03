package greedy;

import java.io.*;
import java.util.*;

public class Main_15903_카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            long num = Long.parseLong(st.nextToken());
            pq.add(num);
        }
        while (m-->0){
            long x = pq.poll();
            long y = pq.poll();
            long sum = x+y;
            pq.add(sum);
            pq.add(sum);
        }
        long sum = 0;
        int size = pq.size();
        for (int i = 0; i <size; i++) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
