import java.util.*;

public class IM_02_2605_줄세우기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Integer> list  = new ArrayList<Integer>();
		for (int n = 1; n <= N; n++) {
			list.add(n - 1 - sc.nextInt(), n);
		}
		
		for (Integer i : list) {
			System.out.print(i + " ");
		}
	}

}
