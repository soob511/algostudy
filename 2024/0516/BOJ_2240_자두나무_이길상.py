# 입력
T, W = map(int, input().split())
falling = [int(input()) for _ in range(T)]

# jadoo(t, w, i)를 저장하기 위한 배열
JADOO = [[[-1 for _ in range(3)] for _ in range(W+1)] for _ in range(T)]

# t초부터 w번 움직일수 있는 상태로 i번 나무 밑에서 시작하면 최대로 얻을수 있는 개수
def jadoo(t, w, i):
    if t == T:
        return 0
    
    # 아직 구해본적 없는 값일 경우
    if JADOO[t][w][i] < 0:

        # 지금 자두를 받아먹을수 있으면 1 추가
        current = 1 if falling[t] == i else 0

        # t+1초 이후에 대한 결과
        after = jadoo(t+1, w, i)

        # 움직일수 있는 횟수가 남아있다면
        if w > 0:
            other_tree = 1 if i==2 else 2
            moved = jadoo(t+1, w-1, other_tree)
            after = max(after, moved)
        
        # 배열에 저장
        JADOO[t][w][i] = current + after
    
    return JADOO[t][w][i]

# 출력
print(max(jadoo(0, W, 1), jadoo(0, W-1, 2)))
