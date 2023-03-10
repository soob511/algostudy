N = int(input())
K = int(input())
SENSORS = list(map(int, input().split()))
SENSORS.sort()

total_range = SENSORS[-1] - SENSORS[0]

GAPS = [SENSORS[i] - SENSORS[i-1] for i in range(1, N)]
GAPS.sort()

print(sum(GAPS[:N-K]))
