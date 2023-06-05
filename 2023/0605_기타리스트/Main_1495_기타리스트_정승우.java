import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1495_기타리스트_정승우 {
    static int N,S,M;
    static int arr[];
    static int V[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //곡의 개수
        N = Integer.parseInt(st.nextToken());
        //시작 볼륨
        S = Integer.parseInt(st.nextToken());
        //볼륨의 최대값
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        V = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<=M; i++) {
            V[i] = -1;
        }
        V[S] = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++) {
            list.clear();
            for(int j=0; j<=M; j++) {
                if(V[j] == i-1) {
                    if(0<= j-arr[i] && j - arr[i]<=M) {
                        list.add(j-arr[i]);
                    }
                    if(0<= j+arr[i] && j + arr[i]<=M) {
                        list.add(j+arr[i]);
                    }
                }
            }
            for(int v : list) {
                V[v] = i;
            }
        }

        for(int i=M; i>=0; i--) {
            if(V[i] == N) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);



    }
}
