package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_16928_뱀과사다리게임 {
    static int[] ls = new int[101];
    static int[] count = new int[101];
    static boolean[] visit = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //사다리수
        int m = Integer.parseInt(st.nextToken()); // 뱀의수

        for(int i=0;i<n+m;i++){//사다리와 뱀 위치 입력
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ls[a] =b;
        }

        bfs();

    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1); //1부터 시작
        count[1] =0;
        visit[1] = true;

        while (!q.isEmpty()){
            int x = q.poll();
            if(x==100){//100에 도착하면 끝
                System.out.println(count[x]);
                return;
            }

            for(int i=1;i<=6;i++){//주사위 돌림
                int nx = x+i;
                if(nx>100) continue;//100보다 크면 이동불가
                if(visit[nx])continue;//방문했으면 스킵

                visit[nx] = true; //방문체크

                if(ls[nx]!=0){ //뱀이나 사다리가 있다면
                    if(!visit[ls[nx]]){//방문하지 않음
                        q.add(ls[nx]); //이동
                        visit[ls[nx]] = true;
                        count[ls[nx]] = count[x]+1;
                    }
                }else{
                    q.add(nx);
                    count[nx] = count[x]+1;
                }
            }
        }
    }
}
