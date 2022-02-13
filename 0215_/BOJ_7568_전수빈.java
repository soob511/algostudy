package bruteforce;

import java.util.Scanner;

public class Main_7568_덩치 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] p = new int[n][2];
		for(int i=0;i<n;i++) {
			p[i][0] = sc.nextInt();
			p[i][1] = sc.nextInt();
			
		}
		
		for(int i =0;i<n;i++) {
			int rank=1;
			for(int j =0;j<n;j++) {
				if(i==j) continue;
				if(p[i][0]<p[j][0]&&p[i][1]<p[j][1]) {
					rank++;
				}
			}
			System.out.print(rank+" ");
			
		}
		
		
		
		
		
	}

}
