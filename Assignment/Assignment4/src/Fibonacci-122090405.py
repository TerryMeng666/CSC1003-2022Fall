t = int(input())
for c in range(t):
    n, d = map(int, input().split(", "))
    if d > n:
        print("invalid")
    else:
        f = [1] * n
        for i in range(2, n):
            f[i] = f[i - 1] + f[i - 2]
        for i in range(n - 1, n - d, -1):
            print(f[i], end=", ")
        if (d == 0):
            print()
        else:
            print(f[n - d])
