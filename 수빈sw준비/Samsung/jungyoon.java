
package Samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class jungyoon {

    public static void main(String[] ars) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int fireballNum = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int[][] deltas = {{n - 1, 0}, {n - 1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, n - 1}, {0, n - 1}, {n - 1, n - 1}};
        Queue<int[]>[][] map = new Queue[n][n];
        Queue<int[]>[][] moveMap = new Queue[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = new LinkedList<>();
                moveMap[i][j] = new LinkedList<>();
            }
        }

        int sum = 0;
        for (int i = 0; i < fireballNum; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int c = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int m = Integer.parseInt(stringTokenizer.nextToken());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int d = Integer.parseInt(stringTokenizer.nextToken());
            sum += m;
            map[r][c].offer(new int[]{m, s, d});
        }

        for (int i = 0; i < k; i++) {
            // step 1. 모든 파이어볼 이동
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    while (!map[x][y].isEmpty()) {
                        int[] poll = map[x][y].poll();
                        int s = poll[1];
                        int d = poll[2];
                        int dx = (x + deltas[d][0] * s) % n;
                        int dy = (y + deltas[d][1] * s) % n;
                        moveMap[dx][dy].offer(poll);
                    }
                }
            }

            // step 2. 2개 이상 파이어볼 네개로 나누기
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < n; y++) {
                    int size = moveMap[x][y].size();
                    if (size > 1) {
                        int odd = 0;
                        int weight = 0;
                        int speed = 0;
                        while (!moveMap[x][y].isEmpty()) {
                            int[] current = moveMap[x][y].poll();
                            weight += current[0];
                            speed += current[1];
                            if (current[2] % 2 == 1) {
                                odd++;
                            }
                        }
                        sum -= weight;

                        // step 4. 질량이 0인 파이어볼 소멸
                        if ((weight /= 5) == 0) {
                            continue;
                        }

                        speed /= size;
                        if (odd == 0 || odd == size) {
                            for (int d = 0; d < 8; d += 2) {
                                map[x][y].offer(new int[]{weight, speed, d});
                            }
                        } else {
                            for (int d = 1; d < 8; d += 2) {
                                map[x][y].offer(new int[]{weight, speed, d});
                            }
                        }
                        sum += weight * 4;
                    } else if (size == 1) {
                        map[x][y].offer(moveMap[x][y].poll());
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
