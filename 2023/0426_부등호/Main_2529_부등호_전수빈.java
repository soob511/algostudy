package Bruteforce;

import java.io.*;
import java.util.*;

public class Main_2529_부등호 {
    static int[] arr;
    static int k;
    static boolean[] visit;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         k = Integer.parseInt(br.readLine());
        arr = new int[k];
        String s = br.readLine();
        String[] c = s.split(" ");
        for (int i = 0; i <k; i++) {
            if(c[i].equals("<")){
                arr[i] = 1;
            }else{
                arr[i] = 0;
            }
        }
        for (int i = 0; i <10; i++) {
            visit = new boolean[10];
            visit[i] = true;
            dfs(0,i,i+"");
        }
        Collections.sort(list);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    private static void dfs(int cnt,int start,String result) {
        if(cnt==k){
            list.add(result);
            return;
        }
        for (int i =0; i <10; i++) {
            if(visit[i]){
                continue;
            }
            if((arr[cnt]==1&&start<i)||(arr[cnt]==0&&start>i)){
                visit[i] = true;
                dfs(cnt+1,i, result+i);
                visit[i] = false;
            }
        }
    }
}
