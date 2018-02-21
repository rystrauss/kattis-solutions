import sys
import math


if __name__ == "__main__":
    for s in sys.stdin.readlines():
        s = s.strip()
        d = {}
        for c in s:
            if c in d:
                d[c] += 1
            else:
                d[c] = 1
        denominator = 1
        for c, n in d.items():
            if n > 1:
                denominator *= math.factorial(n)
        numerator = math.factorial(len(s))
        print(numerator//denominator)
