package IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244_스위치켜고끄기_김정윤 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int switchN = Integer.parseInt(br.readLine());	 // 스위치 개수
		int[] switchArr = new int[switchN];	// 스위치 상태
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<switchN; i++) {
			switchArr[i] = Integer.parseInt(st.nextToken());
		}
		int stdN = Integer.parseInt(br.readLine());	 // 학생 수
		int[][] stdInfo = new int[stdN][2];	// 학생 정보
		for(int i=0; i<stdN; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				stdInfo[i][0] = Integer.parseInt(st.nextToken());	// 성별
				stdInfo[i][1] = Integer.parseInt(st.nextToken());	// 학생이 받은 수
		}
		
		// 성별에 따라 처리
		for(int i=0; i<stdN; i++) {
			// 남학생인 경우
			if(stdInfo[i][0]==1) {
				int n = 1;
				while((stdInfo[i][1]*n)-1<switchN) {
					if(switchArr[(stdInfo[i][1]*n)-1]==1) switchArr[(stdInfo[i][1]*n)-1] = 0;
					else switchArr[(stdInfo[i][1]*n)-1] = 1;
					n++;
				}
			}
			// 여학생인 경우
			if(stdInfo[i][0]==2) {
				int n1 = stdInfo[i][1]-1;	// 여학생이 받은 수의 스위치 배열에서 인덱스
				int n2 = stdInfo[i][1]-1;
				
				// 여학생이 받은 수인 스위치 상태 변경
				if(switchArr[n1]==1) switchArr[n1] = 0;
				else switchArr[n1] = 1;
				
				int cnt = 0;	// 좌우 대칭인 스위치쌍 개수
				while(n1-1>=0 && n2+1<switchN) {	// 스위치 배열 내에 있는 경우 대칭 확인
					if(switchArr[n1-1]==switchArr[n2+1] && switchArr[n1-1]==1) {
						switchArr[n1-1] = 0;
						switchArr[n2+1] = 0;
						n1--;
						n2++;
						cnt++;
					}
					else if(switchArr[n1-1]==switchArr[n2+1] && switchArr[n1-1]==0) {
						switchArr[n1-1] = 1;
						switchArr[n2+1] = 1;
						n1--;
						n2++;
						cnt++;
					}
					else break;	// 좌우 대칭인 스위치가 (더이상, 원래) 없는 경우
				}	
			}
		}
		
		// 출력
		StringBuilder sb = new StringBuilder();
		int cnt = 1;
		for(int i:switchArr) {
			if(cnt>=20) {
				sb.append(i+"\n");
				cnt = 1;
			}else {
				sb.append(i+" ");
				cnt++;
			}
		}
		sb.setLength(sb.length()-1);
		System.out.print(sb);
	}

}
