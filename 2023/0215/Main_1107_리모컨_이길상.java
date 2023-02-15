import java.io.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] broken = new boolean[10];

        if (M>0){
            Stream.
            of(br.readLine().split(" ")).
            mapToInt(Integer::parseInt).
            forEach(e -> { broken[e] = true; });
        }

        int answer = Math.abs(N-100);

        int low = N, high = N;
        
        while(low >= 0){
            if(check(low, broken)){
                answer = Math.min(answer, String.valueOf(low).length() + N - low);
                break;
            }
            low--;
        }

        while(String.valueOf(high).length() + high - N < answer){
            if (check(high, broken)){
                answer = Math.min(answer, String.valueOf(high).length() + high - N);
                break;
            }
            high++;
        }

        System.out.println(answer);
    }

    static boolean check(int number, boolean[] broken){
        if (number == 0 && broken[0])
            return false;
        while(number > 0){
            if (broken[number%10]) return false;
            number/=10;
        }
        return true;
    }
}
