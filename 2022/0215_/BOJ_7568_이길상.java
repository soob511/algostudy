package day0215;
import java.util.*;

// 덩치
public class BOJ_7568_이길상 {

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 사람 수
        int N = sc.nextInt();
        
        // 몸무게와 키, 등수
        int[] Xs = new int[N];
        int[] Ys = new int[N];
        int[] DungChi = new int[N];
        
        for (int n = 0; n < N; n++) {
			// x, y 입력
        	int x = sc.nextInt(), y = sc.nextInt();
        	// 등수 초기화
        	int dc = 1;
        	
        	// 이전 데이터 탐색
        	for (int i = 0; i < n; i++) {
        		// 덩치가 큰 사람 발견
				if(Xs[i]>x && Ys[i]>y) dc++;
				// 덩치가 작은 사람 발견
				else if(Xs[i]<x && Ys[i]<y) DungChi[i]++;
			}
        	
        	// 기록
        	Xs[n] = x;
        	Ys[n] = y;
        	DungChi[n] = dc;
		}
        
        // 출력
        for (int i : DungChi)
			System.out.print(i + " ");
        
    }

}
