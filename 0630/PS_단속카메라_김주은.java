import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
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
            int left = routes[i][0];
            int right = routes[i][1];
            int j=i+1;
            while(j<routes.length){
                if(routes[j][0]<=routes[i][1]){
                    left=routes[j][0];
                    if(routes[j][1]<=routes[i][1]){
                        right=routes[j][1];
                    }
                }
            }
            //...
        }
        
        
        return answer;
    }
}