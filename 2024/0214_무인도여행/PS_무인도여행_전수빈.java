import java.util.*;
class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int[] solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][] map = new char[n][m];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        boolean[][] visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]!='X'&&!visit[i][j]){
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visit[i][j] = true;
                    int sum = (int)map[i][j]-48;
                    while(!q.isEmpty()){
                        int[] p = q.poll();
                        int x = p[0];
                        int y = p[1];
                        for(int d=0;d<4;d++){
                            int nx = x+dx[d];
                            int ny = y+dy[d];
                            if(nx<0||ny<0||nx>=n||ny>=m||map[nx][ny]=='X'||visit[nx][ny])continue;
                            q.add(new int[]{nx,ny});
                            visit[nx][ny] = true;
                            sum += (int)map[nx][ny]-48;
                        }
                    }
                    list.add(sum);
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        if(list.size()==0){
          answer = new int[1];
          answer[0] = -1;
        }
        Arrays.sort(answer);
        return answer;
    }
}