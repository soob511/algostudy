import java.util.*;

public class IM_08_2527_직사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 4번의 test case
		for (int t = 0; t < 4; t++) {
			// 입력받기
			int[] p = new int[8];
			for (int i = 0; i < 8; i++)	p[i] = sc.nextInt();
			
			if( // 각 꼭짓점이 일치하는 경우
				(p[2]==p[4] && p[3]==p[5]) ||
				(p[0]==p[6] && p[3]==p[5]) ||
				(p[0]==p[6] && p[1]==p[7]) ||
				(p[2]==p[4] && p[1]==p[7])) System.out.println('c');
			
			else if( // 각 면이 맞닿는 경우
				(p[2]==p[4] && p[5]<p[3] && p[7]>p[1]) ||
				(p[5]==p[3] && p[4]<p[2] && p[6]>p[0]) ||
				(p[0]==p[6] && p[5]<p[3] && p[7]>p[1]) ||
				(p[7]==p[1] && p[4]<p[2] && p[6]>p[0])) System.out.println('b');
			
			// 서로 일치하는 부분이 없는 경우
			else if(p[4]>p[2] || p[6]<p[0] || p[5]>p[3] || p[7]<p[1])
				System.out.println('d');
			
			// 나머지 경우는 전부 사각형이 만들어지는 경우
			else
				System.out.println('a');
		}
	}

}
