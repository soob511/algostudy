def solution(storey):
    answer = 0

    while storey:
        num = storey % 10
        if num > 5:
            answer += (10 - num)
            storey += 10
        elif num < 5:
            answer += num
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += num
        storey //= 10

    return answer