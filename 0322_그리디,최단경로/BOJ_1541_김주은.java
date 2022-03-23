package com.ssafy.add.d0322;

import java.io.*;
import java.util.*;

public class Main_BJ_1541_잃어버린괄호_김주은 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] tokens = br.readLine().split("-"); //-로 구분하여 저장
		
		int result=0;

		for(int i=0;i<tokens.length;i++) {
			String[] numbers = tokens[i].split("\\+");
			for(int j=0;j<numbers.length;j++) {
				if(i==0) {
					result += Integer.parseInt(numbers[j]);
				} else {
					result -= Integer.parseInt(numbers[j]);
				}
			}
		}

		System.out.println(result);
	}

}
