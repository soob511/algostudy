import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결_정승우 {
    static int v,e;
    static int[] parent;
    static int[][] graph;
    static int cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());
        e = Integer.parseInt(br.readLine());
        graph = new int[e][4];

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
            graph[i][3] = Integer.parseInt(st.nextToken());
        }
        parent = new int[v+1];
        cost = 0;
        Arrays.sort(graph,(o1, o2) ->Integer.compare(o1[3], o2[3]));

//        for(int[] a : graph) {
//            System.out.println(Arrays.toString(a));
//        }

        // 자기자신을 집합의 대표로
        for(int i=1; i<=v; i++) {
            parent[i] = i;
        }

        //
        for(int i=0; i<e; i++) {
            int min = graph[i][3];
            int a = graph[i][1];
            int b = graph[i][2];
            if(find(graph[i][1]) != find(graph[i][2])) {
                union(a, b);
                cost += min;
            }
        }

        System.out.println(cost);

    }

    //값이 자기가 가진 값과 같으면 return 아니면 재귀
    private static int find(int a) {
        if(parent[a] == a) {
            return a;
        } else {
            return find(parent[a]);
        }
    }

    //두개의 값을 비교후 더 작은값으로 합친다
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a>b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }

    }
}
