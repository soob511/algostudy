import java.io.*;
import java.util.*;

public class Main_BJ_3190_뱀_김주은 {
	
	//방향: 동0, 남1, 서2, 북3
	static int[] dr = {0,1,0,-1};
	static int[] dc = {1,0,-1,0};

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		
		LinkedList<int[]> snake = new LinkedList<>();
		snake.add(new int[] {0,0,0});//x,y,방향
		
		int K = Integer.parseInt(br.readLine()); //사과의 위치
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			map[x][y]=1;
		}
		
		int[] times = new int[10001];//L:-1(왼쪽), D:1(오른쪽)
		
		int L = Integer.parseInt(br.readLine());//방향 전환 횟수
		for(int k=0;k<L;k++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char y = st.nextToken().charAt(0); 
			if(y=='L') {
				times[x]=-1;
			}else {
				times[x]=1;
			}
		}
		
		int time=0;

		while(true) { //1. x초간 이동
			++time;
			
			//1. 머리 추가
			int[] prevHead = snake.get(snake.size()-1);
			
			int nextHeadX = prevHead[0]+dr[prevHead[2]];
			int nextHeadY = prevHead[1]+dc[prevHead[2]];
			
			//1-1. 다음 머리가 몸이나 벽에 부딪히지 않는지 확인하기
			if(nextHeadX < 0 || nextHeadX>=N || nextHeadY<0 || nextHeadY>=N) {
				System.out.println(time);
				return;
			}
			for(int[] body : snake) {
				if(body[0]==nextHeadX && body[1]==nextHeadY) {
					System.out.println(time);
					return;
				}
			}
			
			//1-2. 머리 방향을 바꿔야하는 경우
			int nextHeadDir = prevHead[2];
			if(times[time]>0) {//오른쪽90도
				nextHeadDir = (prevHead[2]+1)%4;
			} else if(times[time]<0) {//왼쪽90도
				nextHeadDir = (prevHead[2]-1)<0?3:prevHead[2]-1;
			}
			
			snake.add(new int[] {nextHeadX, nextHeadY, nextHeadDir});
			
			//2. 꼬리 제거 유무
			if(map[nextHeadX][nextHeadY]==0) {//사과 안먹으면 꼬리 삭제
				snake.remove(0);
			} else {
				map[nextHeadX][nextHeadY]=0; //사과 먹기
			}
			
		}
		
		
	}

}
