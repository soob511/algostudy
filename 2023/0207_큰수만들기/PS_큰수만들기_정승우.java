class Solution {
    public String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<number.length()-k; i++) {
            max = '0';
            for(int j=idx; j <=k+i; j++) {


                if(max <number.charAt(j)) {
                    max = number.charAt(j); idx = j+1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}
