import java.util.*;
import java.io.*;

public class Main {
   static int N, K, turn = 1;

   static int[][] board;
   static LinkedList<Integer>[][] piece;
   static int[][] info;

   static int[] dr = {0,0,-1,1};
   static int[] dc = {1,-1,0,0};

   // k번째 말 옮기기
   static void move(int k){
      // System.out.println("MOVE " + k);
      int[] e = info[k];
      int r = e[0], c = e[1], d = e[2];

      int nr = r+dr[d];
      int nc = c+dc[d];

      // 체스판 밖이거나 파란색일경우
      if (nr<0||nc<0||nr==N||nc==N || board[nr][nc]==2){
         // 방향 바꾸기
         d^=1;
         info[k][2] = d;

         nr = r+dr[d];
         nc = c+dc[d];
         if (nr<0||nc<0||nr==N||nc==N || board[nr][nc]==2){
            //System.out.println("blue: " + k + ": change d to " + d);
            return;
         }
         move(k);
      }
      // 빨간색
      else if ( board[nr][nc]== 1 ){
         while(piece[nr][nc].size()==0 || piece[nr][nc].getLast()!=k){
            int p = piece[r][c].removeLast();
            info[p][0] = nr;
            info[p][1] = nc;
            // System.out.println("red: " + p + " move to " + nr + "," + nc);
            piece[nr][nc].add(p); 
         }
      }
      // 흰색
      else{
         int idx = 0;
         while(piece[r][c].get(idx) != k) 
            idx++;
         while(piece[r][c].size()>idx){
            int p = piece[r][c].remove(idx);
            info[p][0] = nr;
            info[p][1] = nc;
            // System.out.println("white: " + p + " move to " + nr + "," + nc);
            piece[nr][nc].add(p);
         }
      }

      // 종료 조건
      if (piece[nr][nc].size()>=4){
         System.out.println(turn);
         System.exit(0);
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] line = br.readLine().split(" ");
      N = Integer.parseInt(line[0]);
      K = Integer.parseInt(line[1]);

      board = new int[N][N];
      piece = new LinkedList[N][N];
      info = new int[K][3];

      for (int n = 0; n < N; n++) {
         line = br.readLine().split(" ");
         for (int i = 0; i < N; i++) {
            board[n][i] = Integer.parseInt(line[i]);
            piece[n][i] = new LinkedList<>();
         }
      }

      for (int k = 0; k < K; k++) {
         line = br.readLine().split(" ");
         int r = Integer.parseInt(line[0])-1;
         int c = Integer.parseInt(line[1])-1;
         int d = Integer.parseInt(line[2])-1;
         info[k][0]=r;
         info[k][1]=c;
         info[k][2]=d;
         piece[r][c].add(k);
      }

      for (; turn <= 1000; turn++) {
         // System.out.println("TURN: " + turn);
         for (int k = 0; k < K; k++) {
            move(k);
         }
      }
      
      System.out.println(-1);
   }
      
}
