import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] arr = new int[1450];
        int time[][] = new int[book_time.length][2];

        for(int i =0;i<book_time.length;i++){

            //cal 반환값 int , 매개변수 문자열

            int inTime = cal(book_time[i][0],'t');
            int outTime = cal(book_time[i][1],'f');
            System.out.println(inTime);
            System.out.println(outTime);

            arr[inTime] += 1;
            arr[outTime] += -1;



        }

        for(int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
            answer = Math.max(answer, arr[i]);
        }

        return answer;

    }

    int cal(String s, char check) {
        String str[] = s.split(":");
        int h = Integer.parseInt(str[0]) * 60;
        int m = Integer.parseInt(str[1]);
        if (check == 'f') {
            m += 10;
        }
        return h + m;
    }

}