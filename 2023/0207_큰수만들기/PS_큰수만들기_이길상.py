def solution(number, k):
    answer = []
    start = 0
    for num in number:
        while answer and k>0 and answer[-1] < num:
            answer.pop()
            k-=1
        answer.append(num)
    for _ in range(k):
        answer.pop()
    
    return "".join(answer)
