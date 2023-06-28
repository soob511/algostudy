import java.util.*;

public class Main_BJ_14395_4연산_김주은 {

	static class Node {
		long s;
		String path;

		public Node(long s, String path) {
			super();
			this.s = s;
			this.path = path;
		}
	}

	static final int MAX = 1000000000;
	static HashSet<Long> set = new HashSet<>();
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long S = sc.nextInt();
		long T = sc.nextInt();
		
		if(S==T) {
			System.out.println(0);
			return;
		}

		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(S, ""));
		set.add(S);

		while (!q.isEmpty()) {

			Node node = q.poll();

			long nextS = 0;
			for (int i = 0; i < 4; i++) {

				if (i == 0) {
					nextS = node.s * node.s;
				} else if (i == 1) {
					nextS = node.s + node.s;
				} else if (i == 2) {
					nextS = 0;
				} else if (i == 3) {
					if (node.s == 0) {
						continue;
					}
					nextS = 1;
				}

				if (nextS == T) {
					System.out.println(node.path + (i == 0 ? "*" : i == 1 ? "+" : i == 2 ? "-" : "/"));
					return;
				}

				// 범위 초과 또는 방문한 경우
				if (nextS >= MAX || set.contains(nextS)) {
					continue;
				}

				set.add(nextS);
				q.add(new Node(nextS, node.path + (i == 0 ? "*" : i == 1 ? "+" : i == 2 ? "-" : "/")));
			}
		}

		System.out.println(-1);

	}

}
