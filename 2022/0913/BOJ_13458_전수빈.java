package math;



import java.io.*;
import java.util.*;

public class Main_13458_시험감독 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] room = new long[n];
        for(int i =0;i<n;i++){
                room[i]=Integer.parseInt(st.nextToken());
        }
        long[] d = new long[2];
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<2;i++){
            d[i]=Integer.parseInt(st.nextToken());

        }

        long min=0;
        for(int i=0;i<n;i++){
                min++;
                if(room[i]-d[0]>0){
                    room[i] = room[i]-d[0];
                    min+=room[i]/d[1];
                    if(room[i]%d[1]>0){
                        min++;
                    }
                }

            }

        System.out.println(min);
        }






    }

