package dp;

import java.io.*;
import java.util.*;

public class Main_1932_정수삼각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n+1][n+1];
		int[][] d =new int[n+1][n+1];
		//삼각형 입력
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		d[1][1]=map[1][1];//제일 위에 값 넣기
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				if(j==1) {//제일 왼쪽 
					d[i][j] = map[i][j]+d[i-1][j];
				}
				else {
					d[i][j]= map[i][j]+Math.max(d[i-1][j], d[i-1][j-1]);
				}
			}
			
		}
		int max = 0;
		//최대값 찾기
		for(int i=1;i<=n;i++) {
			max = Math.max(d[n][i], max);
		}
		System.out.println(max);
		
		
	}

}
