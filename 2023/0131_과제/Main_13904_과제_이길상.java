import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 과제 입력받고 정렬
        List<int[]> list = new LinkedList<>();
        for (int n = 0; n < N; n++) {
            int input[] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(input);
        }
        list.sort((a,b)->b[0]-a[0]);


        int day = list.get(0)[0];
        int result = 0;

        // 마지막날부터 역으로 탐색
        while(day > 0){
            int maxIdx = -1;
            int maxVal = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i)[0] < day) break;
                
                if (list.get(i)[1] > maxVal) {
                    maxIdx = i;
                    maxVal = list.get(i)[1];
                }
            }
            if (maxIdx != -1) {
                // System.out.println("day: " + day + ", work: (" + list.get(maxIdx)[0] + ", " + list.get(maxIdx)[1] + ")");
                result += list.remove(maxIdx)[1];
            }
            day--;
        }

        System.out.println(result);
    }
}
