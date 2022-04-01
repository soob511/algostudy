package dp;

import java.util.Scanner;

public class Main_2579_계단오르기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();//계단의 수
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {//입력
			arr[i] = sc.nextInt();
		}

		int[] d = new int[n + 1];
		d[1] = arr[1];
		
		for (int i = 2; i <= n; i++) {
			if (i == 2) {
				d[2] = arr[1] + arr[2];//첫번째 계단을 밟는게 최대값
			} else if (i == 3) {
				d[3] = Math.max(arr[1], arr[2]) + arr[3];
			} else {

				d[i] = Math.max(d[i - 2], d[i - 3] + arr[i - 1]) + arr[i];
			}

		}

		System.out.println(d[n]);
	}

}
