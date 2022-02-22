package com.ssafy.add.d0222;

import java.io.*;
import java.util.*;

public class Main_BJ_2578_빙고_김주은 {
	
	static int[][] chulsoo;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		chulsoo = new int[5][5];
		int[][]	answ = new int[5][5];
		
		//철수 빙고판 입력
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				chulsoo[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0; //숫자 개수
		//사회자 빙고판 입력
		for(int i=0;i<5;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) {
				answ[i][j] = Integer.parseInt(st.nextToken());
				++cnt;
				//만약 빙고일 경우 정답 출력 후 종료
				if(search(answ[i][j])) {
					System.out.println(cnt);
					System.exit(0);
				}
			}
		}

	}
	//사회자의 수로 철수의 빙고판 업데이트
	static boolean search(int ans) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(chulsoo[i][j] == ans) {
					chulsoo[i][j] = 0;
					//현재 빙고인지 확인하여 맞을 경우 true 반환
					if( (checkRows() + checkCols() + checkDiag())>=3) return true;
					else return false;
				}
			}
		}
		return false;
	}
	//가로 빙고 갯수 세어 반환
	static int checkRows() {
		boolean isBingo;
		int num=0;
		for(int i=0;i<5;i++) {
			isBingo = true;
			for(int j=0;j<5;j++) {
				if(chulsoo[i][j] != 0) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) ++num;
		}
		
		return num;
	}
	//세로 빙고 갯수 세어 반환
	static int checkCols() {
		boolean isBingo;
		int num=0;
		for(int i=0;i<5;i++) {
			isBingo = true;
			for(int j=0;j<5;j++) {
				if(chulsoo[j][i] != 0) {
					isBingo = false;
					break;
				}
			}
			if(isBingo) ++num;
		}
		
		return num;
	}
	//대각선 빙고 갯수 세어 반환
	static int checkDiag() {
		boolean isBingo;
		int num = 0;
		
		isBingo=true;
		for(int i=0;i<5;i++) {
			if(chulsoo[i][i]!=0) {
				isBingo=false;
			}
		}
		if(isBingo) ++num;
		isBingo=true;
		for(int i=0;i<5;i++) {
			if(chulsoo[i][4-i]!=0) {
				isBingo=false;
			}
		}
		if(isBingo) ++num;
		
		return num;
	}

}
