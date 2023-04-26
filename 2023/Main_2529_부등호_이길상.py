K = int(input())
SYMBOL = input().split()

RANGE = []

def select(i, check, nums):
    # 끝까지 도달했으면 출력 후 True 리턴
    if i == K+1:
        print(''.join(map(str, nums)))
        return True

    for n in RANGE:
        if check[n]:
            continue
        
        if i > 0:
            if SYMBOL[i-1] == '<' and n < nums[i-1]:
                continue
            if SYMBOL[i-1] == '>' and n > nums[i-1]:
                continue

        nums[i] = n

        # 재귀 호출에서 True가 반환되면 전체 재귀 종료
        check[n] = True
        if select(i+1, check, nums):
            return True
        check[n] = False
    
    return False

# 큰 숫자부터
RANGE = range(9,-1,-1)
select(0, [False for _ in range(10)], [-1 for _ in range(K+1)])

# 작은 숫자부터
RANGE = range(0,10,1)
select(0, [False for _ in range(10)], [-1 for _ in range(K+1)])
