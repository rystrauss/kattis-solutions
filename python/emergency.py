import sys

if __name__ == '__main__':
    n, k = map(int, sys.stdin.readline().strip().split(' '))
    n -= 1
    print(n if (n < k * 2) else k + n % k + 1)
