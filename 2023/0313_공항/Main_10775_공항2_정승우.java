import java.util.*;
import java.io.*;

public class Main_10775_공항2_정승우 {
    public static int g, p;
    public static int[] parent;
    public static void main(String[] argc) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        g = Integer.parseInt(br.readLine());
        p = Integer.parseInt(br.readLine());

        parent = new int[g + 1];

        // 초기값 설정
        for (int i = 0; i <= g ; i++) {
            parent[i] = i;
        }

        int count = 0;
        for (int i = 0; i < p ; i++) {
            int now = Integer.parseInt(br.readLine());

            int p = find(now);
            if(p != 0){
                union(p, p - 1);
                count++;
            }
            else
                break;
        }

        System.out.println(count);
    }


    public static int find(int now) {
        if(now == parent[now])
            return now;
        return parent[now] = find(parent[now]);
    }


    public static void union(int x, int y) {
        //x,y의 부모값을 구한 후 더 작은 값으로 합친다다
       x = find(x);
        y = find(y);

        if(x != y) {
            parent[x] = y;
        }
    }
}
