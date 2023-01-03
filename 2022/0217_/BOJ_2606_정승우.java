package com.ssafy.day0215;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_2606_정승우 {

	
    static int answer=0;
    //체크 배열
    static boolean[] check;
    //배열안에 ArrayList 선언
    static ArrayList<Integer>[] arrayLists;
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        //노드의 수
        int N = sc.nextInt();
        check = new boolean[N];
        //arrayLists에 ArrayList를 N개만큼 담을 공간 생성
        
        arrayLists = new ArrayList[N];

        for (int i = 0; i < N; i++) {
        	//체크에 값을 모두 true로 바꿔줌
            check[i]=true;
            arrayLists[i] = new ArrayList<Integer>();
        }


        //간선 수
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
        	//a노드, b노드
            int a = sc.nextInt();
            int b = sc.nextInt();

            //연결된 노드들 서로 저장
            arrayLists[a-1].add(b-1);
            arrayLists[b-1].add(a-1);
        }

        dfs(0);
        answer--;
        System.out.println(answer);
    }

    private static void dfs(int idx) {

    	//방문한 곳이면 return
        if(!check[idx]) return;

        //새로운곳을 방문했다면 answer +1
        answer++;
        
        // 새로 방문한 곳 false
        check[idx] = false;

        //arrayLists의 idx번째에 접근하는 edges 생성
        ArrayList<Integer> edges = arrayLists[idx];

        //edges 안의 값을 edge로 꺼내고 다시 재귀를 탐
        for (Integer edge : edges) {
            dfs(edge);
        }
    }
}