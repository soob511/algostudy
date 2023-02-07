def solution(number, k):
    answer = []
    N = len(number)
    start = 0
    while start+k < N:
        max_val = "0"
        max_idx = 0
        for idx in range(start, start+k+1):
            if int(number[idx]) > int(max_val):
                max_val = number[idx]
                max_idx = idx

        k -= (max_idx-start)
        start = max_idx+1
        answer.append(max_val)
        
    return "".join(answer)
