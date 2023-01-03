package com.ssafy.day0301;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2304_정승우 {


	static int map[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//높이
		ArrayList<Integer> h = new ArrayList<>();
		//기둥위치
		ArrayList<Integer> p = new ArrayList<>();
		
		
		for (int i=0; i<N; i++) {
			p.add(sc.nextInt());
			h.add(sc.nextInt());

		}
		
		int maxp = Integer.MIN_VALUE;
		
		
		int maxh = Integer.MIN_VALUE;
		//maxp의 값이 최대값일때의 maxh값
		int maxhtop =0;
		//처음에 값 삭제
		int idx=0;
		//1의 개수 카운트
		int cnt =0;

		
		for (int i=0; i<h.size(); i++) {
			if (h.get(i)>maxh) {
				maxh=h.get(i);
				maxhtop = p.get(i);
				idx=i;
			}
		}
		
		for (int i=0; i<p.size(); i++) {
			if (p.get(i)>maxp) {
				maxp=p.get(i);
			}
		}
		//h중 가장 큰 값은 maxh에 저장했고, 그에 해당하는 p는 maxhtop에 저장했으므로 해당 값들 삭제
		p.remove(p.get(idx));
		h.remove(h.get(idx));
	
		
		//map 2차원 배열 생성
		map = new int[maxh+1][maxp+1];
		//maxh의 기둥을 다 1로 채워놓음
		for (int i=0; i<maxh; i++) {
			map[i][maxhtop-1]=1;
		}
		
		for (int tc=0; tc<N; tc++) {
			
			while(!h.isEmpty()) {
				
				int max = Integer.MIN_VALUE;
				
				int pos =0;
				
				//h리스트에서 가장 큰 값을 찾음
				for (int k=0; k<h.size(); k++) {
					
					//h값이 
					if (h.get(k)>max) {
						//h에서 가장 큰 값을 찾고 pos변수에 그때의 위치값을 저장
						//h값중 가장 큰 값을 max에 저장
						max = h.get(k);
						//max값을 구했을때 그에 해당하는 위치값을 pos에 저장
						pos = p.get(k);
						//인덱스 값을 저장
						idx =k;
					}
					
					//map[max-1][pos-1]=1;
				}		
				//max,pos로 저장한 값은 삭제
				p.remove(p.get(idx));
				h.remove(h.get(idx));

				//h의 위치값이 maxhtop보다 크다면(뒤에 있다면)
				if (pos>maxhtop) {
					for (int i=0; i<max; i++) {
						//maxhtop~pos까지 값을 1로 저장(이때 행값은 전체에서 가장큰값과 비교하는 값으로)
						for (int j=maxhtop; j<pos; j++) {
							map[i][j] =1;
						}
					}
				}
				//h의 위치값이 maxhtop보다 작다면(앞에 있다면)
				else if(maxhtop>pos) {
					for (int i=0; i<max; i++) {
						//pos~maxhtop까지 값을 1로 저장
						for (int j=pos; j<maxhtop; j++) {
							map[i][j] =1;
						}
					}
				}	
			}	
		}
		//디버깅용 값이 잘 나오는지 테스트
		for (int[]a : map) {
			System.out.println(Arrays.toString(a));
		}
		//1의 개수를 카운트(면적)
		for (int i=0; i<maxh+1; i++) {
			for (int j=0; j<maxp+1; j++) {
				if(map[i][j]==1) {
					cnt++;
				}	
			}
		}
		System.out.println(cnt);			
	}
}
