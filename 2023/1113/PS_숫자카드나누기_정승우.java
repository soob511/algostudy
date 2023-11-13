import java.util.*;

class Solution {
    static int answer1 = 0;
    static int answer2 = 0;
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        gcd(arr1,arrayA);
        gcd(arr2,arrayB);

        int last = arr1.size() -1;
        if (last != -1) {
            answer1 = cal(arr1, arrayB, last);
            System.out.println(answer1);
        }


        int last2 = arr2.size() -1;
        if(last2 != -1) {
            answer2 = cal (arr2, arrayA, last2);
            System.out.println(answer2);
        }


        answer = Math.max(answer1, answer2);



        return answer;
    }

    void gcd(ArrayList<Integer> list, int[] arr) {

        for(int i=2; i<=arr[0]; i++) {

            boolean check = false;
            for(int j=0; j<arr.length; j++) {
                if(arr[j]%i==0) {
                    check = false;
                } else {
                    check = true;
                    break;
                }
            }
            if(check==false) list.add(i);
        }
    }

    int cal(ArrayList<Integer> list, int[] arr, int last) {
        boolean check = false;
        for(int i=0; i<arr.length; i++) {
            if(arr[i] % list.get(last) != 0) {
                check = false;

            } else {
                check = true;
                break;
            }
        }

        if(check == false) {

            return list.get(last);
        } else {
            return 0;
        }
    }
}