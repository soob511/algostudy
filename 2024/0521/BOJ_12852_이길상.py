N = int(input())

# count[i] = i를 1로 만드는 최소 연산 횟수
count = [-1] * (N+1)
# track[i] = i에서 최소 연산을 만드는 다음 숫자
track = [0] * (N+1)

# 1부터 시작해서 N까지 계산하기
count[1] = 0
for i in range(2, N+1):
    # 1을 빼는 연산
    count[i] = count[i-1] + 1
    track[i] = i-1

    # 3으로 나누어지는 경우
    if i % 3 == 0 and count[i] > count[i//3] + 1:
        count[i] = count[i//3] + 1
        track[i] = i//3
    
    # 2로 나누어지는 경우
    if i % 2 == 0 and count[i] > count[i//2] + 1:
        count[i] = count[i//2] + 1
        track[i] = i//2

# 출력
print(count[N])
while N != 0:
    print(N, end=' ')
    N = track[N]
print()
