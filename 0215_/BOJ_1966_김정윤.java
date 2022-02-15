package Queue_Dequeue;
/////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1966_김정윤 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());	// 테스트 케이스
		
		for(int tc=0; tc<T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			LinkedList<int[]> q = new LinkedList<>();	// Queue로 활용할 연결리스트
			st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<N; i++) {	
				q.offer(new int[] {i, Integer.parseInt(st.nextToken()) });	// {초기 위치, 중요도}
			}
			
			int cnt = 0;	// 출력 횟수
			
			while(!q.isEmpty()) {
				
				int[] first = q.poll();	// 첫 번째 원소
				boolean isMax =  true;	// first 원소가 가장 큰 원소인지를 판단하는 변수
				
				// Queue에 남아있는 원소들과 중요도를 비교
				for(int i=0; i<q.size(); i++) {
					
					// 처음 뽑은 원소보다 Queue에 있는 i번째 원소의 중요도가 큰 경우
					if(first[1]<q.get(i)[1]) {
						// 뽑은 원소와 i 이전의 원소들을 뒤로 보냄
						q.offer(first);
						for(int j=0; j<i; j++) {
							q.offer(q.poll());
						}
						
						// first원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
						isMax = false;
						break;
					}
				}
				
				// first원소가 가장 큰 원소가 아니었으므로 다음 반복문으로 넘어감
				if(isMax==false) {
					continue;
				}
				
				// first원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서
				cnt++;
				if(first[0]==M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
					break;
				}	
			}
			sb.append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
