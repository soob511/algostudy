package Samsung;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main_14890_경사로 {
    static int n,l;
    static int[][] map;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         l = Integer.parseInt(st.nextToken());
         map = new int[n][n];
        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i <n; i++) {
          if(check(i,0,true)){
              count++;
          }else if(check(0,i,false)){
              count++;
            }
        }
        System.out.println(count);
    }

    private static boolean check(int x, int y, boolean row) {
        int[] height = new int[n];
        boolean[] visit = new boolean[n];
        for (int i = 0; i <n; i++) {
            if(row){
                height[i] = map[x][i];
            }else{
                height[i] = map[i][y];
            }
        }
        for (int i = 0; i <n-1; i++) {
            if(height[i]==height[i+1]) continue;
            else if(height[i]-height[i+1]==1){//내려감
                for (int j = i+1; j <=i+l; j++) {
                    if(j>=n||height[i+1]!=height[j]||visit[j])return false;
                    visit[j] = true;
                }
            } else if (height[i]-height[i+1]==-1) {
                for (int j = i-1; j >=i-l ; j--) {
                    if(j<0||height[i-1]!=height[j]||visit[j])return false;
                    visit[j] = true;
                }

            } else{
                return false;
            }
        }
        return true;
    }
}
