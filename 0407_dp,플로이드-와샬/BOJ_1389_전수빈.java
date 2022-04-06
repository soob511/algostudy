package dfs_bfs;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1389_케빈베이컨의6단계법칙 {

	public static void main(String[] args) {
		int INF = 500000;
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 유저의수
		int M = sc.nextInt();// 친구관계의수

		int[][] map = new int[N + 1][N + 1];
		 
		// 초기값 설정
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
 
                if (i == j) {
                    map[i][j] = 0;
                }
            }
        }
        //친구관계 입력
		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a]=  1;
		}
		
		//플로이드와샬
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(map[i][j]>map[i][k]+map[k][j]) {//최솟값 갱신
						map[i][j]=map[i][k]+map[k][j];
					}
				
				}
			}
			
		}
		
		int min = Integer.MAX_VALUE;
		int result=0;
		
		for(int i=1;i<=N;i++) {//케빈 베이컨 수 계산
			int sum=0;
			for(int j =1;j<=N;j++) {
				sum+=map[i][j];
			}
			
			if(min>sum) {
				min=sum;
				result=i;//번호저장
			}
		}
		System.out.println(result);
		

	}

}
