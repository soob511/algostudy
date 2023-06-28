import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

public class Main_14395_4연산_정승우 {
    static long s,t;
    static long limit = 1000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        if(s==t) {
            System.out.println(0);
            return;
        }

        bfs();

    }
    static class Node {
        long num;
        String str;

        Node(long num, String str) {
            this.num = num;
            this.str = str;
        }
    }

    private static void bfs() {

        Queue<Node> q = new LinkedList<>();
        HashSet<Long> check = new HashSet<>();
        q.add(new Node(s,""));
        check.add(s);

        while(!q.isEmpty()) {

            Node n = q.poll();
            long num = n.num;
            String str = n.str;

            if(num==t) {
                System.out.println(str);
                return;
            }

            if(0<=num*num && num*num<=limit &&!check.contains(num*num)) {
                q.add(new Node(num*num, str+"*"));
                check.add(num*num);
            }
            if (0 <= num + num && num+num<=limit &&!check.contains(num + num)) {
                q.add(new Node(num+num, str+"+"));
                check.add(num+num);
            }
            if(num!= 0 && num-num<=limit &&0<= num-num && !check.contains(num-num)) {
                q.add(new Node(num-num, str+'-'));
                check.add(num-num);
            }
            if(num!= 0 &&num/num<=limit && 0<=num/num&&!check.contains(num/num)) {
                q.add(new Node(num/num, str+"/"));
                check.add(num/num);
            }
        }
        System.out.println(-1);
        return;
    }
}
