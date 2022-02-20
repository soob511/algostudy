import java.util.*;

public class IM_03_2578_빙고 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 빙고 보드 정보
		int[][] board = new int[5][5];
		
		// 빙고 체크용 배열
		boolean[][] bingo = new boolean[5][5];
		
		// 보드 정보 입력
		for (int i = 0; i < 5; i++) 
			for (int j = 0; j < 5; j++) 
				board[i][j] = sc.nextInt();
		
		
		int count = 0;
		for (int t = 1; t <= 25; t++) {
			// 사회자가 부르는 수
			int n = sc.nextInt();
			// 위치 체크용 인덱스
			int x = -1, y = -1;
			for (int i = 0; i < 5; i++) 
				for (int j = 0; j < 5; j++) 
					// 빙고판에서 위치 확인
					if(board[i][j] == n) {
						x = i;
						y = j;
					}
			// 체크
			bingo[x][y] = true;
			
			// 가로-세로-대각선 빙고 성립 확인
			if(bingo[x][0]&&bingo[x][1]&&bingo[x][2]&&bingo[x][3]&&bingo[x][4])
				count++;
			if(bingo[0][y]&&bingo[1][y]&&bingo[2][y]&&bingo[3][y]&&bingo[4][y])
				count++;
			if(x==y && bingo[0][0]&&bingo[1][1]&&bingo[2][2]&&bingo[3][3]&&bingo[4][4])
				count++;
			if(x+y == 4 && bingo[0][4]&&bingo[1][3]&&bingo[2][2]&&bingo[3][1]&&bingo[4][0])
				count++;
			
			// 승리
			if (count >= 3) {
				System.out.println(t);
				return;
			}
			
		}
		
	}

}
