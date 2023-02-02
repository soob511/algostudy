class Solution {
    
    static int diff = 100;
    static boolean[][] map;
    static boolean[] visited;
    static int N,cnt;
    
    public int solution(int n, int[][] wires) {
        
        N=n;
        
        map = new boolean[n+1][n+1];
        
        for(int i=0;i<wires.length;i++){
             map[wires[i][0]][wires[i][1]] = map[wires[i][1]][wires[i][0]] = true;
        }
        
        for(int i=0;i<wires.length;i++){
            map[wires[i][0]][wires[i][1]] = map[wires[i][1]][wires[i][0]] = false;
            //송전탑 갯수 세기 시작
            visited = new boolean[n+1];
            cnt=0;
            for(int j=1;j<=n;j++){
                if(!visited[j]){
                    dfs(j);
                    break;
                }
            }
            diff = Math.min(diff, Math.abs(cnt-(N-cnt)));
        
            //송전탑 갯수 세기 끝
            map[wires[i][0]][wires[i][1]] = map[wires[i][1]][wires[i][0]] = true;
        }
        
        return diff;
    }
    
    public static void dfs(int idx){
        
        visited[idx]=true;
        ++cnt;
        
        for(int i=1;i<=N;i++){
            if(map[idx][i] && !visited[i]){
                dfs(i);
            }
        }
    }
}
