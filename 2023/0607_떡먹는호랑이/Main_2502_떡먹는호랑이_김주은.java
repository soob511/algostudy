import java.util.Scanner;

public class Main_BJ_2502_떡먹는호랑이_김주은 {
	
	static int D,K;
	static int[][] days;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		D = sc.nextInt();
		K = sc.nextInt();
		
		days = new int[D+1][2];
		
		days[1]= new int[]{1,0};
		days[2]= new int[]{0,1};
		
		for(int i=3;i<=D;i++) {
			days[i][0]=days[i-1][0]+days[i-2][0];
			days[i][1]=days[i-1][1]+days[i-2][1];
		}
		
		for(int i=1;i<K/days[D][0];i++) {
			if((K-days[D][0]*i)%days[D][1]==0) {
				System.out.println(i);
				System.out.println((K-days[D][0]*i)/days[D][1]);
				break;
			}
		}
		
	}

}
