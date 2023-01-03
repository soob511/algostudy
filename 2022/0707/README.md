## 알고리즘

[불량 사용자](https://school.programmers.co.kr/learn/courses/30/lessons/64064)

- 순열과 조합을 모두 활용해야 했던 문제.
- N의 범위자 최대 8로 시간복잡도는 크게 상관없음.

## CS

### JIT란 무엇인가?
    - Just-In-Time 컴파일러의 약자
    - 프로그램 실행을 할때, 모든 요소를 컴파일해 한꺼번에 실행 프로그램으로 작동하는게 아니라, 필요한 일부분만 즉석에서 컴파일해서 사용한다는 것.
    - 어플리케이션 같은 프로그램을 실행 할 때, 사소한 변경점에 대해서 다시 빌드하는 일 없이 Hot-Reload/Hot-Restart 가 가능하다.
    - Flutter 등에서 쓰임. 
    - 인터프리터(Python 등)와는 다르다
        https://nohhh.tistory.com/entry/%EC%9D%B4%EB%A1%A0-%EC%BB%B4%ED%8C%8C%EC%9D%BC%EB%9F%AC-%EC%9D%B8%ED%84%B0%ED%94%84%EB%A6%AC%ED%84%B0-JIT

### Race Condition
    - 경쟁 상태: 
        - 두 개 이상의 프로세스가 공통 자원을 사용할 때 접근순서에 따라 실행 결과가 달라지는 상황.
        - 모든 프로세스에 원하는 결과가 발생하는 것을 보장할 수 없음. Race condition 현상이 발생할 수 있는 영역을 임계구역(Critical Section)이라 한다.
    - 해결을 위한 3가지 조건
        - 상호배제(Mutual exclusion) : 임계영역에는 하나의 프로세스만 접근 가능
        - 진행(progress) : 임계영역에 접근 중인 프로세스가 없을 경우에, 진입을 요구할 경우 유한한 시간내에 진입해야한다. 정당한 진입 프로세스를 막으면 안된다. 
        - 한정된 대기(bounded waiting) : 임계영역에 대한 진입의 요청을 했을 경우, 무한히 기다리지 않고 유한한 시간내에 진입해야한다.

### HashSet
    - Java의 Collection 중 하나. 
    - Set 인터페이스에서 지원하는 구현 클래스. null 요소도 허용한다.
    - 중복을 확인하는 과정에서 Hash함수를 활용한다.
    - 오늘의 문제에서 활용 가능.
    - SortedSet이라는 것도 존재한다. HashSet 과 비슷하나 정렬되어 있다.


## 과제

- https://www.acmicpc.net/problem/12100

- CS 1문제 준비
