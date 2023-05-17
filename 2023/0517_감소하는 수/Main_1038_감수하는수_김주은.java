import java.util.*;

public class Main_BJ_1038_감소하는수_김주은2 {
	
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws Exception{

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N<10) {
			System.out.println(N);
			return;
		}
		
		for(long i=0;i<10;i++) {
			list.add(i);
		}
		for(long i=0;i<10;i++) {
			dfs(i);
		}
		
		Collections.sort(list);
		
		if(N<list.size()) {
			System.out.println(list.get(N));
		}else{
			System.out.println(-1);
		}
		
	}

	private static void dfs(long v) {
		for(long i=0;i<10;i++) {
			if(v%10>i) {
				list.add(v*10+i);
				dfs(v*10+i);
			}
		}
	}

}
