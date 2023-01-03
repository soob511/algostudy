package com.ssafy.day0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1541_정승우 {

	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int temp=Integer.MAX_VALUE;
		int allPlusSum=0;
		String[] allPlusArr;
		for (int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='-') {
				temp=i;
				break;
				
			}
		
		}

		String plus = str.substring(0,temp);
		String minus = str.substring(temp+1,str.length());

		
		String[] plusArr = plus.split("\\+|\\-");
		String[] minusArr = minus.split("\\+|\\-");

		int plusSum=0;
		int minusSum=0;
		
		
		int[] plusInt = new int[plusArr.length];
		int[] minusInt = new int[minusArr.length];
		for (int i=0; i<plusArr.length; i++) {
			plusInt[i] = Integer.parseInt(plusArr[i]);
			plusSum +=plusInt[i];
		}
		for (int i=0; i<minusArr.length; i++) {
			minusInt[i] = Integer.parseInt(minusArr[i]);
			minusSum += minusInt[i];
		}
		System.out.println(plusSum-minusSum);
	}
	

}
