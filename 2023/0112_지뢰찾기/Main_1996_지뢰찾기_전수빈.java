package implement;

import java.io.*;

public class Main_1996_지뢰찾기 {

    static int n;
    static int sum;
    static char[][] map;
    static char[][] result;
    static int[] dx = {-1,1,0,0,-1,-1,1,1};
    static int[] dy = {0,0,-1,1,-1,1,1,-1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        result = new char[n][n];

        for(int i=0;i<n;i++){
            String s = br.readLine();
            for (int j = 0; j <n; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]>'0'){
                    result[i][j] = '*';
                }
            }
        }

        for(int i=0;i<n;i++){
            for (int j = 0; j <n; j++) {
                if(map[i][j]=='.'){
                    sum = landmine(i,j);
                    if(sum>=10){
                        result[i][j] = 'M';
                    }else{
                        result[i][j] = (char)(sum+'0');
                    }
                }
            }
        }
        for(char[] b:result) System.out.println(b);
        System.out.println();
    }

    private static int landmine(int x, int y) {
        int sum=0;
        for(int i=0;i<8;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx<0||ny<0||nx>=n||ny>=n)continue;
            if(map[nx][ny]>'0'){
                sum+=(int)map[nx][ny]-'0';
            }
        }
        return sum;
    }
}
