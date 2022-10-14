package Samsung;

import java.util.*;
import java.io.*;

public class Main_15683_감시 {
    static int n, m;
    static int[][] map;
    static ArrayList<cctv> list;
    static int[] dx = {-1, 0, 1, 0};//상 우 하 좌
    static int[] dy = {0, 1, 0, -1};
    static int[] arr;
    static int[][] copymap;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        List<cctv> list = new ArrayList<>();

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {//cctv 리스트에 담기
                    list.add(new cctv(map[i][j], i, j));
                }

            }
        }
        arr= new int[list.size()];//순열 담을 배열
        per(0,list.size()); // 순열

//                for(int[] b:map) System.out.println(Arrays.toString(b));
//        System.out.println();
        System.out.println(answer);

    }

    private static void per(int count, int r) { //상하좌우 4방향 중 cctv의 개수 만큼 순열
        if(count==r){
            copymap = new int[n][m];
            for (int i = 0; i <n; i++) { //카피맵생성
                for (int j = 0; j <m; j++) {
                    copymap[i][j] = map[i][j];
                }
            }
            for(int i=0;i<list.size();i++){
                direction(list.get(i),arr[i]);
            }
            result();
            return;
        }

        for(int i=0;i<4;i++){
            arr[count] = i;
            per(count+1,r);
        }



    }

    private static void result() {

        int cnt =0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m; j++) {
                if (copymap[i][j]==0){
                    cnt++;
                }
            }
        }
        answer = Math.min(answer,cnt);
    }

    private static void direction(cctv cctv, int d) {
        int cctvnum = cctv.num;

        if(cctvnum==1){//한방향
            if(d==0) watch(cctv,0);//상
            else if (d==1)  watch(cctv,1);//우
            else if (d==2)  watch(cctv,2);//하
            else if (d==3)  watch(cctv,3);//좌

        }else if(cctvnum==2){//반대방향
            if(d==0||d==2){
                watch(cctv,0);
                watch(cctv,2);
            }else if (d==1||d==3){
                watch(cctv,1);
                watch(cctv,3);
            }

        }else if(cctvnum==3){//직각
            if (d==0){
                watch(cctv,0);
                watch(cctv,1);
            }else if(d==1){
                watch(cctv,1);
                watch(cctv,2);
            }else if(d==2){
                watch(cctv,2);
                watch(cctv,3);
            }else if(d==3){
                watch(cctv,3);
                watch(cctv,0);
            }

        }else if(cctvnum==4){//세방향

            if (d==0){
                watch(cctv,0);
                watch(cctv,1);
                watch(cctv,3);
            }else if(d==1){
                watch(cctv,0);
                watch(cctv,1);
                watch(cctv,2);
            }else if(d==2){
                watch(cctv,1);
                watch(cctv,2);
                watch(cctv,3);
            }else if(d==3){
                watch(cctv,2);
                watch(cctv,3);
                watch(cctv,0);
            }


        }else if(cctvnum==5){//상하좌우
                watch(cctv,0);
                watch(cctv,1);
                watch(cctv,2);
                watch(cctv,3);
        }



    }

    private static void watch(cctv cctv, int d) {
        Queue<cctv> q = new LinkedList<>();
        boolean[][] visit = new boolean[n][m];

        q.add(cctv);
        visit[cctv.x][cctv.y] = true;

        while (!q.isEmpty()){
            int nx = q.poll().x+dx[d];
            int ny = q.poll().y+dy[d];

            if(nx<0||ny<0||nx>=n||ny>m||copymap[nx][ny]==6){
                break;
            }
            if (copymap[nx][ny]==0){
                copymap[nx][ny] =-1;
                q.add(new cctv(cctv.num,nx,ny));
            }else{
                q.add(new cctv(cctv.num,nx,ny));
            }

        }


    }


}
    class cctv{
        int num;
        int x;
        int y;

        cctv(int num,int x,int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }

}
