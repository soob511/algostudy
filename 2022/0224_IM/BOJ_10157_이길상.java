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
			if(mode%2 == 0) {
				K-=R;
				C--;
				y+=(R*dy[mode]);
			}
			else {
				K-=C;
				R--;
				x+=(C*dx[mode]);
			}
			
			if(R<0 || C<0) {
				System.out.println(0);
				return;
			}
			
			if(K<=0) {
				x+=(K*dx[mode]);
				y+=(K*dy[mode]);
				System.out.println(x + " " + y);
				return;
			}
			mode = (mode+1)%4;
		}
	}

}
