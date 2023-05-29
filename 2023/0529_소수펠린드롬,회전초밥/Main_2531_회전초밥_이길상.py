N, d, k, c = map(int, input().split())

sushi = [int(input()) for _ in range(N)]

count = 1
picked = [0 for _ in range(d+1)]
picked[c] = 1

for i in range(k):
    if picked[sushi[i]] == 0:
        count += 1
    picked[sushi[i]] += 1

answer = count
for i in range(N-1):
    picked[sushi[i]] -= 1
    if picked[sushi[i]] == 0:
        count -= 1
    
    if picked[sushi[(i+k)%N]] == 0:
        count += 1
    picked[sushi[(i+k)%N]] += 1
    
    answer = max(answer, count)

print(answer)
