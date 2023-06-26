import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프2_정승우 {
    static int tc,v,e;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph = new ArrayList<>();
            color = new int[v+1];

            for(int i=0; i<=v; i++) {
                graph.add(new ArrayList<>());
            }

            for(int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean rst = false;

            for(int i=1; i<=v; i++) {
                if(color[i] == 0) {
                    rst = bfs(i,1);
                }
                if(!rst) break;
            }
            if(rst) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static boolean bfs(int idx, int c) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        color[idx] = c;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int temp : graph.get(now)) {
                if(color[now]==color[temp]) {
                    return false;
                }
                if(color[temp]==0) {
                    color[temp] = color[now] * -1;
                    queue.add(temp);
                }
            }
        }
        return true;
    }
}
