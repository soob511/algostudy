package 코드트리;

import java.io.*;
import java.util.*;

public class Main_메이즈러너 {
    static int[] dx = {-1, 1, 0, 0};//상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Person> person = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            person.add(new Person(x, y, 0));
        }

        //출구좌표
        st = new StringTokenizer(br.readLine());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;
        map[ex][ey] = -1;

        //참가자와 출구 사이 거리
        for (int i = 0; i < person.size(); i++) {
            Person p = person.get(i);
            int dist = Math.abs(p.x - ex) + Math.abs(p.y - ey);
            p.dist = dist;
        }

        int result = 0;
        while (K-- > 0) {
            //움직임

            for (int i = 0; i < person.size(); i++) {
                Person p = person.get(i);
                if(p.dist !=0){
                    int x = p.x;
                    int y = p.y;
                    int min = 1000;
                    int d = 0;
                    for (int j = 0; j < 4; j++) {
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] > 0) continue;//범위벗어나거나 벽이면
                        int dist = Math.abs(nx - ex) + Math.abs(ny - ey);
                        if (dist < p.dist && dist < min) {//현재 머물러 있던 칸보다 최단거리 가깝고, 상하 우선
                            min = dist;
                            d = j;
                        }
                    }
                    if (min != 1000) {//움직있을수있을때만 움직임
                        p.x = x + dx[d];
                        p.y = y + dy[d];
                        result += 1;
                        p.dist = min;
                    }
                    if (p.x == ex && p.y == ey) { //탈출
                        p.x = -1;
                        p.y = -1;//이동거리합
                        p.dist = 0;
                    }
                }
            }
            int count=0;
            //모듣 참가자 탈출하면 끝!
            for (int i = 0; i < person.size(); i++) {
                Person p = person.get(i);
                if(p.dist==0){
                    count++;
                }
            }
            if(count==M){
                break;
            }
            int sx = 0;
            int sy = 0;
            int sz = 0;
            //정사각형 잡기
            all:
            for (int s = 1; s < N; s++) {
                for (int i = 0; i < N - s; i++) {
                    for (int j = 0; j < N - s; j++) {
                        int si = i + s;
                        int sj = j + s;
                        if ((i <= ex && ex <= si) && (j <= ey && ey <= sj)) {//탈출구 포함
                            for (int k = 0; k < person.size(); k++) {
                                Person p = person.get(k);
                                if ((i <= p.x && p.x <= si) && (j <= p.y && p.y <= sj)) {//참가자 포함
                                    sx = i;
                                    sy = j;
                                    sz = s;
                                    break all;
                                }
                            }
                        }
                    }
                }
            }
            //미로회전
            int[][] temp = new int[N][N];
            for (int i = sx; i <= sx + sz; i++) {
                for (int j = sy; j <= sy + sz; j++) {
                    int x = i-sx;
                    int y = j-sy;
                    int nx = y;
                    int ny = sz-x;
                    temp[nx+sx][ny+sy] = map[i][j];
                }
            }
            for (int i = sx; i <= sx + sz; i++) {
                for (int j = sy; j <= sy + sz; j++) {
                    if (temp[i][j] > 0) {//내구도 깎임
                        temp[i][j]--;
                    }
                    if (temp[i][j] == -1) {//탈출구 이동
                        ex = i;
                        ey = j;
                    }
                    map[i][j] = temp[i][j];
                }
            }
            //for (int[] b:map) System.out.println(Arrays.toString(b));System.out.println();
            //참가자 회전
            for (int i = 0; i < person.size(); i++) {
                Person p = person.get(i);
                int x = p.x;
                int y = p.y;
                if ((sx <= p.x && p.x <= sx + sz) && (sy <= p.y && p.y <= sy + sz)) {//정사각형에 포함된 참가자만
                    int tx = x-sx;
                    int ty = y-sy;
                    int nx = ty;
                    int ny = sz - tx;
                    p.x = nx+sx;
                    p.y = ny+sy;
                }
            }
            //출구와의 거리 갱신
            for (int i = 0; i < person.size(); i++) {
                Person p = person.get(i);
                int dist = Math.abs(p.x - ex) + Math.abs(p.y - ey);
                p.dist = dist;
            }

        }
        System.out.println(result);
        System.out.println((ex+1)+ " " +(ey+1));
    }

    private static class Person {
        int x;
        int y;
        int dist;

        public Person(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}
