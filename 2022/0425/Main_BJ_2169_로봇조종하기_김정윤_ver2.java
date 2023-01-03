package KB;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_BJ_2169_로봇조종하기_김정윤_ver2 {
	
	static final int INF = 99999999;
	   static int dr[] = { 0, 1, 0 };
	   static int dc[] = { 1, 0, -1 }; // 오른쪽, 아래, 왼쪽
	   static int N, M;
	   static int values[][];
	   static boolean isVisited[][];
	   static int valueSum[][][];

	   public static void main(String[] args) throws IOException {
		      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		      N = Integer.parseInt(st.nextToken());
		      M = Integer.parseInt(st.nextToken());
		      values = new int[N][M];
		      isVisited = new boolean[N][M];
		      valueSum = new int[N][M][3];
		      for (int i = 0; i < N; i++) {
		         st = new StringTokenizer(br.readLine(), " ");
		         for (int j = 0; j < M; j++) {
		            values[i][j] = Integer.parseInt(st.nextToken());
		            valueSum[i][j][0] = valueSum[i][j][1] = valueSum[i][j][2] = -INF;
		         }
		      }
		      isVisited[0][0] = true;
		      bw.write(Integer.toString(moveRobot(0, 0, 0)));
		      br.close();
		      bw.flush();
		      bw.close();
		   }

	   		private static int moveRobot(int r, int c, int direction) {
		      if (r == N - 1 && c == M - 1)
		         return values[r][c];
		      
		      if (valueSum[r][c][direction] != -INF) // 최대 가치 합이 구해진 곳이라면 해당 값을 리턴
		         return valueSum[r][c][direction];

		      for (int d = 0; d < 3; d++) { // 3방향 탐색
		         int nr = r + dr[d];
		         int nc = c + dc[d];
		         if (!isIn(nr, nc) || isVisited[nr][nc])
		            continue;
		         isVisited[nr][nc] = true;
		         valueSum[r][c][direction] = Math.max(valueSum[r][c][direction], values[r][c] + moveRobot(nr, nc, d)); // 현재 최대 가치 합보다 다른 방향에서 구한 최대 가치 합이 더 크면 갱신
		         isVisited[nr][nc] = false; // 다음 방향에서 탐색이 가능하도록 isVisited를 false로 바꿔준다.
		      }
		      return valueSum[r][c][direction];
		   }

		   private static boolean isIn(int nr, int nc) {
		      return nr >= 0 && nc >= 0 && nr < N && nc < M;
		   }


}
