import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16235_나무재테크_정승우 {
    static int n,m,k;
    static int[][] map; // 가장 초기의 양분
    static int[][] map2;// 추가될 양분
    static ArrayList<Integer>[][] treemap;//
    static int[] dr = {1,1,0,-1,-1,-1,0,1};
    static int[] dc = {0,1,1,1,0,-1,-1,-1};
    static int[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //N X N 맵 크기
        m = Integer.parseInt(st.nextToken()); // M개의 나무
        k = Integer.parseInt(st.nextToken()); // K년
        map = new int[n][n];
        map2 = new int[n][n];
        treemap = new ArrayList[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] += 5;
                treemap[i][j] = new ArrayList<>();
            }
        }
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map2[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());//나무의 나이
            treemap[x][y].add(z);
        }


        while(k-->0) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    Collections.sort(treemap[i][j]);
                    int dead = -1;
                    for(int d=0; d<treemap[i][j].size(); d++) {
                        int tree = treemap[i][j].get(d);
                        if(map[i][j]<tree) {
                            dead = d;
                            break;
                        } else {
                            map[i][j]-=tree;
                            treemap[i][j].set(d, tree+1);
                        }
                    }
                    if(dead>=0) {
                        for(int d=treemap[i][j].size()-1; d>=dead; d--) {
                            map[i][j] += treemap[i][j].get(d)/2;
                            treemap[i][j].remove(d);
                        }
                    }
                }
            }

            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    for(int k=0; k<treemap[i][j].size(); k++) {
                        if(treemap[i][j].get(k)%5==0) {
                            for(int d=0; d<8; d++) {
                                int nr = i+dr[d];
                                int nc = j+dc[d];
                                if(0<=nr&&0<=nc&&nr<n&&nc<n) {
                                    treemap[nr][nc].add(1);
                                }
                            }
                        }
                    }
                }
            }



            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    map[i][j]+=map2[i][j];
                }
            }

        }
        int cnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                cnt+=treemap[i][j].size();
            }
        }
        System.out.println(cnt);

    }



}
