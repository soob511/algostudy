package Samsung;

import java.util.*;
import java.io.*;
public class Main_14889_스타트와링크 {
    static int n;
    static int[][] map;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visit = new boolean[n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combi(-1,0);
        System.out.println(min);

        }

    private static void combi(int idx, int count) {
        if(count==n/2){
            power();
            return;
        }

        for(int i=idx+1;i<n;i++){
            if (!visit[i]){

                visit[i] = true;
                combi(idx+1,count+1);
                visit[i]= false;
            }
        }
    }

    private static void power() {
        int start = 0;
        int link =0;
        for (int i = 0; i <n-1; i++) {
            for (int j = i+1; j <n; j++) {

                if(visit[i]==true &&visit[j]==true){
                    start+=map[i][j];
                    start+=map[j][i];
                }else if(visit[i]==false&&visit[j]==false){
                    link +=map[i][j];
                    link+=map[j][i];
                }
            }
        }

        min = Math.min(min,Math.abs(start-link));


    }

}
