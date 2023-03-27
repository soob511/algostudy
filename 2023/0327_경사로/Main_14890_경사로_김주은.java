import java.io.*;
import java.util.*;

public class Main_BJ_14890_경사로_김주은2 {
	
	static int N,L;
	static int answer;
	static int[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		answer = N*2;
		
		for(int i=0;i<N;i++) {
			if(!check(i)) {
				answer-=1;
			}
		}
		
		//지도 뒤집기
		for(int i=0;i<N;i++) {
			for(int j=i+1;j<N;j++) {
				int temp = map[i][j];
				map[i][j]=map[j][i];
				map[j][i]=temp;
			}
		}
		
		for(int i=0;i<N;i++) {
			if(!check(i)) {
				answer-=1;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean check(int i) {
		//한 행 탐색
		boolean[] exist = new boolean[N];
		for(int j=0;j<N;j++) {
			
			//왼쪽 탐색
			if(j-1>=0 && map[i][j]>map[i][j-1]) {
				if(j-L>=0) {
					for(int k=1;k<=L;k++) {
						if(map[i][j-k]!=map[i][j]-1 || exist[j-k]) {
							return false;
						}
					}
				}else {
					return false;
				}
				
			}

			//오른쪽 탐색
			if(j+1<N && map[i][j]>map[i][j+1]) {
				if(j+L<N) {
					for(int k=1;k<=L;k++) {
						if(map[i][j+k]!=map[i][j]-1) {
							return false;
						}
					}
					for(int k=1;k<=L;k++) {
						exist[j+k]=true;
					}
				}else {
					return false;
				}
				
			}
		}
		
		return true;
	}

}
