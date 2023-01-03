package day0315;
import java.util.*;

public class BOJ_17070_이길상 {
	static int[][][] dp;
	static char[][] room;
	
	static void route(int x, int y) {
		
		// 이미 정보가 최신 상태일 경우
		if(dp[x][y][0]!=-1 && dp[x][y][1]!=-1 && dp[x][y][2]!=-1) {
			return;
		}
		
		// 벽이 있는 위치일 경우
		if(room[x][y] == '1') {
			dp[x][y][0] = dp[x][y][1] = dp[x][y][2] = 0;
			return;
		}
		
		// 이전 위치 갱신
		route(x-1,y-1);
		route(x,y-1);
		route(x-1,y);
		
		// 현 위치 갱신
		dp[x][y][0] = (room[x][y-1] != '1') ? dp[x][y-1][0] + dp[x][y-1][2] : 0;
		dp[x][y][1] = (room[x-1][y] != '1') ? dp[x-1][y][1] + dp[x-1][y][2] : 0;
		dp[x][y][2] = (room[x-1][y] != '1' && room[x][y-1] != '1')? 
						dp[x-1][y-1][0] + dp[x-1][y-1][1] + dp[x-1][y-1][2] :
						0;
	}

	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        // 입력
        int N = sc.nextInt();
        
        // 공간 정보
        room = new char[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
        	for (int j = 1; j <= N; j++) {
				room[i][j] = sc.next().charAt(0);
			}
		}
        
        // dp 초기화
        dp = new int[N+1][N+1][3]; // 가로, 세로, 대각선
        for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = -1;
			}
		}
        dp[1][2][0] = 1;
        dp[1][2][1] = 0;
        dp[1][2][2] = 0;
        
        // 실행
        route(N, N);
        
        // 출력
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }

}
