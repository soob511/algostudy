import java.io.*;
import java.util.*;

public class Main_BJ_1027_고층건물_김주은 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] building = new int[N];
		
		for(int i=0;i<N;i++) {
			building[i] = sc.nextInt();
		}
		
		int max=0;
		
		for(int i=0;i<N;i++) {
			int cnt=0;
			double mgl = 1000000000, mgr= -1000000000;
			
			//왼쪽 빌딩 확인
			int l = i-1;
			while(l>=0) {
				double grad = gradient(i,building[i],l,building[l]);
				if(grad<mgl) {
					mgl = grad;
					++cnt;
				}
				--l;
			}
			
			//오른쪽 빌딩 확인
			int r = i+1;
			while(r<N) {
				double grad = gradient(i,building[i],r,building[r]);
				if(grad>mgr) {
					mgr = grad;
					++cnt;
				}
				++r;
			}
			
			if(cnt>max) {
				max=cnt;
			}
		}
		
		System.out.println(max);
	}

	//(x1, y1)과 (x2, y2)를 지나는 직선의 기울기 구하기
	private static double gradient(int x1, int y1, int x2, int y2) {

		//왼쪽 기울기
		if(x1>x2) {
			return (double)(y1-y2)/(x1-x2);
		} 
		//오른쪽 기울기
		else {
			return (double)(y2-y1)/(x2-x1);
		}

	}
}
