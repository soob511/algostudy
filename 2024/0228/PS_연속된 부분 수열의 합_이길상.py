def solution(seq, k):
    low = high = 0
    answer = [0, len(seq)]
    seqsum = 0
    
    while low < len(seq) and high < len(seq):
        if seqsum + seq[high] <= k:
            seqsum += seq[high]
            high += 1
            if seqsum == k:
                if high-low < answer[1]-answer[0]:
                    answer = [low, high]
        else:
            seqsum -= seq[low]
            low += 1
                
    answer[1]-=1
    return answer
