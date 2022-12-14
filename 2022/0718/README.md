## 알고리즘

[보물섬](https://www.acmicpc.net/problem/2589)

- 

## CS

### 세마포어와 뮤텍스
    - 공통점: 둘 다 임계 영역에 대한 병행 처리를 위한 동기화 기법.
    - 세마포어: 임계 영역에 접근 가능한 프로그램의 수를 제한. ex)3개 라고 하면 카운트를 증가시켜 가며 접근을 허용. 
    - 뮤텍스: 이진 세마포어와 비슷. 접근 가능한 프로그램 수가 0 또는 1. 현재 임계 영역에 접근중인 프로세스가 제어 주체가 되는 차이가 있다.
        - lock: lock을 획득환 프로그램만 임계 영역에 접근 가능하다.

### 데드락 Again
    - 데드락이란?(교착상태)
        - 프로세스가 자원을 얻지 못해 다음 처리를 하지 못하는 상태로, '교착 상태'라고도 하며, 시스템적으로 한정된 자원을 여러 곳에서 사용하려고 할 때 발생한다.
    - 데드락의 발생 조건 4가지 : 교착 상태는 한 시스템 내에서 다음의 4가지 조건이 동시에 성립할 때 발생한다.
        - 상호 배제(Mutual Exclusion) : 자원은 한 번에 한 프로세스만이 사용할 수 있어야 한다.
        - 점유 대기 (Hold and Wait) : 최소한 하나의 자원을 점유하고 있으면서 다른 프로세스에 할당되어 사용되고 있는 자원을 추가로 점유하기 위해 대기하는 프로세스가 있어야 한다.
        즉, 이미 자원을 사용중인데, 다른 프로세스가 사용중인 자원을 사용하기 위해 대기하고 있는 상태의 프로세스가 존재해야 한다.
        - 비선점 (No preemption) : 다른 프로세스에 할당된 자원은 사용이 끝날 때까지 강제로 빼앗을 수 없어야 한다.
        - 순환 대기 (Circular wait) : 프로세스의 집합에서 P0은 P1이 점유한 자원을 대기하고 P1은 P2가 점유한 자원을 대기하고, P2...Pn-1d은 Pn이 점유한 자원을 대기하며 Pn은 P0이 점유한 자원을 요구해야 한다.


### 자바의 메모리 영역
    - 힙: 인스턴스 생성시 저장되는 영역. new 키워드로 생성되는 것들이 저장됨. JVM의 가비지 컬렉션에 의해 관리됨.
    - 스택 : 메소드 호출 시 그 정보(지역변수와 매개변수) 데이터 값이 저장됨. Last In First Out 구조.
    - 메소드: 런타임 이전에 할당되는 공간. 전역변수와 static 변수를 저장. 프로그램 종료시까지 메모리에 존재.

### 쓰레드와 프로세스의 차이
    - 정의: 프로세스는 운영체제로부터 자원을 할당받아 실행되며, 스레드는 프로세스로부터 자원을 할당받아 실행됩니다.
    - 차이점
        - 멀티 쓰레드가 멀티 프로세스보다 쉽고 효율적이다. Context Switching이 빠르다.
            - 현재 진행하고 있는 Task(Process, Thread)의 상태를 저장하고 다음 진행할 Task의 상태 값을 읽어 적용하는 과정을 말합니다.
        - 멀티 쓰레드는 하나의 쓰레드가 멈추는 것이 치명적이다. 멀티 프로세스는 프로세스 하나가 죽어도 영향이 적다.
        - 프로세스는 코드/데이터/스택/힙 메모리 영역을 기반으로 실행.
        - 스레드는 프로세스와 별개의 독립된 스택을 사용하며 나머지는 프로세스와 공유합니다.
        - 스레드끼리는 프로세스 내 스택 영역을 제외한 메모리를 공유한다.


## 과제

- https://www.acmicpc.net/problem/13549

- CS 1문제 준비
