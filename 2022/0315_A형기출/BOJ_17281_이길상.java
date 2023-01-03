package day0315;
import java.io.*;
import java.util.*;

public class BOJ_17281_이길상 {
	static int N, maxscore = 0;
	static int[][] info;
	
	static void set_order(int n, int[]order, boolean[]check) {
		if(n==9) {
			baseball(order);
			return;
		}
		
		// 4번타자는 1번 선수
		if(n==3) {
			order[n] = 0;
			set_order(n+1, order, check);
			return;
		}
		
		// 순서 정하기
		for (int i = 0; i < 8; i++) {
			if(!check[i]) {
				check[i] = true;
				order[n] = i+1;
				set_order(n+1, order, check);
				check[i] = false;
			}
		}
	}
	
	static void baseball(int[] order) {
		// 플레이어 인덱스
		int player_idx = 0;
		// 점수
		int score = 0;
		
		//n번째 이닝
		for (int n = 0; n < N; n++) {
			// 1~3루 정보
			int field = 0b000;
			// 아웃 카운트
			int out = 0;
			
			while(out<3) {
				int player = order[player_idx];
				int result = info[n][player];
				
				if(result>0) {
					field += 0b1000;
					for (int i = 0; i < result; i++) {
						if((field&1)>0) score++;
						field = field >> 1;
					}
				}
				else
					out++;
				
				// 다음 타자
				player_idx = (player_idx+1)%9;
			}	
		}
		
		maxscore = Math.max(maxscore, score);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력
        N = Integer.parseInt(br.readLine());
        
        // 플레이어 정보
        info = new int[N][9];
        for (int n = 0; n < N; n++) {
        	String[] line = br.readLine().split(" ");
        	for (int i = 0; i < 9; i++) {
				info[n][i] = Integer.parseInt(line[i]);
			}
		}
        
        set_order(0, new int[9], new boolean[8]);
        
        System.out.println(maxscore);
        
        
    }

}
