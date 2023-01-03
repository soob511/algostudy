package greedy;

import java.util.Scanner;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String[] minus = s.split("\\-"); //-으로 나눠주기

		int sum = 0;
		for (int i = 0; i < minus.length; i++) {
			String[] plus = minus[i].split("\\+");//+로 나눠주기

			for (int j = 0; j < plus.length; j++) {
				if (i == 0) {//처음엔 더하기

					sum += Integer.parseInt(plus[j]);
				} else {

					sum -= Integer.parseInt(plus[j]);
				}
			}

		}
		System.out.println(sum);
	}

}
