# 입력
N, M = map(int, input().split())
JEWEL = [int(input()) for _ in range(M)]

# 이진 탐색을 위한 변수 설정
high = sum(JEWEL)
low = 1

# 이진 탐색
while low <= high:
    # 중간값으로 질투심 설정
    j = (low + high) // 2

    # 질투심이 j일 때, 보석을 나눠받는 사람의 수
    cnt = 0

    # 보석을 나눠받는 사람의 수 계산
    for jewel in JEWEL:
        cnt += jewel // j
        cnt += 1 if jewel % j > 0 else 0
    
    # 보석을 나눠받는 사람의 수가 N보다 작거나 같으면 질투심을 낮춤
    if cnt <= N:
        high = j - 1
    # 보석을 나눠받는 사람의 수가 N보다 크면 질투심을 높임
    else:
        low = j + 1

# 출력
print(low)
