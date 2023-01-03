for t in range(int(input())):
    N = int(input())
    rank = [list(map(int, input().split())) for n in range(N)]
    rank.sort()

    mini = N+1
    answer = 0
    for r, i in rank:
        if i < mini:
            answer += 1
        mini = min(mini, i)
    
    print(answer)

