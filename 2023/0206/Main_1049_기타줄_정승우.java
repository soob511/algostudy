import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1049_기타줄_정승우 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //끊어진 기타줄
        int N= Integer.parseInt(st.nextToken());
        // 브랜드 수
        int M= Integer.parseInt(st.nextToken());
        //최소값 구하기
        int min = Integer.MAX_VALUE;
        int pac = 1000;
        int one = 1000;
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            pac = Math.min(pac,Integer.parseInt(st.nextToken()));
            one = Math.min(one,Integer.parseInt(st.nextToken()));
            min = Math.min(min, (N/6+1) * pac);
            min = Math.min(min, one*N);
            min = Math.min(min, ((N/6) * pac) + ((N%6) * one));
        }
        System.out.println(min);
    }
}
