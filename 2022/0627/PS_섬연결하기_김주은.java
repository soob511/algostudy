import java.util.*;

class Solution {
    
    static int[] parents;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        Arrays.sort(costs, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2]-o2[2];
            }
        });
        
        parents = new int[n];
        
        for(int i=0;i<n;i++){
            parents[i]=i; //자신의 부모노드를 자신의 값으로 세팅
        }
        
        int cnt = 0;
        
        for(int[] node : costs){
            if(union(node[0],node[1])){
                answer += node[2];
                if(++cnt == n-1) break;
            }
        }
        
        return answer;
    }
    
    static boolean union(int a, int b){
        
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        
        if(aRoot==bRoot) return false;
        
        parents[bRoot] = aRoot;
        return true;
    }
    
    static int findSet(int x){
        if(x==parents[x]) return x;
        return parents[x]=findSet(parents[x]);
    }
}