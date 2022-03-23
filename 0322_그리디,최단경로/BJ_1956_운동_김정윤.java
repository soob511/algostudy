package 최단경로;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_1956_운동_김정윤 {
	
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());	// 마을
		int E = Integer.parseInt(st.nextToken());	// 도로(일방통행)
		
		int[][] arr = new int[V+1][V+1];	// a b c: a번 -> b번 마을로 가는 거리 c인 도로
		
		// 입력: 마을과 각 도로 정보 저장
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine(), " ");
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	 
	        arr[a][b] = c;
		}
		
		// 플로이드 와샬 알고리즘 수행
		for(int k=1; k<=V; k++) {
			for(int i=1; i<=V; i++) {
				for(int j=1; j<=V; j++) {
					if(i==j) continue;
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		int ans = INF;
		for(int i=1; i<=V; i++) {
			for(int j=1; j<=V; j++) {
				if(i==j) continue;
				//  자기 자신을 제외한 두 정점이 서로에게 가는 경로가 있다면, 사이클이 존재한다는 의미
				if(arr[i][j] != 0 && arr[j][i] != 0) {
					ans = Math.min(ans, arr[i][j]+arr[j][i]);
				}
			}
		}
		
		// ans가 초기값이면 사이클이 존재하지 않음
		ans = (ans==INF)? -1 : ans;
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
