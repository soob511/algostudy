import java.util.*;
import java.io.*;

public class Main_15684_사다리조작_김주은 {

	static int N, M, H;
	static int[][] ladder;
	static int answer = 4;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		ladder = new int[H + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			ladder[a][b] = 1;
		}

		dfs(1*(N+1)+1,0);

		System.out.println(answer==4?-1:answer);
	}

	private static void dfs(int x, int cnt) {
		
		if(cnt<=3 && answerCase()) {//정답경우 가능한 경우
			if(answer>cnt) {
				answer=cnt;
			}
		}
		if(cnt==3) {
			return;
		}
		
		for (int i = 1; i <= H; i++) {
			for (int j = 1; j < N; j++) {
				if (ladder[i][j] > 0 || i*(N+1)+j<x) {
					continue;
				}
				if (j==1 && ladder[i][j+1]==0) {
					ladder[i][j] = 2;
					dfs(i*(N+1)+j+1,cnt + 1);
					ladder[i][j] = 0;
				}else if (j>=2 && ladder[i][j - 1] == 0 && ladder[i][j + 1] == 0) {
					ladder[i][j] = 2;
					dfs(i*(N+1)+j+1,cnt + 1);
					ladder[i][j] = 0;
				}
			}
		}
	}


	private static boolean answerCase() {
		for(int idx=1;idx<=N;idx++) {
			
			int m=1;
			int n=idx;

			while(m<=H+1) {
				if(m==H+1) {
					if(n!=idx) {
						return false;
					}
					break;
				}
				
				if(n<N && ladder[m][n]>0) {//오른쪽 이동
					n+=1;
				}else if(n>1 && ladder[m][n-1]>0) {//왼쪽 이동
					n-=1;
				}
				m+=1;
			}
		}
		return true;
	}

}
