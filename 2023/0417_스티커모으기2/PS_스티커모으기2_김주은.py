def solution(sticker):

    l = len(sticker)

    if l==1:
        return sticker[0]

    # 첫번째 스티커 뜯기
    stickers = sticker[:-1]
    dp = [0]*(l-1)

    dp[0]=stickers[0]
    for i in range(1,l-1):
        if dp[i-1]<dp[i-2]+stickers[i]:
            dp[i]=dp[i-2]+stickers[i]
        else:
            dp[i]=dp[i-1]

    first = dp[-1]

    # 첫번째 스티커 붙이기
    stickers = sticker[1:]
    dp = [0]*(l-1)

    dp[0]=stickers[0]
    for i in range(1,l-1):
        if dp[i-1]<dp[i-2]+stickers[i]:
            dp[i]=dp[i-2]+stickers[i]
        else:
            dp[i]=dp[i-1]

    second = dp[-1]

    return max(first, second)
