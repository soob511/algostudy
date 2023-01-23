import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BJ_17281_야구공_김주은 {

	static int N;
	static int[][] hit;

	static int max_score = 0;

	static boolean[] visited;
	static int[] seq;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		hit = new int[N][10];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				hit[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[10];
		seq = new int[10];

		playerSequence(1);
		
		System.out.println(max_score);

	}

	private static void playerSequence(int cnt) {

		if (cnt == 10) {
			int score = playGame();
			if (score > max_score) {
				max_score = score;
			}
			return;
		}

		for (int i = 1; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				seq[cnt] = i;
				if (cnt >= 4 && seq[4] != 1) {
					visited[i] = false;
					return;
				}
				playerSequence(cnt + 1);
				visited[i] = false;
			}
		}
	}

	private static int playGame() {
		
		int score = 0;
		int idx=1;
		
		for (int i = 0; i < N; i++) {
			int[] field = new int[4];// 0 : 홈, 1 : 1루, 2 : 2루, 3 : 3루
			
			int out=0;

			while(out<3) {
				int pnumber = seq[idx];
				int pscore = hit[i][pnumber];
				
				if(pscore==0) {
					++out;
				} else {
					//타자들 움직임
					field[0]=1;//주자
					for(int t=3;t>=0;t--) {
						int next = t+pscore;
						if(next>3) {
							if(field[t]>0) {
								score+=1;
							}
						} else {
							field[next]=field[t];
						}
						field[t]=0;
					}
				}
				//다음 순서 인덱스
				idx= idx%9+1;
			}

		}

		return score;
	}

}
