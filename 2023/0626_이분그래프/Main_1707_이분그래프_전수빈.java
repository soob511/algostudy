package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_1707_이분그래프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int t = 0; t < tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            LinkedList<Integer>[] arr = new LinkedList[v];
            for (int i = 0; i <v; i++) {
                arr[i] = new LinkedList<>();
            }
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                arr[a].add(b);
                arr[b].add(a);
            }
            boolean result = true;
            int[] visit = new int[v];
            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i <v; i++) {
                if(visit[i]==0){
                    q.add(i);
                    visit[i] = 1;
                }
                while (!q.isEmpty()&&result){
                    int p = q.poll();
                    for (Integer a:arr[p]){
                        if(visit[a]==0){
                            q.add(a);
                            visit[a] = visit[p]*-1;
                        }else if(visit[a]==visit[p]){
                            result = false;
                            break;
                        }
                    }
                }
            }
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
