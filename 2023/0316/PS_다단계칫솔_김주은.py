def solution(enroll, referral, seller, amount):
    L = len(enroll)+1
    d = dict()

    info = [i for i in range(L)]
    sums = [0 for i in range(L)]
    
    for idx, p in enumerate(enroll):
        d[p]=idx+1
        if referral[idx]=='-':
            info[idx+1]=0
        else:
            info[idx+1]=d[referral[idx]]
    
    for idx, name in enumerate(seller):
        person = d[name]
        price = amount[idx]*100
        
        while person!=0:
            if price<10:
                sums[person]+=price
                break
            else:
                forUp = price//10
                sums[person]+=price-forUp
                
                price=forUp
                person=info[person]
        
    return sums[1:]
