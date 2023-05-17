N = int(input())

if N < 10:
    print(N)

else:
    prev = [i for i in range(10)]
    curr = []

    count = 9

    while True:
        for num in prev:
            last = num%10
            for digit in range(last):
                curr.append(num*10 + digit)
                count += 1

                if count == N:
                    print(curr[-1])
                    exit(0)

        if not curr:
            print(-1)
            exit(0)

        prev = curr
        curr = []
