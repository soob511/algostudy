package Samsung;

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main_21608_상어초등학교 {
    static int n;
    static int[][] map;
    static int[][] arr;
    static int student;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        student = (int)(Math.pow(n,2));

        arr = new int[student][5];

        for (int i = 0; i <student; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        for(int[] b:arr) System.out.println(Arrays.toString(b));
//        System.out.println();


    }
}
