import java.io.*;
import java.util.*;

public class Main_BJ_9466_텀프로젝트_김주은 {

	static int[] group;
	static int cnt;
	static boolean[] visited, done;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());
			
			done = new boolean[N+1];
			visited = new boolean[N+1];
			
			cnt = 0;

			group = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				group[i] = Integer.parseInt(st.nextToken());
				if(group[i]==i) {
					++cnt;
					done[i]=true;
				}
			}

			for (int i = 1; i <= N; i++) {
				if (!done[i]) {
					dfs(i);
				}
			}
			
			sb.append(N-cnt + "\n");
		}

		System.out.println(sb);
	}

	private static int dfs(int start) {
		
		if (done[start]) { //이전 방문 경험 있으면 더이상 X
			return 0;
		} 
		
		if(visited[start]) {
			return start;
		}
		visited[start]=true;

		int next = group[start];

		int result = dfs(next);
		if(result>0) {
			++cnt;
			done[start]=true;
			if(start==result) {
				result=0;
			}
		}
		
		visited[start]=false;
		done[start]=true;
		
		return result;
		
	}
	
//	public static void dfs(int n){
//        // 이미 방문 했을 때!
//        if(visited[n]){
//            done[n] = true;    // 팀 편성 완료했다고 처리
//            cnt++;    // 팀 편성 완료 인원 증가
//        }else{
//            // 방문하지 않았을 때 -> 방문 처리!
//            visited[n] = true;
//        }
//        
//        // 다음 학생이 팀 결성을 아직 못했을 경우
//        if(!done[group[n]]){
//            dfs(group[n]);
//        }
//
//        visited[n] = false;
//        done[n] = true;
//    }

}
