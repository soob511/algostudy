import java.util.*;

public class IM_05_2578_경비원 {
	
	// 왼쪽 위를 기준으로 시계방향 거리로 변환
	static int f(int D, int K, int R, int C) {
		int t = 0;
		switch(D) {
		case 3: t += R;
		case 2:	t += (R + C -2*K);
		case 4: t += C;
		case 1: t += K;
		}
		return t;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(), R = sc.nextInt();
		int N = sc.nextInt();
		
		// 상점 위치 배열
		int[] shop = new int[N];
		while(N-->0) {
			// 위치 입력받고 변환하여 저장
			shop[N] = f(sc.nextInt(), sc.nextInt(), R, C);
		}
		// 동근이 위치
		int D = f(sc.nextInt(), sc.nextInt(), R, C);
		
		// 최단 거리 계산
		int result = 0;
		for (int s : shop) {
			int t = Math.abs(D - s);
			result += Math.min(t, 2*(R+C) - t);
		}
		
		// 출력
		System.out.println(result);
	}

}
