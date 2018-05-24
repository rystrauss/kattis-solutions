from math import factorial
import sys


def nCr(n, r):
    return factorial(n) // (factorial(r) * factorial(n-r))


if __name__ == "__main__":
    sys.stdin.readline()
    for x in sys.stdin.readlines():
        x = int(x)
        print(nCr(x*2, x) // (x + 1))