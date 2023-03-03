import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_BJ_2239_스도쿠_김주은 {
	
	static int[][] map;
	static int cnt=0;

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		
		for(int i=0;i<9;i++) {
			String s = br.readLine();
			for(int j=0;j<9;j++) {
				map[i][j] = s.charAt(j)-'0';
				if(map[i][j]==0) {
					++cnt;
				}
			}
		}
		
		dfs(0);
	}

	private static void dfs(int c) {

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				if(map[i][j]==0) {
					
					boolean[] visited = new boolean[10];
					//가로, 세로 탐색
					for(int a=0;a<9;a++) {
						if(a!=j) {
							visited[map[i][a]]=true;
						}
						if(a!=i) {
							visited[map[a][j]]=true;
						}
					}
					//칸 탐색
					int x = 3*(i/3);
					int y = 3*(j/3);
					for(int a=x;a<x+3;a++) {
						for(int b=y;b<y+3;b++) {
							if(a==i && b==j) {
								continue;
							}
							visited[map[a][b]]=true;
						}
					}
					
					//없는 숫자 중에 최솟값 선택
					boolean move=true;
					for(int a=1;a<=9;a++) {
						if(visited[a]==false) {
							move=false;
							break;
						}
					}
					if(move) {
						return;
					}
					
					for(int a=1;a<=9;a++) {
						if(visited[a]==false) {
							map[i][j]=a;
							dfs(c+1);
							map[i][j]=0;
						}
					}
					if(c==cnt) {
						for(int a=0;a<9;a++) {
							for(int b=0;b<9;b++) {
								System.out.print(map[a][b]);
							}
							System.out.println();
						}
					}
					return;
					
				}
			}
		}
		
		if(cnt==c) {
			print();
			System.exit(0);
		}
	}

	private static void print() {
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}


}
