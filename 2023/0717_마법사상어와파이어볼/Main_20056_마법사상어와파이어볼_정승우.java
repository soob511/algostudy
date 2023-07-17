import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_20056_마법사상어와파이어볼_정승우 {
    static int N,M,K;
    static int r,c,m,s,d;
    static List<Pos> list;
    static Queue<Pos> [][] q;
    static int[] dr = {-1,-1,0,1,1,1,0,-1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken())-1;
            c = Integer.parseInt(st.nextToken())-1;
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            list.add(new Pos(r,c,m,s,d));
        }

        q = new Queue[N][N];

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                q[i][j] = new LinkedList<>();
            }
        }

        while(K!= 0) {
            // 이동하기
            for(Pos p : list) {
                p.r = (N + p.r + dr[p.d] * (p.s % N)) % N;
                p.c = (N + p.c + dc[p.d] * (p.s % N)) % N;
                q[p.r][p.c].add(p);
            }
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(q[i][j].size() >=2) {
                        int m_sum = 0;
                        int s_sum = 0;
                        int cnt = q[i][j].size();
                        boolean odd = true;
                        boolean even = true;
                        while(!q[i][j].isEmpty()) {
                            Pos p = q[i][j].poll();

                            m_sum += p.m;
                            s_sum += p.s;

                            if(p.d % 2 == 0) {
                                odd = false;
                            } else {
                                even = false;
                            }
                            list.remove(p);
                        }
                        int d_m = m_sum / 5;
                        if(d_m == 0) continue;
                        int d_s = s_sum / cnt;
                        if(odd || even) {
                            for(int k=0; k<8; k+=2) {
                                list.add(new Pos(i,j,d_m,d_s,k));
                            }
                        } else {
                            for(int k=1; k<8; k+=2) {
                                list.add(new Pos(i,j,d_m,d_s,k));
                            }
                        }
                    } else {
                        q[i][j].clear();
                    }
                }
            }
            K--;
        }
        int res = 0;
        for(Pos p : list) {
            res += p.m;
        }
        System.out.println(res);



    }

    static class Pos{
        int r,c,m,s,d;

        Pos(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
