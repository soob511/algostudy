package Samsung;

import java.io.*;
import java.util.*;

public class Main_16235_나무제테크 {
    static int n, m, k;
    static int[][] food;
    static int[][] map;
    static ArrayList<Tree> tree = new ArrayList();
    static ArrayList<Tree> dead;
    static ArrayList<Tree> live;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         k = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        food = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                food[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            tree.add(new Tree(x, y, age));
        }
        while (k-- > 0) {
            live = new ArrayList<>();
            dead = new ArrayList<>();
            Collections.sort(tree);
            Spring();
            Summer();
            Fall();
            Winter();
        }
        System.out.println(tree.size());

    }

    private static void Winter() {
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                map[i][j] += food[i][j];
            }
        }
    }

    private static void Fall() {
        for (int i = 0; i < live.size(); i++) {
            Tree t = live.get(i);
            if (t.age % 5 == 0) {
                for (int j = 0; j < 8; j++) {
                    int nx = t.x + dx[j];
                    int ny = t.y + dy[j];
                    if(nx<0||ny<0||nx>=n||ny>=n)continue;
                    tree.add(new Tree(nx,ny,1));
                }
            }
        }
    }

    private static void Summer() {
        for (int i = 0; i < dead.size(); i++) {
            Tree t = dead.get(i);
            map[t.x][t.y] += t.age / 2;
        }
    }

    private static void Spring() {
        for (int i = 0; i < tree.size(); i++) {
            Tree t = tree.get(i);
            if (t.age > map[t.x][t.y]) {//나무 죽음
                dead.add(t);
            } else{
                map[t.x][t.y] -= t.age;
                t.age += 1;
                live.add(t);
            }
        }
        tree.clear();
        tree.addAll(live);
    }

    private static class Tree implements Comparable<Tree> {
        int x;
        int y;
        int age;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
}
