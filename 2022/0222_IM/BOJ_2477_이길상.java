import java.util.*;

public class IM_07_2477_참외밭 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		
		// 입력받기
		int[] d = new int[6];
		for (int i = 0; i < 6; i++) {
			// 방향은 버리고 변의 크기만 받기
			sc.nextInt(); 
			d[i] = sc.nextInt();
		}
		
		// 세로변 중 가장 큰것
		int bigX = d[0]>d[2] ? (d[0]>d[4] ? 0:4) : (d[2]>d[4] ? 2:4);
		// 가로변 중 가장 큰것
		int bigY = d[1]>d[3] ? (d[1]>d[5] ? 1:5) : (d[3]>d[5] ? 3:5);
		
		// bigX와 big를 통해 찾은 작은 사각형의 가로세로
		int smallX = (bigX + 3)%6;
		int smallY = (bigY + 3)%6;
		
		// 큰 사각형에서 작은 사각형 빼기
		System.out.println((d[bigX]*d[bigY] - d[smallX]*d[smallY]) * K);
	}

}
