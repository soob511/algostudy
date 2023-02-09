# https://school.programmers.co.kr/learn/courses/30/lessons/42840

def solution(answers):
    N = len(answers)
    supoja = [
        [1,2,3,4,5],
        [2,1,2,3,2,4,2,5],
        [3,3,1,1,2,2,4,4,5,5]
    ]
    score = [0,0,0]
    
    for i in range(N):
        for j in range(len(supoja)):
            if answers[i] == supoja[j][i%len(supoja[j])] :
                score[j] += 1
    
    answer = [i+1 for i in range(3) if score[i] == max(score)]
    return answer
