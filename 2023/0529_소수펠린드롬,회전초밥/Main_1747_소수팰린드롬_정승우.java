import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1747_정승우_소수팰린드롬 {
    public static void main(String[] args) throws IOException {
        boolean check[] = new boolean[1100001];
        ArrayList<Integer> arr = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        check[0] = check[1] = true;

        int N = Integer.parseInt(br.readLine());

        for(int i=2; i*i<=1100000; i++) {
            if(!check[i]) {
                for(int j=i*i; j<=1100000; j+=i) {
                    check[j] = true;
                }
            }
        }
        for(int i=1; i<=1100000; i++) {
            if(!check[i]) {
                arr.add(i);
            }
        }
        for(int i=0; i<arr.size(); i++) {
            if(arr.get(i)<N){
                continue;
            } else {
                String str = Integer.toString(arr.get(i));
                String reverse = "";
                for(int j=str.length()-1; j>=0; j--) {
                    reverse = reverse+str.charAt(j);
                }
                if(str.equals(reverse)) {
                    System.out.println(Integer.parseInt(str));
                    break;
                }
            }

        }


    }
}
