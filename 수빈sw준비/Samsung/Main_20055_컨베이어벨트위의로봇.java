package Samsung;

import java.io.*;
import java.util.*;

public class Main_20055_컨베이어벨트위의로봇 {
    static int n,k,m;
    static int[] map;
    static boolean[] robot;
    static int count;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());//내구도 0

        m = 2*n;
        map = new int[m];
        robot = new boolean[n];
        st = new StringTokenizer(br.readLine());

        count = 0;
        for(int i=0;i<m;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }
        result =0;
       while (count<k){
           result++;
           belt();//회전
           move();//로봇이동
           check();
       }
        System.out.println(result);
    }

    private static void check() {
        count = 0;
        for(int i=0;i<m;i++){
            if(map[i]==0){
                count++;
            }
        }
    }

    private static void move() {

        // 로봇 내림
        if(robot[n-1]=true){
            robot[n-1] = false;
        }

        for(int i=n-2;i>=0;i--){
            if(robot[i]){
                if(!robot[i+1]&&map[i+1]>0){
                    robot[i+1] = true;
                    robot[i]= false;
                    map[i+1]-=1;
                }
            }
        }

        if(map[0]>0){
            robot[0] = true;//로봇 올림
            map[0]-=1;
        }

    }

    private static void belt() {

        //벨트 회전
        int temp = map[m-1];
        for(int i=m-1;i>0;i--){
            map[i] = map[i-1];
        }
        map[0] = temp;

        //로봇 회전
        for(int i=n-1;i>0;i--){
            robot[i] = robot[i-1];
        }
        robot[0] = false;//올린칸에서 옮겨서 없음


    }


}
