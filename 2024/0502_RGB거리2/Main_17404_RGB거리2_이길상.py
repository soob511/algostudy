MAX = 1000*1000

# N = 집 개수
N = int(input())

# COSTS[n][i] = n번째 집을 i로 칠하는 비용
COSTS = [list(map(int, input().split())) for _ in range(N)]

# DP[n][a][b] = cost(n, a, b) 의 결과 저장
DP = [[[0, 0, 0] for _ in range(3)] for _ in range(N)]

# n번째 집부터 끝까지, 시작 색 a 끝 색 b로 칠할 때 최소 비용
def cost(n, a, b):
    # 마지막 두 집이면서 같은 색일 경우
    if n + 1 == N-1 and a == b:
        return MAX

    # 마지막 한 집일 경우
    if n + 1 == N:
        return COSTS[n][b]

    # 아직 구해보지 않은 값일 경우
    if DP[n][a][b] == 0:
        # a를 제외한 다음 값에 대한 최소 비용 계산
        x = cost(n+1, (a+1)%3, b)
        y = cost(n+1, (a+2)%3, b)

        # n번째 집을 a로 칠한 비용과 다음 범위의 최소비용 더하기
        DP[n][a][b] =  COSTS[n][a] + min(x, y)
    
    return DP[n][a][b]

# 출력
print( min (cost(0,0,1), cost(0,0,2), cost(0,1,0), cost(0,1,2), cost(0,2,0), cost(0,2,1)))
