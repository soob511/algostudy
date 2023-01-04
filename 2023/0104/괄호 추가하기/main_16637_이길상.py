N = int(input())
exp = input()

if N == 1:
    print(int(exp))
    exit(0)

op_num = N//2
len_num = N//2 + 1

def calc(op, x, y):
    if op == '+':
        return x + y
    if op == '-':
        return x - y
    if op == '*':
        return x * y


ans = -100
def next(idx, res):
    global ans

    if idx == N: 
        ans = max(ans, res)
        return

    x = int(exp[idx+1])
    next(idx+2, calc(exp[idx], res, x))


    if idx+2 == N:
        return

    y = int(exp[idx+3])
    x = calc(exp[idx+2], x, y)
    next(idx+4, calc(exp[idx], res, x))

next(1, int(exp[0]))
print(ans)
