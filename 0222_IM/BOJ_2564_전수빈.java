package IM;

import java.util.*;
import java.io.*;

public class Main_2564_경비원 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		// 블록크기
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int line = (m + n) * 2; // 라인의 길이

		// 상점수
		int c = Integer.parseInt(br.readLine());

		//일직선으로 계산
		for (int i = 1; i <= c + 1; i++) {
			// 상점, 동근이 위치
			st = new StringTokenizer(br.readLine());

			int dir = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			if(dir==1) { //북쪽
				list.add(dis);
			}
			else if(dir==2) {//남
				list.add(m+n+(m-dis));
			}else if(dir==3) {//서
				list.add((2*m)+n+(n-dis));
			}else if(dir ==4) {//동
				list.add(m+dis);
			}

		}
		
		int dong = list.get(list.size()-1); //동근이 위치
		int sum =0;
		for(int i=0; i<c;i++) { 
			int min = Math.abs(dong-list.get(i)); //동근이 위치에서 뺸값 절댓값
			sum += Math.min(min, line-min); // 시계방향과 반시계방향 비교
		}
		System.out.println(sum);
		


	}
}
