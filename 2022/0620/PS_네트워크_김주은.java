class Solution {
    
    static boolean[] linked; //방문여부 체크
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        
        linked = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!linked[i]){ //미방문 노드만 search
                search(i, n, computers);
                ++answer;
            }
        }
        
        return answer;
    }
    
    static void search(int i, int n, int[][] computers){
        for(int j=0;j<n;j++){
            if(i!=j && computers[i][j]==1 && !linked[j]){
                linked[j]=true;
                search(j,n,computers);
            }
        }
    }
}