import java.util.*;
class Solution {
    public int[] solution(int[][] arr) {
        zip(0,0,arr.length,arr);
        return answer;
    }

    static int[] answer = new int[2];

    public void zip(int r, int c, int len, int[][] arr) {
        boolean zero = true;
        boolean one = true;

        for(int i=r; i<r+len; i++) {
            for(int j=c; j<c+len; j++) {
                if(arr[i][j]==1) {
                    zero = false;
                }
                if(arr[i][j]==0) {
                    one = false;
                }
            }
        }

        if(one==true) {
            answer[1]++;
            return;
        }
        if(zero==true) {
            answer[0]++;
            return;
        }

        zip(r,c,len/2,arr);
        zip(r+len/2,c,len/2,arr);
        zip(r,c+len/2,len/2,arr);
        zip(r+len/2,c+len/2,len/2,arr);
    }
}