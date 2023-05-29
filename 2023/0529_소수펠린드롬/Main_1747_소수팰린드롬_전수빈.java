package Bruteforce;

import java.io.*;
import java.util.*;
public class Main_1747_소수팰린드롬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        for (int i = n; i <=1003001; i++) {
                stack.clear();
                String s = i+"";
                String r = "";
            for (int j = 0; j <s.length(); j++) {
                stack.push(s.charAt(j));
            }
            int size = stack.size();
            for (int j = 0; j <size; j++) {
                r+=stack.pop();
            }
            int count=0;
            if(s.equals(r)){
                for (int j = 1; j <=i; j++) {
                    if(i%j==0){
                        count++;
                    }
                }
            }
            if(count==2){
                System.out.println(i);
                break;
            }
        }

    }
}
