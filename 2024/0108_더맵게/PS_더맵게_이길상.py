import heapq

def solution(scoville, K):
    # 우선순위 큐
    priority_queue = []
    for e in scoville:
        heapq.heappush(priority_queue, e)
        
    answer = 0
    # 하나가 남을 때까지 반복해서 섞기
    while len(priority_queue) > 1:
        # 가장 작은 게 K이상이면 멈춤
        if priority_queue[0] >= K:
            break
            
        first = heapq.heappop(priority_queue)
        second = heapq.heappop(priority_queue)
        
        # 섞어 넣고 횟수 증가
        heapq.heappush(priority_queue, first + second*2)
        answer += 1
    
    # 하나가 될때까지 섞어도 K 미만이면 -1
    if priority_queue[0] < K:
        return -1
    
    return answer
