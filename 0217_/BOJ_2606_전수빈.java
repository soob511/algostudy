package dfs_bfs;

import java.util.Scanner;

public class Main_2606_바이러스 {
	static int[][] map;
	static boolean[] check;
	static int c,n;
	static int count =0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 c = sc.nextInt(); //컴퓨터수
		 n = sc.nextInt(); //쌍의수
		map = new int[c+1][c+1]; //인접 행렬
		check = new boolean[c+1];// 바이러스 체크
		
		for(int i=0;i<n;i++) {
			int a = sc.nextInt(); 
			int b = sc.nextInt();
			map[a][b] = map[b][a] =1;	//2차원 배열애 체크
		}
		dfs(1);
		System.out.println(count);
	}
	private static void dfs(int cnt) {
		// TODO Auto-generated method stub
		
		check[cnt] = true; //방문체크
		
		for(int i=1;i<=c;i++ ) {
			if(map[cnt][i]==1 && check[i]==false) { //간선으로 연결되있음
				count++;
				dfs(i);
			}
		}
	
		
	}
		
}
