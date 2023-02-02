class Solution {
    static int[][]map;
    public int solution(int n, int[][] wires) {
        int answer = n;
        map = new int[n+1][n+1];

        for(int i = 0;i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            map[a][b] = 1;
            map[b][a] = 1;
        }

        for(int i = 0;i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            map[a][b] = 0;
            map[b][a] = 0;

            answer = Math.min(answer, bfs(n, i+1));

            map[a][b] = 1;
            map[b][a] = 1;
        }


        return answer;
    }

    int bfs(int n, int start){
        int cnt = 1;
        Queue<Integer>q = new LinkedList<>();
        boolean[] check = new boolean[n+1];
        q.add(start);
        check[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i = 1; i<=n; i++){
                if(map[now][i]==1 && !check[i]){
                    q.add(i);
                    check[i] = true;
                    cnt++;
                }
            }
        }

        return (int)Math.abs(n-2*cnt);
    }
}