package Samsung;

import java.io.*;
import java.util.*;

public class Main_15686_치킨배달 {
    static int n,m;
    static int[][] map;
    static boolean[] visit;
    static List<Point> p = new ArrayList<>();
    static List<Point> c = new ArrayList<>();
    static int result = Integer.MAX_VALUE;
    static class Point{
        int x;
        int y;

        Point(int x,int y){
            this.x = x;
            this.y= y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i <n; i++) {
            st =new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==1){//집 리스트에 저장
                    p.add(new Point(i,j));
                }else if(map[i][j]==2){//치킨 리스트에 저장
                    c.add(new Point(i,j));
                }
            }
        }

        visit = new boolean[c.size()];//치킨집 방문
        dfs(0,0);
        System.out.println(result);


    }

    private static void dfs(int count, int idx) {

        if(count==m){//m만큼 치킨집 살림
            int sum = 0;//치킨거리

            for(int i=0;i<p.size();i++){
                int min = Integer.MAX_VALUE;
                for (int j = 0; j <c.size(); j++) {
                    if(visit[j]){
                        int distance = Math.abs(p.get(i).x-c.get(j).x)+ Math.abs(p.get(i).y-c.get(j).y);
                        min = Math.min(min,distance);//집과 치킨집의 최소거리 계산
                    }
                }
                sum+=min;
            }
            result=Math.min(result,sum);//도시의 치킨거리 최소

            return;

        }

        //치킨 m 군데 뽑기
        for(int i=idx;i<c.size();i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(count+1,i+1);
                visit[i] = false;
            }
        }


    }
}
