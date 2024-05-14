N = int(input())
scvs = list(map(int, input().split())) + [0]*(3-N)

# atk_count(x, y, z) 결과를 저장하기 위한 변수
DP = dict()

# 이전에 atk_count(x, y, z)를 계산한 적 있는지 판별
def dp_check(x, y, z):
    if x not in DP:
        DP[x] = dict()
    if y not in DP[x]:
        DP[x][y] = dict()
    if z not in DP[x][y]:
        DP[x][y][z] = -1
        return False

    return True

# x, y, z의 체력조합에 대한 최소 공격횟수
def atk_count(x, y, z):
    # 0 이하인 수는 0으로 만들고 오름차순 정렬
    x, y, z = sorted([max(0,x), max(0,y), max(0,z)])

    # 한번의 공격으로 끝나는지 확인
    if x <= 1 and y<= 3 and z <= 9:
        return 1
    
    if not dp_check(x, y, z):
        calc_min = min(atk_count(x-1, y-3, z-9),
            atk_count(x-1, y-9, z-3),
            atk_count(x-3, y-9, z-1),
            atk_count(x-3, y-1, z-9),
            atk_count(x-9, y-1, z-3),
            atk_count(x-9, y-3, z-1))
        DP[x][y][z] = calc_min + 1
    
    return DP[x][y][z]

# 계산 후 출력
print(atk_count(scvs[0], scvs[1], scvs[2]))
