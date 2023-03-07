def solution(s):

    L = len(s)
    
    maxL = 1
    
    for i in range(1,L):
        l=1
        for d in range(1,L):
            if i-d>=0 and i+d<L:
                if s[i-d] == s[i+d]:
                    l+=2
                    if maxL<l:
                        maxL=l
                else:
                    break
            else:
                break
        
        j=i+1
        if j<L and s[i]==s[j]:
            l=2
            for d in range(1,L):
                if i-d>=0 and j+d<L:
                    if s[i-d]==s[j+d]:
                        l+=2
                        if maxL<l:
                            maxL=l
                    else:
                        break
                else:
                    break
        
    return maxL
