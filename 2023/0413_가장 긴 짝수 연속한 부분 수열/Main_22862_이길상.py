N, K = map(int, input().split())
S = list(map(int, input().split()))

answer = 0

start = 0
end = 0

odd_count = 0

for num in S:
    end+=1
    # 새로운 숫자가 홀수일경우
    if num%2 == 1:
        odd_count += 1
    
    # 범위 내 홀수가 K보다 많은 경우
    while odd_count > K:
        if S[start]%2 == 1:
            odd_count -= 1
        start += 1
    
    # 갱신
    if end-start - odd_count > answer:
        answer = end-start - odd_count
    
print(answer)
