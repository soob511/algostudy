## 알고리즘

[2048 (Easy)](https://www.acmicpc.net/problem/12100)

- 

## CS

### DB정규화
    - 정의: 데이터베이스 테이블 간 중복된 데이터를 제거하기 위한 작업
    - 1정규화: 한 컬럼은 한 원자값을 나타내야 한다. (A,B) 형태로 한 컬럼에 쓰이면 안됨.
    - 2정규화: 다중 PK일때, 하나의 PK만으로 다른 컬럼이 구별되면 안됨. 부분함수종속 제거.
    - 3정규화: [A,B,C] 테이블일때 A->B, B->C, A->C 가 성립되면 A-B 와 B-C로 테이블을 분리해야 함. 이행함수 종속제거.

### 페이지 교체 알고리즘
    - 페이지란: 가상 메모리를 일정한 크기로 나눈 블록
    - 가상메모리 기법: 주기억장치보다 큰 프로그램의 실행을 위해 일부만 주기억장치에 적재하여 실행하는 것.
    - 페이징 기법: 가상메모리 구현법중 하나. 
    - 종류:
        - OPT - Optimal : 앞으로 가장 오랫동안 사용되지 않을 페이지 교체
        - FIFO - First In First Out
        - LRU - Least Recently Used : 가장 오랫동안 사용되지 않은 페이지 교체
        - LFU - Least Frequently Used : 참조 횟수가 가장 작은 페이지 교체
        - MFU - Most Frequently used : 참조 횟수가 가장 많은 페이지 교체
        - NUR - Not Used Recently : 최근에 사용하지 않은 페이지 교체

### JPA, ORM
    - Object-Relational Mapping
        - 관계형 데이터베이스와 객체를 매핑
        - 객체 중심의 매핑으로 객체의 영속성을 보장
        - 쿼리문을 사용하지 않음
        - JPA(Java Persistence API): ORM 방식을 사용하는 자바 인터페이스

## 과제

- https://www.acmicpc.net/problem/2589

- CS 1문제 준비
