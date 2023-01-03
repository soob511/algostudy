import java.util.Arrays;
import java.util.Comparator;

class Solution {
    private int[] island;	
    public int solution(int n, int[][] costs) {
		Arrays.sort(costs, new Comparator<int[]>() {	

            
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[2] == o2[2]) {
					return o1[1] - o2[1];
				} else {
					return o1[2] - o2[2];
				}
			}
		});
        
        for(int[] i : costs) {
            System.out.println(Arrays.toString(i));
        }

		island = new int[n];
		for (int i = 0; i < island.length; i++) {	
			island[i] = i;
		}
        

		int answer = 0;
		for (int i = 0; i < costs.length; i++) {	
			int start = find(costs[i][0]);
			int end = find(costs[i][1]);
			if (start != end) { 
				island[end] = start; 
				answer += costs[i][2];
			}
		}
		return answer;

    }
    private int find(int child) {	
		if (island[child] == child) {
			return child;
		} else {
			return island[child] = find(island[child]);
		}
	}
}