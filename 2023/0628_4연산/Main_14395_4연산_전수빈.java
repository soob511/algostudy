package dfs_bfs;

import java.io.*;
import java.util.*;

public class Main_14395_4연산 {
    static long s,t;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         s = Long.parseLong(st.nextToken());
         t = Long.parseLong(st.nextToken());
        bfs(s,t);
    }

    private static void bfs(long start, long result) {
        String[] arr = new String[]{"*","+","-","/"};
        HashSet<Long> set = new HashSet<>();
        if(start==result){
            System.out.println("0");
            return;
        }
        Queue<Num> q = new LinkedList<>();
        set.add(start);
        q.add(new Num(start,""));
        while (!q.isEmpty()){
            Num now = q.poll();

            long nowNum =  now.num;
            String nowStr = now.str;

            long nextNum = nowNum;

            if(nowNum==result){
                System.out.println(nowStr);
                return;
            }
            for (int i = 0; i <4; i++) {
                switch (i){
                    case 0:
                        nextNum = nowNum * nowNum;
                        break;
                    case 1:
                        nextNum = nowNum + nowNum;
                        break;
                    case 2:
                        nextNum = nowNum - nowNum;
                        break;
                    case 3:
                        if(nowNum != 0) {
                            nextNum = nowNum / nowNum;
                        }
                        break;
                }
                if(!set.contains(nextNum)){
                    set.add(nextNum);
                    q.add(new Num(nextNum, nowStr+arr[i]));
                }
            }
        }
        System.out.println("-1");
        return;
    }
    static class Num{
        long num;
        String str = "";
        Num(long num, String str){
            this.num = num;
            this.str = str;
        }
    }

}
