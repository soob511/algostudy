import sys
input = sys.stdin.readline
print = sys.stdout.write

heap = []
for _ in range(int(input())):
    num = int(input())
    if num>0:
        idx = len(heap)
        heap.append(num)

        parent = (idx-1)//2
        while heap[parent] < heap[idx] and idx > 0:
            heap[parent], heap[idx] = heap[idx], heap[parent]
            idx = parent
            parent = (idx-1)//2
    
    else:
        if len(heap) == 0:
            print('0\n')
            continue
        print(str(heap[0]) + '\n')

        heap[-1], heap[0] = heap[0], heap[-1]
        heap.pop()

        idx = 0
        while True:
            child = idx*2+1
            if child+1 < len(heap) and heap[child] < heap[child+1]:
                child+=1
            if child >= len(heap) or heap[child] < heap[idx]:
                break
            heap[child], heap[idx] = heap[idx], heap[child]
            idx = child
