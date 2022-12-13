import sys
from queue import PriorityQueue
sys.setrecursionlimit(100000)

N = int(input())
DIV = 1_000_000_007

def fibo(n):
    if n == 1:
        return [1, 1, 0]

    m = fibo(n//2)
    ans = [m[0]**2 + m[1]**2, m[0]*m[1] + m[1]*m[2], m[1]**2 + m[2]**2]
    if n%2 == 1:
        ans = [ans[0]+ans[1], ans[0], ans[1]]
    
    ans = [ans[0]%DIV, ans[1]%DIV, ans[2]%DIV,]
    return ans

print(fibo(N)[1])
