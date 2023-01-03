def solution(a):
    # 2개씩 묶을 수 있는 숫자의 개수
    count = [0 for i in a]
    # 묶음 체크. [0,1,0] 같은 경우 2개로 세는 것 방지
    check = [-1 for i in a]
    
    for n in range(len(a)):
        n_ = n-1;
        N = n+1;
        
        # 앞 숫자
        if n_>=0 and a[n_]!=a[n] and check[n_]!=a[n]:
            check[n_] = a[n]
            count[a[n]] += 1
            
        # 뒤 숫자
        elif N<len(a) and a[n]!=a[N] and check[N]!=a[n]:
            check[N] = a[n]
            count[a[n]] += 1
    
    answer = max(count)
    return answer*2
