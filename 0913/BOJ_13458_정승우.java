import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13458_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //시험장 수
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        //총감독관
        int B = Integer.parseInt(st.nextToken());
        //부감독관
        int C = Integer.parseInt(st.nextToken());
        //응시자 수에서 총감독관이 감시할수 있는 응시자 수를 뺀 값
        int k = 0;
        //한 시험장에 대한 감독관의 최소 수
        int sum = 0;
        //필요한 감독관의 최소 수
        long answer = 0;

        for(int i=0; i<N; i++) {
            k = arr[i] - B;

            //총감독관이 감시할수 있는 수가 총 응시자보다 큰 경우
            if (k<=0) {
                answer+=1;
                continue;
            }
            //+1은 총감독관
            sum = (k/C)+1;
            //나머지가 존재한다면 감독관이 1명 더 필요하기 때문에 sum에 1더함
            if(k%C!=0) sum++;
            //answer에 sum 누적
            answer += sum;
        }
        System.out.println(answer);

    }
}
