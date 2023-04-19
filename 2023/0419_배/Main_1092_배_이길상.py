# 입력
N = int(input())
CRANE = list(map(int, input().split()))
M = int(input())
BOX = list(map(int, input().split()))

# 화물이 옮겨졌는지 체크
check = [False for _ in range(M)]

# 정렬
CRANE.sort(key = lambda x:-x)
BOX.sort(key = lambda x:-x)

# 못 옮기는 화물이 있을 경우
if BOX[0] > CRANE[0]:
    print(-1)
    exit(0)

time = 0

while True:
    idx = 0
    count = 0
    for c in CRANE:
        # 배정 가능한 가장 큰 화물 찾기
        while idx < M and (check[idx] or BOX[idx] > c):
            idx+=1
        
        # 화물을 전부 체크했다면 반복문 종료
        if idx == M:    
            break

        check[idx] = True
        count += 1

    if count ==0:
        break
    time += 1

print(time)
