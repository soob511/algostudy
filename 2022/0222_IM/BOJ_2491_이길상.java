import java.util.*;

public class IM_06_2491_수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int up = 0, down = 0, upMax = 0, downMax = 0, prev = 0;
		while(N-->0) {
			// 입력
			int next = sc.nextInt();
			
			// 증가 카운트
			if (prev <= next) {
				up++;
			}
			else { // 증가수열이 중단되었을 때
				upMax = Math.max(upMax, up);
				up = 1;
			}
			
			// 감소 카운트
			if (prev >= next) {
				down++;
			}
			else { // 감소수열이 중단되었을 때
				downMax = Math.max(downMax, down);
				down = 1;
			}
			
			// 값 갱신
			prev = next;
		}
		
		System.out.println(Math.max(Math.max(upMax, up), Math.max(downMax, down)));
	}

}
