class Solution {
    public int solution(int storey) {
        int answer = 0;
        String str = Integer.toString(storey);
        int len = str.length();
        int[] arr= new int[len];

        for(int i=0; i<len; i++) {
            arr[i] = str.charAt(i)-'0';
        }

        for(int i=arr.length-1; i>=0; i--) {
            if(arr[i] > 5) {
                answer +=10-arr[i];

                if(i==0) {
                    answer++;
                } else {
                    arr[i-1]++;
                }
            } else if(arr[i]==5&&i>0&&arr[i-1]>=5) {
                arr[i-1]++;
                answer+=5;
            } else {
                answer+= arr[i];
            }
        }

        return answer;
    }
}