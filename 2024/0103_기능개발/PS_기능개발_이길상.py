def solution(prog, spd):
    N = len(spd)
    days = [(100 - prog[n])//spd[n] + ((100 - prog[n])%spd[n] > 0) for n in range(N)]
    
    answer = []
    while days:
        day = days.pop(0)
        release = 1
        while days and days[0] <= day:
            days.pop(0)
            release += 1
        answer.append(release)
    
    return answer
