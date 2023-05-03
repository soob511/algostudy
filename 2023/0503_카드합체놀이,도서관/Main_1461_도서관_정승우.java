import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1461_도서관_정승우 {
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mq = new PriorityQueue<>() ;

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur>=0) {
                pq.add(cur);
            } else {
                mq.add(cur);
            }
        }

        int tmp = 0;
        int sum = 0;

        if(!mq.isEmpty()&&!pq.isEmpty()) {
            if(Math.abs(pq.peek())>Math.abs(mq.peek())) {
                tmp = pq.peek();
                for(int i=0; i<m; i++) {
                    pq.poll();
                }
            } else {
                tmp = Math.abs(mq.peek());
                for(int i=0; i<m; i++) {
                    mq.poll();
                }
            }
        } else if(!pq.isEmpty()&&mq.isEmpty()) {
            tmp = pq.peek();
            for(int i=0; i<m; i++) {
                pq.poll();
            }
        } else if(pq.isEmpty()&&!mq.isEmpty()){
            tmp = Math.abs(mq.peek());
            for(int i=0; i<m; i++) {
                mq.poll();
            }
        }



        while(!pq.isEmpty()) {
            sum += pq.peek()*2;
            for(int i=0; i<m; i++) {
                pq.poll();
            }
        };

        while(!mq.isEmpty()) {
            sum += Math.abs(mq.peek())*2;
                for(int i=0; i<m; i++) {
                    mq.poll();
                }
            }

        sum+=tmp;
        System.out.println(sum);


    }
}
