import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main_1715_카드정렬하기_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        if(n==1) {
            System.out.println(0);
        } else {
            Queue<Integer> pq = new PriorityQueue<>();

            for(int i=0; i<n; i++) {
                int num = Integer.parseInt(br.readLine());
                pq.add(num);
            }
            int cnt = 0;
            while(!pq.isEmpty()) {
                if(pq.size()==1) break;

                int a = pq.poll();
                int b = pq.poll();
                cnt += (a+b);
                pq.add(a+b);
            }
            System.out.println(cnt);
        }


    }
}
