import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                } else{
                    return a[0]-b[0];
                }
            }
        });
        
        boolean[] visited = new boolean[routes.length];
        
        for(int i=0;i<routes.length;i++){
            
            if (visited[i]) continue;
            
            int left = routes[i][0];
            int right = routes[i][1];
            int j=i+1;
            visited[i] = true;
            
            while(j<routes.length){
                // 공통범위와 겹칠 때
                if(routes[j][0]<=right){
                    left=routes[j][0];
                    if(routes[j][1]<=right){
                        right=routes[j][1];
                    }
                    visited[j] = true;
                    j++;
                }
                else{
                    answer++;
                    break;
                }
            }
        }
        
        return answer;
    }
}
