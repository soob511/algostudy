package implement;

import java.io.*;
import java.util.*;

public class Main_1652_누울자리를찾아라 {
    static int n;
    static char[][] map;
    static int galo;
    static int selo;
    static boolean[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i <n; i++) {
            String s = br.readLine();
            for (int j = 0; j <n; j++) {
                map[i][j] = s.charAt(j);
            }
        }
//        for(char[] b:map) System.out.println(b);
//        System.out.println();

        visit = new boolean[n][n];

        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
              if(map[i][j]=='.'&&!visit[i][j]){
                  int count=0;
                  for(int k=j;k<n;k++){
                      if(map[i][k]=='.'){
                          count++;
                          visit[i][k]= true;
                      }else{
                          visit[i][k] = false;
                          break;
                      }
                  }
                  if(count>=2){
                      galo++;
                  }
              }
            }
        }
        visit = new boolean[n][n];
        for (int j = 0; j <n; j++) {
            for (int i = 0; i <n; i++) {
                if(map[i][j]=='.'&&!visit[i][j]){
                    int count=0;
                    for(int k=i;k<n;k++){
                        if(map[k][j]=='.'){
                            count++;
                            visit[k][j]= true;
                        }else{
                            visit[k][j] = false;
                            break;
                        }
                    }
                    if(count>=2){
                        selo++;
                    }
                }
            }
        }
        System.out.println(galo+" "+selo);
    }

}
