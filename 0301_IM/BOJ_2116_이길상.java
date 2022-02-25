import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class IM_15_2116_주사위쌓기 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 주사위 개수 입력
		int N = Integer.parseInt(br.readLine());
		
		// 주사위 정보 입력
		char[][] dice = new char[N][6];
		int[][] max = new int[N][3];
		for (int n = 0; n < N; n++) {
			char[] line = br.readLine().replace(" ", "").toCharArray();
			dice[n][0] = line[0];
			dice[n][1] = line[5];
			dice[n][2] = line[1];
			dice[n][3] = line[3];
			dice[n][4] = line[2];
			dice[n][5] = line[4];
			
			int a = Math.max(line[0], line[5]);
			int b = Math.max(line[1], line[3]);
			int c = Math.max(line[2], line[4]);
			
			max[n][0] = Math.max(b, c) - '0';
			max[n][1] = Math.max(c, a) - '0';
			max[n][2] = Math.max(a, b) - '0';
		}
		
		
		// 계산
		int result = 0;
		for (int i = 1; i <= 6; i++) {
			//System.out.println("bottom: " + i);
			
			// 맨 밑이 i일때의 최대값
			int sum = 0;
			int top = i;
			
			for (int n = 0; n < N; n++) {
				// 이전의 윗면과 일치하는 밑면 탐색
				int d = 0;
				while(dice[n][d] != top + '0') d++;
				
				// 옆면 중 최대값
				sum += max[n][d/2];
				// 위에서 찾은 밑면에 대응하는 윗면 탐색
				top = (d%2 == 0) ? dice[n][d+1] - '0' : dice[n][d-1] - '0';
				//System.out.println("top: " + top);
			}
			
			result = Math.max(sum, result);
		}
		System.out.println(result);
	}

}
