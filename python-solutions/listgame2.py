import sys


def factors(n: int):
    count = 0
    d = 2
    while d * d <= n:
        while (n % d) == 0:
            n //= d
        d += 1
    if n > 1:
        count += 1
    return count


if __name__ == "__main__":
    x = int(sys.stdin.readline().strip())
    print(factors(x))
