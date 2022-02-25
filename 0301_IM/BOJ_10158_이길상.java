import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IM_10_10158_개미 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 공간 크기 입력
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
		
		// 개미 위치 입력
		st = new StringTokenizer(br.readLine());
		int P = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
		
		// 시간 입력
		int T = Integer.parseInt(br.readLine());
		
		// 연장선 위의 위치
		P+=T;
		Q+=T;

		// 제한된 공간 안의 위치로 변환
		int x = P%W, y = Q%H;
		if((P/W)%2 == 1) x = W - x;
		if((Q/H)%2 == 1) y = H - y;
		
		// 출력
		System.out.println(x + " " + y);
	}

}
