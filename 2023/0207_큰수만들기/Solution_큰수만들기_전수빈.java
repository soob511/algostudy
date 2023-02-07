package greedy;

public class Solution_큰수만들기 {
    public static void main(String[] args) {
        String number = "1231234";
        int k = 3;
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int max = 0;
        for(int i=0;i<number.length()-k;i++){
            max=0;
            for(int j = start;j<=i+k;j++){
                if(max<number.charAt(j)-48){
                    max = number.charAt(j)-48;
                    start = j+1;
                }
            }
            sb.append(max);
        }
        System.out.println(sb);
    }
}
