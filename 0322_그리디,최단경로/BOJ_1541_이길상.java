package day0322;
import java.io.*;
import java.util.*;

public class BOJ_1541_이길상 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        // 입력
        String line = br.readLine();
        
        // 수식 분할
        List<Integer> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
        	char c = line.charAt(i);
        	// 숫자일 경우
        	if('0'<=c && c<='9') {
        		num *=10;
        		num += (c-'0');
        	}
        	// 연산자일 경우
        	else {
        		numbers.add(num);
        		num = 0;
        		operators.add(c);
        	}
		}
		numbers.add(num);
		
		// 계산
		int result = numbers.remove(0);
		
		while(operators.size()>0) {
			char c = operators.remove(0);
			if(c == '+') {
				result += numbers.remove(0);
			}
			// 첫 뺄셈 이후로는 전부 빼기로 변환 가능
			else {
				while(numbers.size()>0) {
					result -= numbers.remove(0);
				}
				break;
			}
		}
		
		System.out.println(result);
    }

}
