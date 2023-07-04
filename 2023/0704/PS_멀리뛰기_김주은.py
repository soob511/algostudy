# https://school.programmers.co.kr/learn/courses/30/lessons/12914

def solution(n):
    
    dp = [0 for i in range(n)]
    dp[0]=1
    if n>=2:
        dp[1]=2
    
    for i in range(2,n):
        dp[i]=(dp[i-1]+dp[i-2])%1234567
        
    return dp[n-1]
