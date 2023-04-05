import java.util.*;
import java.io.*;
public class CODETREE_나무타이쿤_정승우 {
    static int n,m;
    static int map[][];
    static int[] dr = {0, -1, -1, -1,  0,  1, 1, 1};
    static int[] dc = {1,  1,  0, -1, -1, -1, 0, 1};
    static boolean check[][];
    static boolean check2[][];


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        check = new boolean[n][n];
        check2 = new boolean[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //처음 왼쪽하단 추가
        for(int i=n-2; i<n; i++) {
            for(int j=0; j<2; j++) {
                check[i][j] = true;
            }
        }

        //진행년도 동안 반복
        while(m-->0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            d--;

            //다음위치 저장할 check2 초기화
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    check2[i][j] = false;
                }
            }


            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    //check된 값이면
                    if(check[i][j]==true) {
                        //이동할 위치
                        int nr = (i + dr[d] * p + n * p) % n;
                        int nc = (j + dc[d] * p + n * p) % n;

                        //체크2에 이동할 위치 체크
                        check2[nr][nc] = true;
                    }
                }
            }

            //check2값 check에 저장
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    check[i][j] = check2[i][j];
                }
            }

            //이동한칸 높이 1만큼 증가
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(check[i][j]==true) {
                        map[i][j]++;
                    }
                }
            }
            //대각선 증가
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(check[i][j]==true) {
                        int cnt = 0;
                        for(int k=1; k<8; k+=2) {
                            int nr = i + dr[k];
                            int nc = j + dc[k];
                            if(0<=nr&&0<=nc&&nr<n&&nc<n&&1<=map[nr][nc]) {
                                cnt++;
                            }
                        }
                        map[i][j] += cnt;

                    }
                }
            }

            //check 초기화
            //전년도에 사용되지 않은것중 높이가 2이상은 다시 체크
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(check[i][j] == true) {
                        check[i][j] = false;
                    }else if( 2<= map[i][j]) {
                        check[i][j] = true;
                        map[i][j] -= 2;
                    }
                }
            }

        }

        int res = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                res += map[i][j];
            }
        }
        System.out.println(res);
    }


}