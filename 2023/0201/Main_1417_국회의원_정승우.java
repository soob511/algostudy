import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1417_국회의원_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while(n-->1) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;
        while(!pq.isEmpty() && pq.peek() >= a) {
            cnt++;
            a++;
            pq.add(pq.poll()-1);
        }
        System.out.println(cnt);
    }
}
