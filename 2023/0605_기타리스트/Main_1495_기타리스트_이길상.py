N, S, M = map(int, input().split())

V = list(map(int, input().split()))

DP = [dict() for _ in range(N)]

# i 단계에서 v값으로 시작했을때 결과 볼륨을 반환하는 함수
def adjust(i, v):
    # 끝까지 갔을때
    if i == N:
        return v

    # DP에 저장되어있으면 계산 없이 바로 반환
    if v in DP[i]:
        return DP[i][v]
    

    # 볼륨 증가/감소 선택 중 최선의 결과 value에 저장
    value = -1
    if v+V[i] <= M:
        value = max(value, adjust(i+1, v+V[i]))
    if v-V[i] >= 0:
        value = max(value, adjust(i+1, v-V[i]))

    # DP 기록
    DP[i][v] = value

    return value

print(adjust(0, S))
