package IM;

import java.util.Scanner;

public class Main_1244_스위치켜고끄기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();// 스위치 갯수
		int[] arr = new int[n + 1];
		// 스위치 입력
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			int s = sc.nextInt(); // 남자 1 여자 2
			int num = sc.nextInt();// 스위치 번호

			if (s == 1) {// 남학생일때
				for (int j = 1; j <= n; j++) {

					if (j % num == 0) {// 배수이면

						if (arr[j] == 1) {// 스위치 변경
							arr[j] = 0;
						} else
							arr[j] = 1;
					}
				}
			}

			else {// 여학생일때
				int minus = num - 1;
				int plus = num + 1;
				while (true) {//범위안에있고 대칭수가 같으면
					
					if(minus>=1 && plus <=n && arr[minus] == arr[plus]) {//범위안에있고 같으면
						minus--; //다음범위까지
						plus++;
					}
					else{//범위 벗어나고 다르면
						minus++;
						plus--;
						break;
					}
				
				}
				
				for(int j = minus;j<=plus;j++) {//연속하는 범위
					if (arr[j] == 1) {// 스위치 변경
						arr[j] = 0;
					} else
						arr[j] = 1;
				}
			}

		}
		// 출력
		
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
			if(i%20==0) {//20개씩 출력
				System.out.println();
			}
		}


	}

}
