# 같은 문제: https://school.programmers.co.kr/learn/courses/30/lessons/42883

N, K = map(int,input().split())
number = input()
answer = []
start = 0
for num in number:
    while answer and K>0 and answer[-1] < num:
        answer.pop()
        K-=1
    answer.append(num)
for _ in range(K):
    answer.pop()

print("".join(answer))
