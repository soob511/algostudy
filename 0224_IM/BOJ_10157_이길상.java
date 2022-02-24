import java.util.*;

public class IM_09_10157_자리배정 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt(), R = sc.nextInt();
		int K = sc.nextInt();
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int x = 1, y = 0;
		int mode = 0;
		
		while(true) {
			int I;
			if(mode%2 == 0) {
				I = R;
				C--;
			}
			else {
				I = C;
				R--;
			}
			
			if(I == 0) {
				System.out.println(0);
				return;
			}
			
			for (int i = 0; i < I; i++) {
				x+= dx[mode];
				y+= dy[mode];
				if(--K == 0) {
					System.out.println(x + " " + y);
					return;
				}
			}
			mode = (mode+1)%4;
		}
		
		
//		while(true) {
//			for (int r = 0; r < R; r++) y++;
//			C--;
//			
//			for (int c = 0; c < C; c++) x++;
//			R--;
//			
//			for (int r = 0; r < R; r++) y--;
//			C--;
//			
//			for (int c = 0; c < C; c++) x--;
//			R--;
//		}
	}

}
