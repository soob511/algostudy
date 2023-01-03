import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);

        int[] field = new int[100002];
        Arrays.fill(field, -1);

        int t = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(!queue.isEmpty()){
            // 순간이동(0초 소모)
            int L = queue.size();
            for (int i = 0; i < L; i++) {
                int n = queue.poll();
                
                for (int j = n; j < field.length; j*=2) {
                    if (field[j] == -1){
                        field[j] = t;
                        queue.add(j);
                    }
                    if (n==0) break;
                }
            }

            // 앞뒤이동(1초 소모)
            t++;
            L = queue.size();
            for (int i = 0; i < L; i++) {
                int n = queue.poll();

                if (n-1 >= 0 && field[n-1] == -1) queue.add(n-1);
                if (n+1 < field.length && field[n+1] == -1) queue.add(n+1);
            }
        }

        System.out.println(field[K]);
        
    }
}
