import java.util.*;

class Solution {
    // Kruskal or Prim
    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // disjoint set
        int[] root = new int[n];
        for(int i = 0; i<n; i++){
            root[i] = i;
        }
        
        Arrays.sort(costs, (a,b)->a[2]-b[2]);
        
        for(int[] edge: costs){
            //System.out.println(edge[0] + "," + edge[1] + "," + edge[2]);
            int A = edge[0];
            int B = edge[1];
            
            while(A != root[A]) A = root[A];
            while(B != root[B]) B = root[B];
            
            if(A == B) continue;
            
            answer += edge[2];
            if(A < B)
                root[B] = A;
            else
                root[A] = B;
        }
        
        
        
        
        
        return answer;
    }
}
