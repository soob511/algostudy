import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_20057_마법사상어와토네이도_정승우 {
    static int N;
    static int[][] map;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {-1,0,1,0};
    static int[] dd = {1,1,2,2};
    static int[][] dsr = {{-1,1,-2,-1,1,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},
            {1,-1,2,1,-1,-2,1,-1,0}, {1,1,0,0,0,0,-1,-1,-2}};
    static int[][] dsc = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-2,-1,1,2,-1,1,0},
            {-1,-1,0,0,0,0,1,1,2},{1,-1,2,1,-1,-2,1,-1,0}};
    static int[] sandRatio ={1,1,2,7,7,2,10,10,5};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        map = new int[N][N];

        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int result = calculate(N/2, N/2);
        System.out.println(result);




    }
    //현재위치에서 이동 -> 이동한 위치의 모래 뿌리기 -> 이동한위치를 현재위치로 업데이트
    static int calculate(int r, int c){
        int totalOutSand = 0;

        int cr = r;
        int cc = c;

        while (true) {
            for(int d = 0; d<4; d++){
                for(int moveCount = 0; moveCount<dd[d]; moveCount++){
                    //현재위치에서 이동
                    int nr = cr+dr[d];
                    int nc = cc+dc[d];

                    if(0<=nr&&0<=nc&&nr<N&&nc<N) {
                        //이동한 위치의 모래 뿌리기
                        int sand = map[nr][nc];
                        map[nr][nc] = 0;
                        int spreadTotal = 0;

                        for(int spread = 0; spread<9; spread++){
                            int sandr = nr + dsr[d][spread];
                            int sandc = nc + dsc[d][spread];
                            int spreadAmount = (sand*sandRatio[spread])/100;

                            if(sandr<0 || sandr>=N || sandc<0 || sandc>=N){
                                totalOutSand += spreadAmount;
                            }
                            else{
                                map[sandr][sandc]+=spreadAmount;
                            }
                            spreadTotal+= spreadAmount;
                        }

                        int alphaX = nr+dr[d];
                        int alphaY = nc+dc[d];
                        int alphaAmount = sand -spreadTotal;
                        if(alphaX<0 || alphaX>=N || alphaY<0|| alphaY>=N){
                            totalOutSand +=alphaAmount;
                        }
                        else{
                            map[alphaX][alphaY] +=alphaAmount;
                        }


                        //이동한 위치를 현재위치로 업데이트
                        cr = nr;
                        cc = nc;
                    } else {
                        return totalOutSand;
                    }


                }
            }

            //횟수 업데이트
            for(int i = 0; i<4; i++){
                dd[i] +=2;
            }
        }
    }

}