import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1927_최소힙_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tmp;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<N; i++) {
            tmp = Integer.parseInt(br.readLine());
            if(tmp>0) {
                queue.add(tmp);
            } else {
                if(!queue.isEmpty()) {
                    System.out.println(queue.poll());
                } else {
                    System.out.println(0);
                }
            }
        }

    }
}
