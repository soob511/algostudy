import java.io.*;
import java.util.*;

public class Main_BJ_21608_상어초등학교_김주은 {

	static int N;
	static int[][] std;
	static int[][] map;
	static int[][] like;

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		std = new int[N * N][5];

		for (int i = 0; i < N * N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				std[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		map = new int[N][N];

		for (int i = 0; i < N * N; i++) {
			like = new int[N][N];
			setStudent(i);
		}
		
		//만족도 구하기
		int ans = 0;
		for(int k=0;k<N*N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==std[k][0]) {
						int like_cnt = check_adj_like(k,i,j);
						if(like_cnt>0) {
							ans += Math.pow(10, like_cnt-1);
						}
						break;
					}
				}
			}
		}
		
		
		System.out.println(ans);
	}

	private static void setStudent(int idx) {

		// 1. 비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 정한다
		int max_like = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					like[i][j] = check_adj_like(idx,i,j);
				}
				max_like = Math.max(max_like, like[i][j]);
			}
		}
		
		//2. 좋아하는 학생이 가장 많은 칸이 여러 개라면 인접한 칸 중에서 비어있는 칸이 가장 많은 칸 선택
		//3. 그 칸 중에서도 행과 열이 가장 작은 칸 선택
		int mx=-1;
		int my=-1;
		int max_blank=-1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int blank=0;
				if(map[i][j]==0 && like[i][j]==max_like) {
					for(int d=0;d<4;d++) {
						int ni = i+dr[d];
						int nj = j+dc[d];
						
						if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] != 0) {
							continue;
						}
						
						++blank;
					}
					
					if(max_blank<blank) {
						max_blank = blank;
						mx=i;
						my=j;
					}
				}
			}
		}
		
		map[mx][my] = std[idx][0];
	}

	private static int check_adj_like(int idx, int i, int j) {
		
		int like_cnt=0;
		
		for (int d = 0; d < 4; d++) {
			int ni = i + dr[d];
			int nj = j + dc[d];

			if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] == 0) {
				continue;
			}

			for (int l = 1; l <= 4; l++) {
				if (std[idx][l] == map[ni][nj]) {
					++like_cnt;
				}
			}
		}
		
		return like_cnt;
	}

}
